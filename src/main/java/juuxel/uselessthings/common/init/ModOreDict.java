package juuxel.uselessthings.common.init;

import juuxel.uselessthings.common.util.ItemStacks;
import net.minecraft.init.Blocks;
import net.minecraftforge.oredict.OreDictionary;

public class ModOreDict
{
    public static void init()
    {
        OreDictionary.registerOre("fenceWood", ItemStacks.withMetadata(ModBlocks.woodenPost, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("fenceWood", Blocks.OAK_FENCE);
        OreDictionary.registerOre("fenceWood", Blocks.SPRUCE_FENCE);
        OreDictionary.registerOre("fenceWood", Blocks.BIRCH_FENCE);
        OreDictionary.registerOre("fenceWood", Blocks.JUNGLE_FENCE);
        OreDictionary.registerOre("fenceWood", Blocks.ACACIA_FENCE);
        OreDictionary.registerOre("fenceWood", Blocks.DARK_OAK_FENCE);
    }
}
