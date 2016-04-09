package juuxel.uselessthings.common.init;

import juuxel.uselessthings.common.util.BlockUtils;
import net.minecraft.block.BlockPlanks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

import static juuxel.uselessthings.common.init.ModBlocks.*;

public class ModRecipes
{
    public static void init()
    {
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(woodenPlatform, 6), "SSS", 'S', "slabWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(woodenPlatform, 1, 1), "P", "F", 'P', woodenPlatform, 'F', "fenceWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(woodenStep, 2), "S", "F", 'S', "slabWood", 'F', "fenceWood"));

        for (BlockPlanks.EnumType type : BlockPlanks.EnumType.values())
        {
            GameRegistry.addRecipe(new ItemStack(woodenPost, 4, type.getMetadata()), "F", "F", 'F', new ItemStack(BlockUtils.getFence(type)));
        }
    }
}
