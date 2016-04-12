package juuxel.uselessthings.common.block;

import juuxel.uselessthings.lib.LibBlockNames;
import juuxel.uselessthings.lib.LibMisc;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

// TODO Fix variants
public class BlockWoodenPost extends BlockUT
{
    public static PropertyEnum<BlockPlanks.EnumType> VARIANT = PropertyEnum.create("variant", BlockPlanks.EnumType.class);

    private static final AxisAlignedBB BOUNDS = new AxisAlignedBB(0.375, 0, 0.375, 0.625, 1, 0.625);

    public BlockWoodenPost()
    {
        super(Material.WOOD);

        setSoundType(SoundType.WOOD);
        setName(LibBlockNames.WOODEN_POST);
        setDefaultState(getBlockState().getBaseState().withProperty(VARIANT, BlockPlanks.EnumType.OAK));
        setHardness(2.0F);
        setResistance(5.0F);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return BOUNDS;
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return getMetaFromState(state);
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return getDefaultState().withProperty(VARIANT, BlockPlanks.EnumType.byMetadata(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(VARIANT).getMetadata();
    }

    @Override
    public MapColor getMapColor(IBlockState state)
    {
        return state.getValue(VARIANT).getMapColor();
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, VARIANT);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list)
    {
        for (int i = 0; i < BlockPlanks.EnumType.values().length; i++)
        {
            list.add(new ItemStack(itemIn, 1, i));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void initModel()
    {
        for (int i = 0; i < BlockPlanks.EnumType.values().length; i++)
        {
            ModelLoader.setCustomModelResourceLocation(
                Item.getItemFromBlock(this), i,
                new ModelResourceLocation(
                    LibMisc.ID_LOWER + ":" + BlockPlanks.EnumType.values()[i].getName() + LibBlockNames.POST_POSTFIX, "inventory"
                )
            );
        }
    }
}
