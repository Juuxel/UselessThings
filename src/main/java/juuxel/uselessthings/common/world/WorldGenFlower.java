package juuxel.uselessthings.common.world;

import juuxel.uselessthings.common.util.Config;
import net.minecraft.block.BlockBush;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

public class WorldGenFlower
{
    private final BlockBush block;
    private final IBlockState state;

    public WorldGenFlower(BlockBush block, IBlockState blockState)
    {
        this.block = block;
        state = blockState;
    }

    private void generate(World worldIn, Random rand, BlockPos position)
    {
        for (int i = 0; i < Config.flowerAmount; ++i)
        {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (worldIn.isAirBlock(blockpos) && (!worldIn.provider.getHasNoSky() || blockpos.getY() < 255) && block.canBlockStay(worldIn, blockpos, state))
            {
                worldIn.setBlockState(blockpos, state, 2);
            }
        }
    }

    @SuppressWarnings("unused")
    @SubscribeEvent
    public void decorate(DecorateBiomeEvent.Decorate event)
    {
        BlockPos pos = event.getPos();
        Random rand = event.getRand();
        World world = event.getWorld();
        generate(world, rand, new BlockPos(pos.getX() + rand.nextInt(16) + 8, world.getTopSolidOrLiquidBlock(pos).getY(), pos.getZ() + rand.nextInt(16) + 8));
    }
}
