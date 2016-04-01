package juuxel.uselessthings.common.init;

import juuxel.uselessthings.common.block.*;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks
{
    public static BlockUT woodenPlatform;
    public static BlockUT fencedWoodenPlatform;
    public static BlockUT woodenStep;
    public static BlockUT woodenPost;

    public static void init()
    {
        woodenPlatform = new BlockWoodenPlatform(false);
        fencedWoodenPlatform = new BlockWoodenPlatform(true);
        woodenStep = new BlockWoodenStep();
        woodenPost = new BlockWoodenPost();

        GameRegistry.registerBlock(woodenPlatform);
        GameRegistry.registerBlock(fencedWoodenPlatform);
        GameRegistry.registerBlock(woodenStep);
        GameRegistry.registerBlock(woodenPost);
    }

    @SideOnly(Side.CLIENT)
    public static void initModels()
    {
        woodenPlatform.initModel();
        fencedWoodenPlatform.initModel();
        woodenStep.initModel();
        woodenPost.initModel();
    }
}
