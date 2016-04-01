package juuxel.uselessthings.common.block;

import juuxel.uselessthings.lib.LibBlockNames;
import net.minecraft.block.BlockFence;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

public class BlockWoodenPlatform extends BlockUT
{
    public static PropertyBool FENCE = PropertyBool.create("fence");

    private static final AxisAlignedBB BOUNDS = new AxisAlignedBB(0, 0.75, 0, 1, 1, 1);
    private static final AxisAlignedBB POST = new AxisAlignedBB(0.375, 0, 0.375, 0.625, 1, 0.625);

    private final boolean forceFence;

    public BlockWoodenPlatform(boolean forceFence)
    {
        super(Material.wood);

        this.forceFence = forceFence;

        setStepSound(SoundType.WOOD);
        setName((forceFence ? LibBlockNames.FENCED_PREFIX : "") + LibBlockNames.WOODEN_PLATFORM);
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        return state.withProperty(FENCE, hasFence(worldIn, pos));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return 0;
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
        return hasFence(source, pos) ? FULL_BLOCK_AABB : BOUNDS;
    }

    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB boundingBox, List<AxisAlignedBB> list, Entity entity)
    {
        state = getActualState(state, worldIn, pos);
        addCollisionBoxToList(pos, boundingBox, list, BOUNDS);

        if (state.getValue(FENCE))
            addCollisionBoxToList(pos, boundingBox, list, POST);
    }

    private boolean hasFence(IBlockAccess worldIn, BlockPos pos)
    {
        return worldIn.getBlockState(pos.down()).getBlock() instanceof BlockFence || worldIn.getBlockState(pos.down()).getBlock() instanceof BlockWoodenPost || forceFence;
    }
}
