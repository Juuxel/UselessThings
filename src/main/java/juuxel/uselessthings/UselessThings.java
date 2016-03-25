package juuxel.uselessthings;

import juuxel.uselessthings.common.CommonProxy;
import juuxel.uselessthings.lib.LibMisc;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;
import org.apache.logging.log4j.Logger;

@Mod(modid = LibMisc.ID, name = LibMisc.NAME, version = LibMisc.VERSION, useMetadata = true)
public class UselessThings
{
    @SidedProxy(
        clientSide = "juuxel.uselessthings.client.ClientProxy",
        serverSide = "juuxel.uselessthings.common.CommonProxy"
    )
    public static CommonProxy proxy;

    @Mod.Instance
    public static UselessThings instance;

    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
        logger = e.getModLog();
        proxy.preInit(e);
    }

    @EventHandler
    public void init(FMLInitializationEvent e)
    {
        proxy.init(e);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e)
    {
        proxy.postInit(e);
    }
}
