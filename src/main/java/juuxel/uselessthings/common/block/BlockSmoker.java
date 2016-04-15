package juuxel.uselessthings.common.block;

import juuxel.uselessthings.common.util.ISimpleEnum;
import juuxel.uselessthings.common.util.IVariantBlock;
import juuxel.uselessthings.common.util.ItemStacks;
import juuxel.uselessthings.lib.LibBlockNames;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

public class BlockSmoker extends BlockUT implements IVariantBlock.Default<BlockSmoker.Type>
{
    public static final PropertyEnum<Type> TYPE = PropertyEnum.create("type", BlockSmoker.Type.class);

    public BlockSmoker()
    {
        setTickRandomly(true);
        setSoundType(SoundType.STONE);
        setHardness(2F);
        setName(LibBlockNames.SMOKER);
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return getMetaFromState(state);
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return getDefaultState().withProperty(TYPE, Type.byMetadata(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(TYPE).ordinal();
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, TYPE);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list)
    {
        for (int i = 0; i < Type.values().length - 1; i++)
        {
            list.add(ItemStacks.withMetadata(itemIn, i));
        }
    }

    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        IBlockState state = super.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer);

        return checkRedstoneSignal(worldIn, pos, state);
    }

    @Override
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
        worldIn.setBlockState(pos, checkRedstoneSignal(worldIn, pos, state));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
        if (stateIn.getValue(TYPE) == Type.IGNORE_REDSTONE || worldIn.isBlockPowered(pos))
        {
            double x = pos.getX() + 0.5;
            double y = pos.getY() + 0.9;
            double z = pos.getZ() + 0.5;

            for (int i = 0; i < 3; i++)
            {
                worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, x, y, z, 0, 0, 0);
            }
        }
    }

    @Override
    public int tickRate(World worldIn)
    {
        return 3;
    }

    private IBlockState checkRedstoneSignal(World worldIn, BlockPos pos, IBlockState state)
    {
        if (state.getValue(TYPE) != Type.IGNORE_REDSTONE)
            return state.withProperty(TYPE, Type.fromBoolean(worldIn.isBlockPowered(pos)));

        return state;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void initModel()
    {
        IVariantBlock.Default.super.initModel();
    }

    @Override
    public PropertyEnum<Type> getVariantProperty()
    {
        return TYPE;
    }

    @Override
    public String getModelName(Type type)
    {
        return LibBlockNames.SMOKER + type.getModelPostfix();
    }

    @Override
    public boolean accept(Type type)
    {
        return type != Type.POWERED;
    }

    public enum Type implements ISimpleEnum
    {
        IGNORE_REDSTONE,
        NOT_POWERED,
        POWERED;

        public String getModelPostfix()
        {
            return this == IGNORE_REDSTONE ? "" : LibBlockNames.POWERED_POSTFIX;
        }

        public String getNamePostfix()
        {
            return this == IGNORE_REDSTONE ? "" : LibBlockNames.POWERED_LANG_POSTFIX;
        }

        public static Type byMetadata(int meta)
        {
            int clamp = MathHelper.clamp_int(meta, 0, values().length);

            return values()[clamp];
        }

        public static Type fromBoolean(boolean b)
        {
            return b ? POWERED : NOT_POWERED;
        }
    }
}
