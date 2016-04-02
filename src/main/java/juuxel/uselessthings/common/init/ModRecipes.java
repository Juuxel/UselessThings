package juuxel.uselessthings.common.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

import static juuxel.uselessthings.common.init.ModBlocks.*;

public class ModRecipes
{
    public static void init()
    {
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(woodenPlatform, 6), "SSS", 'S', "slabWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(woodenPost), "S", "S", 'S', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(fencedWoodenPlatform), "P", "F", 'P', woodenPlatform, 'F', "fenceWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(woodenStep, 2), "S", "F", 'S', "slabWood", 'F', "fenceWood"));
    }
}
