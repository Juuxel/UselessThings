package juuxel.uselessthings.client.gui;

import juuxel.uselessthings.common.util.Config;
import juuxel.uselessthings.lib.LibMisc;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GuiConfigUT extends GuiConfig
{
    public GuiConfigUT(GuiScreen parentScreen)
    {
        super(parentScreen, getConfigElements(), LibMisc.ID, false, false, LibMisc.NAME, getAbridgedConfigPath(Config.configuration.toString()));
    }

    private static List<IConfigElement> getConfigElements()
    {
        List<IConfigElement> list = new ArrayList<>();

        list.add(new ConfigElement(Config.configuration.getCategory(Config.CATEGORY_TWEAKS)));
        list.add(new ConfigElement(Config.configuration.getCategory(Config.CATEGORY_WORLD)));

        return list;
    }
}
