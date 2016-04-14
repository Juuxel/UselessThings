package juuxel.uselessthings.common.util;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IBooleanBlock<B extends Block> extends IBlock<B>
{
    @Override
    @SideOnly(Side.CLIENT)
    default void initModel()
    {
        Item item = Item.getItemFromBlock(asBlock());

        for (boolean b : new boolean[] { false, true })
        {
            ModelResourceLocation location = new ModelResourceLocation(asBlock().getRegistryName() + getPostfix(b), "inventory");
            ModelLoader.registerItemVariants(item, location);
            ModelLoader.setCustomModelResourceLocation(item, b ? 1 : 0, location);
        }
    }

    String getPostfix(boolean b);

    interface Default extends IBooleanBlock<Block>
    {}
}
