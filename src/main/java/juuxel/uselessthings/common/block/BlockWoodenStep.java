package juuxel.uselessthings.common.block;

import juuxel.uselessthings.lib.LibBlockNames;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockWoodenStep extends BlockUT
{
    private static final AxisAlignedBB BOUNDS = new AxisAlignedBB(0, 0, 0, 1, 0.5F, 1);

    public BlockWoodenStep()
    {
        super(Material.wood);

        setStepSound(SoundType.WOOD);
        setName(LibBlockNames.WOODEN_STEP);
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
}
