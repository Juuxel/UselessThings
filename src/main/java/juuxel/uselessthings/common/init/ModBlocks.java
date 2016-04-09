package juuxel.uselessthings.common.init;

import juuxel.uselessthings.common.block.*;
import juuxel.uselessthings.common.block.item.*;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks
{
    public static BlockUT woodenPlatform;
    public static BlockUT woodenStep;
    public static BlockUT woodenPost;

    public static void init()
    {
        woodenPlatform = new BlockWoodenPlatform();
        woodenStep = new BlockWoodenStep();
        woodenPost = new BlockWoodenPost();

        GameRegistry.registerBlock(woodenPlatform, ItemBlockFenced.class);
        GameRegistry.registerBlock(woodenStep);
        GameRegistry.registerBlock(woodenPost, ItemBlockWood.class);
    }

    @SideOnly(Side.CLIENT)
    public static void initModels()
    {
        woodenPlatform.initModel();
        woodenStep.initModel();
        woodenPost.initModel();
    }
}
