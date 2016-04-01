package juuxel.uselessthings.client;

import juuxel.uselessthings.common.CommonProxy;
import juuxel.uselessthings.common.init.ModBlocks;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy
{
    @Override
    public void preInit(FMLPreInitializationEvent e)
    {
        super.preInit(e);

        ModBlocks.initModels();
    }
}
