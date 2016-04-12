package juuxel.uselessthings.common.block.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemBlockUT extends ItemBlock
{
    public ItemBlockUT(Block block)
    {
        super(block);

        setRegistryName(block.getRegistryName());
    }
}
