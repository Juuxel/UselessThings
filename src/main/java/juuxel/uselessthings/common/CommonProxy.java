package juuxel.uselessthings.common;

import juuxel.uselessthings.common.init.*;
import juuxel.uselessthings.common.util.Config;
import net.minecraftforge.fml.common.event.*;

public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent e)
    {
        Config.init(e.getSuggestedConfigurationFile());
        ModBlocks.init();
        ModRecipes.init();
        ModOreDict.init();
        ModTweaks.init();
        ModWorldGen.init();
    }

    public void init(FMLInitializationEvent e)
    {

    }

    public void postInit(FMLPostInitializationEvent e)
    {

    }
}
