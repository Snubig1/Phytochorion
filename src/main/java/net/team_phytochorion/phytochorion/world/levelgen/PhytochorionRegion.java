package net.team_phytochorion.phytochorion.world.levelgen;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

import static terrablender.api.ParameterUtils.*;

public class PhytochorionRegion extends Region
{
    public PhytochorionRegion(ResourceLocation name, int weight)
    {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper)
    {
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
        new ParameterPointListBuilder()
                .temperature(Temperature.span(Temperature.COOL, Temperature.NEUTRAL))
                .humidity(Humidity.NEUTRAL, Humidity.WET, Humidity.HUMID)
                .continentalness(Continentalness.MID_INLAND, Continentalness.FAR_INLAND)
                .erosion(Erosion.EROSION_0, Erosion.EROSION_1, Erosion.EROSION_2)
                .depth(Depth.SURFACE, Depth.FLOOR)
                .weirdness(Weirdness.MID_SLICE_NORMAL_ASCENDING, Weirdness.HIGH_SLICE_NORMAL_ASCENDING, Weirdness.HIGH_SLICE_NORMAL_DESCENDING, Weirdness.MID_SLICE_NORMAL_DESCENDING, Weirdness.LOW_SLICE_NORMAL_DESCENDING)
                .build().forEach(point -> builder.add(point, PhytochorionBiomes.ARAUCARIA_FOREST));

        builder.build().forEach(mapper);

        new ParameterPointListBuilder()
                .temperature(Temperature.span(Temperature.FROZEN, Temperature.ICY))
                .humidity(Humidity.NEUTRAL, Humidity.WET, Humidity.HUMID)
                .continentalness(Continentalness.MID_INLAND, Continentalness.FAR_INLAND)
                .erosion(Erosion.EROSION_0, Erosion.EROSION_1, Erosion.EROSION_2)
                .depth(Depth.SURFACE, Depth.FLOOR)
                .weirdness(Weirdness.MID_SLICE_NORMAL_ASCENDING, Weirdness.HIGH_SLICE_NORMAL_ASCENDING, Weirdness.HIGH_SLICE_NORMAL_DESCENDING, Weirdness.MID_SLICE_NORMAL_DESCENDING, Weirdness.LOW_SLICE_NORMAL_DESCENDING)
                .build().forEach(point -> builder.add(point, PhytochorionBiomes.SNOWY_ARAUCARIA_FOREST));

        builder.build().forEach(mapper);

        new ParameterPointListBuilder()
                .temperature(Temperature.span(Temperature.NEUTRAL, Temperature.WARM))
                .humidity(Humidity.NEUTRAL, Humidity.WET)
                .continentalness(Continentalness.MID_INLAND, Continentalness.FAR_INLAND, Continentalness.INLAND)
                .erosion(Erosion.EROSION_2, Erosion.EROSION_3, Erosion.EROSION_4, Erosion.EROSION_5)
                .depth(Depth.SURFACE, Depth.FLOOR)
                .weirdness(Weirdness.MID_SLICE_NORMAL_ASCENDING, Weirdness.HIGH_SLICE_NORMAL_ASCENDING, Weirdness.PEAK_NORMAL,Weirdness.HIGH_SLICE_NORMAL_DESCENDING, Weirdness.MID_SLICE_NORMAL_DESCENDING, Weirdness.LOW_SLICE_NORMAL_DESCENDING, Weirdness.LOW_SLICE_VARIANT_ASCENDING, Weirdness.MID_SLICE_VARIANT_ASCENDING, Weirdness.HIGH_SLICE_VARIANT_ASCENDING, Weirdness.PEAK_VARIANT, Weirdness.HIGH_SLICE_VARIANT_DESCENDING, Weirdness.MID_SLICE_VARIANT_DESCENDING)
                .build().forEach(point -> builder.add(point, PhytochorionBiomes.GINKGO_FOREST));

        builder.build().forEach(mapper);

        new ParameterPointListBuilder()
                .temperature(Temperature.span(Temperature.NEUTRAL, Temperature.WARM))
                .humidity(Humidity.NEUTRAL)
                .continentalness(Continentalness.COAST, Continentalness.NEAR_INLAND, Continentalness.MID_INLAND, Continentalness.FAR_INLAND)
                .erosion(Erosion.EROSION_1, Erosion.EROSION_2, Erosion.EROSION_3, Erosion.EROSION_4, Erosion.EROSION_5)
                .depth(Depth.SURFACE, Depth.FLOOR)
                .weirdness(Weirdness.MID_SLICE_NORMAL_ASCENDING, Weirdness.HIGH_SLICE_NORMAL_ASCENDING, Weirdness.PEAK_NORMAL,Weirdness.HIGH_SLICE_NORMAL_DESCENDING, Weirdness.MID_SLICE_NORMAL_DESCENDING, Weirdness.LOW_SLICE_NORMAL_DESCENDING, Weirdness.VALLEY, Weirdness.LOW_SLICE_VARIANT_ASCENDING, Weirdness.MID_SLICE_VARIANT_ASCENDING, Weirdness.HIGH_SLICE_VARIANT_ASCENDING, Weirdness.PEAK_VARIANT, Weirdness.HIGH_SLICE_VARIANT_DESCENDING, Weirdness.MID_SLICE_VARIANT_DESCENDING)
                .build().forEach(point -> builder.add(point, PhytochorionBiomes.SPARSE_GINKGO_FOREST));

        builder.build().forEach(mapper);


  }
}