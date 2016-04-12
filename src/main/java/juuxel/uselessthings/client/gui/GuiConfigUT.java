package juuxel.uselessthings.client.gui;

import juuxel.uselessthings.common.util.Config;
import juuxel.uselessthings.lib.LibMisc;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;

import java.util.Collections;

public class GuiConfigUT extends GuiConfig
{
    public GuiConfigUT(GuiScreen parentScreen)
    {
        super(parentScreen, Collections.singletonList(new ConfigElement(Config.configuration.getCategory(Config.CATEGORY_TWEAKS))), LibMisc.ID, false, false, LibMisc.NAME, getAbridgedConfigPath(Config.configuration.toString()));
    }
}
