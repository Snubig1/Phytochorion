package net.team_phytochorion.phytochorion.world.feature.tree;

import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.team_phytochorion.phytochorion.world.feature.PhytochorionConfiguredFeatures;

public class GinkgoTreeGrower extends AbstractMegaTreeGrower {
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource p_255637_, boolean p_255764_) {
        return TreeFeatures.OAK;
    }
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredMegaFeature(RandomSource p_255637_) {
        return PhytochorionConfiguredFeatures.LARGE_GINKGO;
    }
}
