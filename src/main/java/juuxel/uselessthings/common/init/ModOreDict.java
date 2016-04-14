package juuxel.uselessthings.common.init;

import net.minecraft.init.Blocks;
import net.minecraftforge.oredict.OreDictionary;

public class ModOreDict
{
    public static void init()
    {
        OreDictionary.registerOre("fenceWood", ModBlocks.woodenPost.asBlock());
        OreDictionary.registerOre("fenceWood", Blocks.OAK_FENCE);
        OreDictionary.registerOre("fenceWood", Blocks.SPRUCE_FENCE);
        OreDictionary.registerOre("fenceWood", Blocks.BIRCH_FENCE);
        OreDictionary.registerOre("fenceWood", Blocks.JUNGLE_FENCE);
        OreDictionary.registerOre("fenceWood", Blocks.ACACIA_FENCE);
        OreDictionary.registerOre("fenceWood", Blocks.DARK_OAK_FENCE);
    }
}
