package juuxel.uselessthings.common.block.item;

import juuxel.uselessthings.lib.LibBlockNames;
import net.minecraft.block.Block;

public class ItemBlockFenced extends ItemBlockUT
{
    public ItemBlockFenced(Block block)
    {
        super(block, stack -> stack.getMetadata() == 1 ? LibBlockNames.FENCED_LANG_POSTFIX : "");
    }
}
