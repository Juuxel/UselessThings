package juuxel.uselessthings.common.util;

import juuxel.uselessthings.lib.LibMisc;
import net.minecraft.block.Block;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IVariantBlock<E extends Enum<E> & IStringSerializable, B extends Block> extends IBlock<B>
{
    @Override
    @SideOnly(Side.CLIENT)
    default void initModel()
    {
        Item item = Item.getItemFromBlock(asBlock());

        for (E e : getVariantProperty().getValueClass().getEnumConstants())
        {
            if (!accept(e))
                continue;

            ModelResourceLocation location = new ModelResourceLocation(LibMisc.ID_LOWER + ":" + getModelName(e), "inventory");
            ModelLoader.registerItemVariants(item, location);
            ModelLoader.setCustomModelResourceLocation(item, e.ordinal(), location);
            System.out.println(location.toString()); // TODO Remove debug
        }
    }

    PropertyEnum<E> getVariantProperty();

    default boolean accept(@SuppressWarnings("unused") E e)
    { return true; }

    default String getModelName(E e)
    { return e.getName(); }

    interface Default<E extends Enum<E> & IStringSerializable> extends IVariantBlock<E, Block>
    {}
}
