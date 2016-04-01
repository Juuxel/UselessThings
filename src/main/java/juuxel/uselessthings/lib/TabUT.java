package juuxel.uselessthings.lib;

import juuxel.uselessthings.common.init.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabUT extends CreativeTabs
{
    public static final TabUT TAB_UT = new TabUT();

    private TabUT()
    {
        super(LibMisc.ID_LOWER);
    }

    @Override
    public Item getTabIconItem()
    {
        return Item.getItemFromBlock(ModBlocks.fencedWoodenPlatform);
    }
}
