package net.team_phytochorion.phytochorion.world.feature;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.team_phytochorion.phytochorion.Phytochorion;

public abstract class PhytochorionFeatures<FC extends FeatureConfiguration>{
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Phytochorion.MOD_ID);
    public static final RegistryObject<Feature<FeatureStackConfiguration>> FEATURE_STACK = FEATURES.register("feature_stack", () -> new FeatureStackFeature(FeatureStackConfiguration.CODEC));


    public static void register(IEventBus eventBus) {
        FEATURES.register(eventBus);
    }
}