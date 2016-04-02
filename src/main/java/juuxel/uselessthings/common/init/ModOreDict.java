package juuxel.uselessthings.common.init;

import net.minecraft.init.Blocks;
import net.minecraftforge.oredict.OreDictionary;

public class ModOreDict
{
    public static void init()
    {
        OreDictionary.registerOre("fenceWood", ModBlocks.woodenPost);
        OreDictionary.registerOre("fenceWood", Blocks.oak_fence);
        OreDictionary.registerOre("fenceWood", Blocks.spruce_fence);
        OreDictionary.registerOre("fenceWood", Blocks.birch_fence);
        OreDictionary.registerOre("fenceWood", Blocks.jungle_fence);
        OreDictionary.registerOre("fenceWood", Blocks.acacia_fence);
        OreDictionary.registerOre("fenceWood", Blocks.dark_oak_fence);
    }
}
