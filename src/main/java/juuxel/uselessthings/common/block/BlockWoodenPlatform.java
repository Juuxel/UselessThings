package juuxel.uselessthings.common.block;

import juuxel.uselessthings.lib.LibBlockNames;
import net.minecraft.block.BlockFence;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class BlockWoodenPlatform extends BlockUT
{
    public static PropertyBool FENCE = PropertyBool.create("fence");
    public static PropertyBool VISUAL_FENCE = PropertyBool.create("visual_fence");

    private static final AxisAlignedBB BOUNDS = new AxisAlignedBB(0, 0.75, 0, 1, 1, 1);
    private static final AxisAlignedBB POST = new AxisAlignedBB(0.375, 0, 0.375, 0.625, 1, 0.625);

    public BlockWoodenPlatform()
    {
        super(Material.wood);

        setStepSound(SoundType.WOOD);
        setName(LibBlockNames.WOODEN_PLATFORM);
        setDefaultState(getBlockState().getBaseState().withProperty(FENCE, false).withProperty(VISUAL_FENCE, false));
        setHardness(1.5F);
        setResistance(5.0F);
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        return state.withProperty(VISUAL_FENCE, hasFence(state, worldIn, pos));
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return getMetaFromState(state);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(FENCE) ? 1 : 0;
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return getDefaultState().withProperty(FENCE, meta == 1);
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, FENCE, VISUAL_FENCE);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return hasFence(state, source, pos) ? FULL_BLOCK_AABB : BOUNDS;
    }

    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB boundingBox, List<AxisAlignedBB> list, Entity entity)
    {
        state = getActualState(state, worldIn, pos);
        addCollisionBoxToList(pos, boundingBox, list, BOUNDS);

        if (state.getValue(VISUAL_FENCE))
            addCollisionBoxToList(pos, boundingBox, list, POST);
    }

    @Override
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list)
    {
        list.add(new ItemStack(itemIn));
        list.add(new ItemStack(itemIn, 1, 1));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void initModel()
    {
        for (int i = 0; i < 2; i++)
        {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), i, new ModelResourceLocation(getRegistryName() + (i == 1 ? LibBlockNames.FENCED_POSTFIX : ""), "inventory"));
        }
    }

    private boolean hasFence(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        return worldIn.getBlockState(pos.down()).getBlock() instanceof BlockFence || worldIn.getBlockState(pos.down()).getBlock() instanceof BlockWoodenPost || state.getValue(FENCE);
    }
}
