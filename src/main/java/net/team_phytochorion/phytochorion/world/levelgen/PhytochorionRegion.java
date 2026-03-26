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

            /*List<Climate.ParameterPoint> araucariaFlat = new ParameterUtils.ParameterPointListBuilder()
                    .temperature(ParameterUtils.Temperature.NEUTRAL, ParameterUtils.Temperature.COOL)
                    .humidity(ParameterUtils.Humidity.NEUTRAL, ParameterUtils.Humidity.WET, ParameterUtils.Humidity.HUMID)
                    .continentalness(ParameterUtils.Continentalness.span(ParameterUtils.Continentalness.MID_INLAND, ParameterUtils.Continentalness.FAR_INLAND))
                    .erosion(ParameterUtils.Erosion.EROSION_3, ParameterUtils.Erosion.EROSION_4, ParameterUtils.Erosion.EROSION_5, ParameterUtils.Erosion.EROSION_6)
                    .depth(ParameterUtils.Depth.SURFACE, ParameterUtils.Depth.FLOOR)
                    .weirdness(ParameterUtils.Weirdness.MID_SLICE_NORMAL_ASCENDING, ParameterUtils.Weirdness.HIGH_SLICE_NORMAL_ASCENDING, ParameterUtils.Weirdness.PEAK_NORMAL, ParameterUtils.Weirdness.HIGH_SLICE_NORMAL_DESCENDING, ParameterUtils.Weirdness.MID_SLICE_NORMAL_DESCENDING, ParameterUtils.Weirdness.LOW_SLICE_NORMAL_DESCENDING, ParameterUtils.Weirdness.VALLEY, ParameterUtils.Weirdness.LOW_SLICE_VARIANT_ASCENDING, ParameterUtils.Weirdness.MID_SLICE_VARIANT_ASCENDING, ParameterUtils.Weirdness.HIGH_SLICE_VARIANT_ASCENDING, ParameterUtils.Weirdness.PEAK_VARIANT, ParameterUtils.Weirdness.HIGH_SLICE_VARIANT_DESCENDING, ParameterUtils.Weirdness.MID_SLICE_VARIANT_DESCENDING)
                    .build();

            araucariaMountainside.forEach(point -> builder.replaceBiome(point, PhytochorionBiomes.ARAUCARIA_FOREST));
            araucariaFlat.forEach(point -> builder.replaceBiome(point, PhytochorionBiomes.ARAUCARIA_FOREST));
        });*/
    }
}
