package net.team_phytochorion.phytochorion.world.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.VegetationPatchFeature;
import net.minecraft.world.level.levelgen.feature.configurations.VegetationPatchConfiguration;

import java.util.Set;
import java.util.function.Predicate;


public class PerBiomeVegetationPatchFeature extends VegetationPatchFeature {
    public PerBiomeVegetationPatchFeature(Codec<VegetationPatchConfiguration> p_160588_) {
        super(p_160588_);
    }

    @Override
    public boolean place(FeaturePlaceContext<VegetationPatchConfiguration> p_160612_) {
        WorldGenLevel worldgenlevel = p_160612_.level();
        VegetationPatchConfiguration vegetationpatchconfiguration = p_160612_.config();
        RandomSource randomSource = p_160612_.random();
        BlockPos blockpos = p_160612_.origin();
        Predicate<BlockState> predicate = (p_204782_) -> {
            //return p_204782_.is(vegetationpatchconfiguration.replaceable);
            return true;
        };
        int i = vegetationpatchconfiguration.xzRadius.sample(randomSource) + 1;
        int j = vegetationpatchconfiguration.xzRadius.sample(randomSource) + 1;
        Set<BlockPos> set = this.placeGroundPatch(worldgenlevel, vegetationpatchconfiguration, randomSource, blockpos, predicate, i, j);
        return !set.isEmpty();
    }
}