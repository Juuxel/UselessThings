package juuxel.uselessthings.common.block;

import juuxel.uselessthings.lib.LibBlockNames;
import juuxel.uselessthings.lib.LibMisc;
import juuxel.uselessthings.lib.TabUT;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

// TODO Fix variants
public class BlockFlower2 extends BlockBush
{
    public static PropertyEnum<Type> VARIANT = PropertyEnum.create("variant", Type.class);

    public BlockFlower2()
    {
        setUnlocalizedName(LibMisc.ID_LOWER + "." + LibBlockNames.FLOWER);
        setRegistryName(LibBlockNames.FLOWER);
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

    @SideOnly(Side.CLIENT)
    public void initModel()
    {
        for (int i = 0; i < Type.values().length; i++)
        {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), i, new ModelResourceLocation(LibMisc.ID_LOWER + ":" + Type.byMetadata(i).getName(), "inventory"));
        }
    }

    public enum Type implements IStringSerializable
    {
        ROSE("rose", MapColor.RED),
        SHORT_PEONY("short_peony", MapColor.PINK);

        private final String name;
        private final MapColor color;

        Type(String name, MapColor color)
        {
            this.name = name;
            this.color = color;
        }

        @Override
        public String getName()
        {
            return name;
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
