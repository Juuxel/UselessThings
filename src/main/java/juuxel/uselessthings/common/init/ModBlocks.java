package juuxel.uselessthings.common.init;

import juuxel.uselessthings.common.block.*;
import juuxel.uselessthings.common.block.item.*;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.function.Function;

public class ModBlocks
{
    public static BlockUT woodenPlatform;
    public static BlockUT woodenStep;
    public static BlockUT woodenPost;
    public static BlockFlower2 flower;

    public static void init()
    {
        woodenPlatform = new BlockWoodenPlatform();
        woodenStep = new BlockWoodenStep();
        woodenPost = new BlockWoodenPost();
        flower = new BlockFlower2();

        register(woodenPlatform, ItemBlockFenced::new);
        register(woodenStep);
        register(woodenPost, ItemBlockWood::new);
        register(flower, ItemBlockFlower::new);
    }

    // A convenience method to register
    // blocks and their ItemBlocks.
    private static void register(Block block)
    {
        register(block, ItemBlockUT::new);
    }

    private static void register(Block block, Function<Block, ItemBlock> function)
    {
        GameRegistry.register(block);
        GameRegistry.register(function.apply(block));
    }

    @SideOnly(Side.CLIENT)
    public static void initModels()
    {
        woodenPlatform.initModel();
        woodenStep.initModel();
        woodenPost.initModel();
        flower.initModel();
    }
}
