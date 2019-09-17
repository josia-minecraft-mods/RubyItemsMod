package com.jmteam.rubymod.world;

import com.jmteam.rubymod.common.init.RMBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class ModWorldGen implements IWorldGenerator
{
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkprovider)
    {
        if (world.provider.getDimension() == 0)
        {
            generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkprovider);
        }
    }

    private void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkprovider)
    {
        generateOre(RMBlocks.RUBY_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 16,64, random.nextInt(7) + 4, 9);
    }

    private void generateOre(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chances)
    {
        int deltaY = maxY- minY;

        for (int i = 0; i < chances; i++)
        {
            BlockPos pos = new BlockPos(x + random.nextInt(16),minY + random.nextInt(deltaY), z + random.nextInt(16));

            WorldGenMinable generator = new WorldGenMinable(ore, size);
            generator.generate(world, random, pos);
        }
    }
}
