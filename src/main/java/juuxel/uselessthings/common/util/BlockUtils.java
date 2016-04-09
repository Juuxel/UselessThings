package juuxel.uselessthings.common.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.init.Blocks;

public final class BlockUtils
{
    public static Block getFence(BlockPlanks.EnumType type)
    {
        switch (type)
        {
            case OAK:
                return Blocks.oak_fence;
            case SPRUCE:
                return Blocks.spruce_fence;
            case BIRCH:
                return Blocks.birch_fence;
            case JUNGLE:
                return Blocks.jungle_fence;
            case ACACIA:
                return Blocks.acacia_fence;
            case DARK_OAK:
                return Blocks.dark_oak_fence;
            default:
                return Blocks.oak_fence;
        }
    }
}
