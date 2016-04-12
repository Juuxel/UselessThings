package juuxel.uselessthings.common.init;

import juuxel.uselessthings.common.block.BlockFlower2;
import juuxel.uselessthings.common.world.WorldGenFlower;
import net.minecraftforge.common.MinecraftForge;

public class ModWorldGen
{
    public static void init()
    {
        for (int i = 0; i < BlockFlower2.Type.values().length; i++)
        {
            MinecraftForge.TERRAIN_GEN_BUS.register(new WorldGenFlower(ModBlocks.flower, ModBlocks.flower.getStateFromMeta(i)));
        }
    }
}
