package net.team_phytochorion.phytochorion.world.feature;

import net.minecraft.core.registries.Registries;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.team_phytochorion.phytochorion.Phytochorion;


public class PhytochorionConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> ARAUCARIA = getKey(Phytochorion.MOD_ID,"araucaria");
    //public static final ResourceKey<ConfiguredFeature<?, ?>> GINKGO = getKey(Phytochorion.MOD_ID,"ginkgo");
    //public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_GINKGO = getKey(Phytochorion.MOD_ID,"fancy_ginkgo");

    private static ResourceKey<ConfiguredFeature<?, ?>> getKey(String mod_id, String name){
        return(ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(mod_id, name)));
    }
}
