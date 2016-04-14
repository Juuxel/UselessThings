package juuxel.uselessthings.common.block;

import juuxel.uselessthings.common.util.ISimpleEnum;
import juuxel.uselessthings.common.util.IVariantBlock;
import juuxel.uselessthings.lib.LibBlockNames;
import juuxel.uselessthings.lib.TabUT;
import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class BlockFlower2 extends BlockBush implements IVariantBlock<BlockFlower2.Type, BlockBush>
{
    public static PropertyEnum<Type> VARIANT = PropertyEnum.create("variant", Type.class);

    public BlockFlower2()
    {
        setName(LibBlockNames.FLOWER);
        setDefaultState(getBlockState().getBaseState().withProperty(VARIANT, Type.ROSE));
        setCreativeTab(TabUT.TAB_UT);
        setSoundType(SoundType.PLANT);
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, VARIANT);
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return getMetaFromState(state);
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return getDefaultState().withProperty(VARIANT, Type.byMetadata(meta));
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player)
    {
        return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(state));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(VARIANT).ordinal();
    }

    @Override
    public MapColor getMapColor(IBlockState state)
    {
        return state.getValue(VARIANT).getColor();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list)
    {
        for (int i = 0; i < Type.values().length; i++)
        {
            list.add(new ItemStack(itemIn, 1, i));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumOffsetType getOffsetType()
    {
        return EnumOffsetType.XZ;
    }

    @Override
    public PropertyEnum<Type> getVariantProperty()
    {
        return VARIANT;
    }

    public enum Type implements ISimpleEnum
    {
        ROSE(MapColor.RED),
        SHORT_PEONY(MapColor.PINK);

        private final MapColor color;

        Type(MapColor color)
        {
            this.color = color;
        }

        public MapColor getColor()
        {
            return color;
        }

        public static Type byMetadata(int meta)
        {
            int clamped = MathHelper.clamp_int(meta, 0, values().length - 1);

            return values()[clamped];
        }
    }
}
