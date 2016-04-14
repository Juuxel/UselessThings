package juuxel.uselessthings.common.init;

import juuxel.uselessthings.common.util.BlockUtils;
import net.minecraft.block.BlockPlanks;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

import static juuxel.uselessthings.common.init.ModBlocks.*;

public class ModRecipes
{
    public static void init()
    {
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(woodenPlatform.asBlock(), 6), "SSS", 'S', "slabWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(woodenPlatform.asBlock(), 1, 1), "P", "F", 'P', woodenPlatform, 'F', "fenceWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(woodenStep.asBlock(), 2), "S", "F", 'S', "slabWood", 'F', "fenceWood"));

        for (BlockPlanks.EnumType type : BlockPlanks.EnumType.values())
        {
            GameRegistry.addRecipe(new ItemStack(woodenPost.asBlock(), 4, type.getMetadata()), "F", "F", 'F', new ItemStack(BlockUtils.getFence(type)));
        }

        GameRegistry.addRecipe(new ItemStack(Items.DYE, 1, 1), "R", 'R', new ItemStack(ModBlocks.flower.asBlock(), 1, 0));
        GameRegistry.addRecipe(new ItemStack(Items.DYE, 1, 9), "P", 'P', new ItemStack(ModBlocks.flower.asBlock(), 1, 1));
        GameRegistry.addRecipe(new ItemStack(smoker.asBlock()), "B B", "BFB", 'B', Blocks.BRICK_BLOCK, 'F', Items.FLINT_AND_STEEL);
        GameRegistry.addShapelessRecipe(new ItemStack(smoker.asBlock(), 1, 1), new ItemStack(smoker.asBlock()), Blocks.REDSTONE_TORCH);
    }
}
