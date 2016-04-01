package juuxel.uselessthings.common;

import juuxel.uselessthings.common.init.ModBlocks;
import net.minecraftforge.fml.common.event.*;

public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent e)
    {
        ModBlocks.init();
    }

    public void init(FMLInitializationEvent e)
    {

    }

    public void postInit(FMLPostInitializationEvent e)
    {

    }
}
