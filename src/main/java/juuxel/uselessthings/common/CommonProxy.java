package juuxel.uselessthings.common;

import juuxel.uselessthings.common.init.*;
import net.minecraftforge.fml.common.event.*;

public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent e)
    {
        ModBlocks.init();
        ModRecipes.init();
        ModOreDict.init();
    }

    public void init(FMLInitializationEvent e)
    {

    }

    public void postInit(FMLPostInitializationEvent e)
    {

    }
}
