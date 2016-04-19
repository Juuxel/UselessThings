package juuxel.uselessthings.common.util;

import juuxel.uselessthings.lib.LibMisc;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IBlock<B extends Block>
{
    @SideOnly(Side.CLIENT)
    default void initModel()
    {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(asBlock()), 0, new ModelResourceLocation(asBlock().getRegistryName(), "inventory"));
    }

    @SuppressWarnings("unchecked")
    default B asBlock()
    {
        return this instanceof Block ? (B) this : null;
    }

    default Item asItem()
    { return Item.getItemFromBlock(asBlock()); }

    default void setName(String name)
    {
        Block block = asBlock();

        block.setUnlocalizedName(LibMisc.ID_LOWER + "." + name);
        block.setRegistryName(name);
    }

    interface Default extends IBlock<Block>
    {}
}
