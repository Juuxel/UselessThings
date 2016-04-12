package juuxel.uselessthings.common.block.item;

import juuxel.uselessthings.common.block.BlockFlower2;
import net.minecraft.block.Block;

public class ItemBlockFlower extends ItemBlockMulti
{
    public ItemBlockFlower(Block block)
    {
        super(block, itemStack -> "." + BlockFlower2.Type.byMetadata(itemStack.getMetadata()).getName());
    }
}
