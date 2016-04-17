package juuxel.uselessthings.common.block;

import juuxel.uselessthings.common.util.IVariantBlock;
import juuxel.uselessthings.common.util.ItemStacks;
import juuxel.uselessthings.lib.LibBlockNames;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class BlockWoodenStep extends BlockUT implements IVariantBlock.Default<BlockPlanks.EnumType>
{
    public static final PropertyEnum<BlockPlanks.EnumType> VARIANT = PropertyEnum.create("variant", BlockPlanks.EnumType.class);

    private static final AxisAlignedBB BOUNDS = new AxisAlignedBB(0, 0, 0, 1, 0.5F, 1);

    public BlockWoodenStep()
    {
        super(Material.WOOD);

        setSoundType(SoundType.WOOD);
        setName(LibBlockNames.WOODEN_STEP);
        setHardness(1.5F);
        setResistance(5.0F);
        setDefaultState(getBlockState().getBaseState().withProperty(VARIANT, BlockPlanks.EnumType.OAK));
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
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, VARIANT);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void initModel()
    {
        IVariantBlock.Default.super.initModel();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list)
    {
        for (BlockPlanks.EnumType type : BlockPlanks.EnumType.values())
        {
            list.add(ItemStacks.withMetadata(itemIn, type.getMetadata()));
        }
    }

    @Override
    public PropertyEnum<BlockPlanks.EnumType> getVariantProperty()
    {
        return VARIANT;
    }

    @Override
    public String getModelName(BlockPlanks.EnumType enumType)
    {
        return enumType.getName() + LibBlockNames.STEP_POSTFIX;
    }
}
