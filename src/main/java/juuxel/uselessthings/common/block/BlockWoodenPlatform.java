package juuxel.uselessthings.common.block;

import juuxel.uselessthings.common.util.IBooleanBlock;
import juuxel.uselessthings.lib.LibBlockNames;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class BlockWoodenPlatform extends BlockUT implements IBooleanBlock.Default
{
    public static PropertyBool FENCE = PropertyBool.create("fence");

    private static final AxisAlignedBB BOUNDS = new AxisAlignedBB(0, 0.75, 0, 1, 1, 1);
    private static final AxisAlignedBB POST = new AxisAlignedBB(0.375, 0, 0.375, 0.625, 1, 0.625);

    public BlockWoodenPlatform()
    {
        super(Material.WOOD);

        setSoundType(SoundType.WOOD);
        setName(LibBlockNames.WOODEN_PLATFORM);
        setDefaultState(getBlockState().getBaseState().withProperty(FENCE, false));
        setHardness(1.5F);
        setResistance(5.0F);
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
        return new BlockStateContainer(this, FENCE);
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
        return state.getValue(FENCE) ? FULL_BLOCK_AABB : BOUNDS;
    }

    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB boundingBox, List<AxisAlignedBB> list, Entity entity)
    {
        addCollisionBoxToList(pos, boundingBox, list, BOUNDS);

        if (state.getValue(FENCE))
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
        IBooleanBlock.Default.super.initModel();
    }

    @Override
    public String getPostfix(boolean b)
    {
        return b ? LibBlockNames.FENCED_POSTFIX : "";
    }
}
