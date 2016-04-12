package juuxel.uselessthings.common.util;

import juuxel.uselessthings.lib.LibMisc;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

public class Config
{
    public static final String CATEGORY_TWEAKS = "tweaks";
    public static final String CATEGORY_WORLD = "world";

    public static Configuration configuration;

    public static boolean enableVanillaEggs;
    public static boolean enableCreativeSpawner;
    public static boolean enableCreativeCommandBlocks;
    public static int flowerAmount;

    public static void init(File file)
    {
        if (configuration == null)
        {
            configuration = new Configuration(file);
            loadConfiguration();
        }
    }

    private static void loadConfiguration()
    {
        enableVanillaEggs = configuration.getBoolean("enableVanillaEggs", CATEGORY_TWEAKS, true, "If true, enables additional spawn eggs for vanilla mobs.");
        enableCreativeSpawner = configuration.getBoolean("enableCreativeSpawner", CATEGORY_TWEAKS, true, "If true, shows the mob spawner in the creative inventory.");
        enableCreativeCommandBlocks = configuration.getBoolean("enableCreativeCommandBlocks", CATEGORY_TWEAKS, false, "If true, shows the command blocks in the creative inventory.");
        flowerAmount = configuration.getInt("flowerAmount", CATEGORY_WORLD, 1, 0, 64, "Defines the amount of mod flowers you will get in your world. To disable, set to 0.");

        if (configuration.hasChanged())
            configuration.save();
    }

    @SuppressWarnings("unused")
    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.getModID().equalsIgnoreCase(LibMisc.ID))
            loadConfiguration();
    }
}
