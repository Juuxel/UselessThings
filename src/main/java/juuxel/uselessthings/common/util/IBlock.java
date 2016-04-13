package juuxel.uselessthings.common.util;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IBlock
{
    @SideOnly(Side.CLIENT)
    default void initModel()
    {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(asBlock()), 0, new ModelResourceLocation(asBlock().getRegistryName(), "inventory"));
    }

    default Block asBlock()
    {
        return this instanceof Block ? (Block) this : null;
    }
}
