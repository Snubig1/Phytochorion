package net.team_phytochorion.phytochorion.world.feature;


import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.stream.Stream;

public class FeatureStackConfiguration implements FeatureConfiguration {
    public static final Codec<FeatureStackConfiguration> CODEC = RecordCodecBuilder.create((p_67877_) -> {
        return p_67877_.group(PlacedFeature.CODEC.fieldOf("first_feature").forGetter((p_204809_) -> {
            return p_204809_.firstFeature;
        }), PlacedFeature.CODEC.fieldOf("second_feature").forGetter((p_204807_) -> {
            return p_204807_.secondFeature;
        })).apply(p_67877_, FeatureStackConfiguration::new);
    });
    public final Holder<PlacedFeature> firstFeature;
    public final Holder<PlacedFeature> secondFeature;

    public FeatureStackConfiguration(Holder<PlacedFeature> p_204804_, Holder<PlacedFeature> p_204805_) {
        this.firstFeature = p_204804_;
        this.secondFeature = p_204805_;
    }

    public Stream<ConfiguredFeature<?, ?>> getFeatures() {
        return Stream.concat(this.firstFeature.value().getFeatures(), this.secondFeature.value().getFeatures());
    }
}

