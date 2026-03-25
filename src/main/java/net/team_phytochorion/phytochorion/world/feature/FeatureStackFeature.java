package net.team_phytochorion.phytochorion.world.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class FeatureStackFeature extends Feature<FeatureStackConfiguration> {
    public FeatureStackFeature(Codec<FeatureStackConfiguration> p_66591_) {
        super(p_66591_);


    }
    public boolean place(FeaturePlaceContext<FeatureStackConfiguration> p_160208_) {
        RandomSource randomsource = p_160208_.random();
        FeatureStackConfiguration featureStackConfiguration = p_160208_.config();
        WorldGenLevel worldgenlevel = p_160208_.level();
        ChunkGenerator chunkgenerator = p_160208_.chunkGenerator();
        BlockPos blockpos = p_160208_.origin();
        boolean success = false;

        if (((PlacedFeature) featureStackConfiguration.firstFeature.value()).place(worldgenlevel, chunkgenerator, randomsource, blockpos)) success = true;
        if (((PlacedFeature) featureStackConfiguration.secondFeature.value()).place(worldgenlevel, chunkgenerator, randomsource, blockpos)) success = true;

        return success;
    }
}
