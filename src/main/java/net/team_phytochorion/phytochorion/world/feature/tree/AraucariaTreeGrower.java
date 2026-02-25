package net.team_phytochorion.phytochorion.world.feature.tree;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.team_phytochorion.phytochorion.world.feature.PhytochorionConfiguredFeatures;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class AraucariaTreeGrower extends AbstractTreeGrower {
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource p_255637_, boolean p_255764_) {
        return PhytochorionConfiguredFeatures.ARAUCARIA;

    }
}
