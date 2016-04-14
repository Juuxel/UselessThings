package juuxel.uselessthings.common.block.item;

import juuxel.uselessthings.common.block.BlockSmoker;
import net.minecraft.block.Block;

public class ItemBlockSmoker extends ItemBlockMulti
{
    public ItemBlockSmoker(Block block)
    {
        super(block, stack -> BlockSmoker.Type.byMetadata(stack.getMetadata()).getNamePostfix());
    }
}
