package juuxel.uselessthings.common.block.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;

public class ItemBlockWood extends ItemBlockMulti
{
    public ItemBlockWood(Block block)
    {
        super(block, stack -> "." + BlockPlanks.EnumType.byMetadata(stack.getMetadata()).getName());
    }
}
