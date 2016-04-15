package juuxel.uselessthings.common.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public final class ItemStacks
{
    public static ItemStack withMetadata(Item item, int meta)
    { return new ItemStack(item, 1, meta); }

    public static ItemStack withMetadata(IBlock block, int meta)
    { return withMetadata(block.asItem(), meta); }
}
