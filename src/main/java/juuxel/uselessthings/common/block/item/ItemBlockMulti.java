package juuxel.uselessthings.common.block.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import java.util.function.Function;

public class ItemBlockMulti extends ItemBlockUT
{
    private final Function<ItemStack, String> function;

    public ItemBlockMulti(Block block, Function<ItemStack, String> function)
    {
        super(block);

        this.function = function;
    }

    @Override
    public int getMetadata(int damage)
    {
        return damage;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return getUnlocalizedName() + function.apply(stack);
    }
}
