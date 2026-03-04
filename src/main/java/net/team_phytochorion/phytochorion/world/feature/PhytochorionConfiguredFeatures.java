package net.team_phytochorion.phytochorion.world.feature;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraftforge.registries.DeferredRegister;
import net.team_phytochorion.phytochorion.Phytochorion;


public class PhytochorionConfiguredFeatures {

    public static final DeferredRegister<ConfiguredFeature<?,?>> CONFIGURED_FEATURES = DeferredRegister.create(Registries.CONFIGURED_FEATURE, Phytochorion.MOD_ID);
    public static final ResourceKey<ConfiguredFeature<?, ?>> ARAUCARIA = FeatureUtils.createKey("araucaria");
}
