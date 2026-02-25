package net.team_phytochorion.phytochorion.world.feature.tree;

import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class PineTreeGrower extends AbstractMegaTreeGrower {
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource p_255637_, boolean p_255764_) {
        return TreeFeatures.PINE;
    }

    /**
     * @return the key of the huge variant of this tree
     */
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredMegaFeature(RandomSource p_255928_) {
        return  TreeFeatures.MEGA_PINE;
    }
}
