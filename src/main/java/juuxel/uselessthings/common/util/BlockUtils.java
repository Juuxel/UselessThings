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
                return Blocks.OAK_FENCE;
            case SPRUCE:
                return Blocks.SPRUCE_FENCE;
            case BIRCH:
                return Blocks.BIRCH_FENCE;
            case JUNGLE:
                return Blocks.JUNGLE_FENCE;
            case ACACIA:
                return Blocks.ACACIA_FENCE;
            case DARK_OAK:
                return Blocks.DARK_OAK_FENCE;
            default:
                return Blocks.OAK_FENCE;
        }
    }
}
