package juuxel.uselessthings.common.init;

import juuxel.uselessthings.common.block.*;
import juuxel.uselessthings.common.block.item.*;
import juuxel.uselessthings.common.util.IBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashSet;
import java.util.function.Function;

public class ModBlocks
{
    private static final HashSet<IBlock> BLOCKS = new HashSet<>();

    public static IBlock woodenPlatform;
    public static IBlock woodenStep;
    public static IBlock woodenPost;
    public static IBlock<BlockBush> flower;
    public static IBlock smoker;

    public static void init()
    {
        woodenPlatform = new BlockWoodenPlatform();
        woodenStep = new BlockWoodenStep();
        woodenPost = new BlockWoodenPost();
        flower = new BlockFlower2();
        smoker = new BlockSmoker();

        register(woodenPlatform, ItemBlockFenced::new);
        register(woodenStep, ItemBlockWood::new);
        register(woodenPost, ItemBlockWood::new);
        register(flower, ItemBlockFlower::new);
        register(smoker, ItemBlockSmoker::new);
    }

    // A convenience method to register
    // blocks and their ItemBlocks.
    // Also adds them to the initModel list.
    private static void register(IBlock block)
    {
        register(block, ItemBlockUT::new);
    }

    private static void register(IBlock block, Function<Block, ItemBlock> function)
    {
        BLOCKS.add(block);
        GameRegistry.register(block.asBlock());
        GameRegistry.register(function.apply(block.asBlock()));
    }

    @SideOnly(Side.CLIENT)
    public static void initModels()
    {
        BLOCKS.forEach(IBlock::initModel);
    }
}
