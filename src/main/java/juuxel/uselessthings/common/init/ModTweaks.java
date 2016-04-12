package juuxel.uselessthings.common.init;

import juuxel.uselessthings.common.util.Config;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModTweaks
{
    public static void init()
    {
        initVanillaTabs();
        initVanillaEggs();
    }

    private static void initVanillaTabs()
    {
        if (Config.enableCreativeSpawner)
            Blocks.MOB_SPAWNER.setCreativeTab(CreativeTabs.DECORATIONS);

        if (Config.enableCreativeCommandBlocks)
        {
            Blocks.COMMAND_BLOCK.setCreativeTab(CreativeTabs.MISC);
            Blocks.CHAIN_COMMAND_BLOCK.setCreativeTab(CreativeTabs.MISC);
            Blocks.REPEATING_COMMAND_BLOCK.setCreativeTab(CreativeTabs.MISC);
        }
    }

    private static void initVanillaEggs()
    {
        if (Config.enableVanillaEggs)
        {
            EntityRegistry.registerEgg(EntitySnowman.class, 0xEEEEEE, 0xFC6E02);
            EntityRegistry.registerEgg(EntityIronGolem.class, 0xC6C6C6, 0xE88484);
        }
    }
}
