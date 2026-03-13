package net.team_phytochorion.phytochorion.world.levelgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.team_phytochorion.phytochorion.Phytochorion;

public class PhytochorionNoises {
    public static final ResourceKey<NormalNoise.NoiseParameters> ARAUCARIA_SURFACE = getKey(Phytochorion.MOD_ID,"araucaria_surface");

    private static ResourceKey<NormalNoise.NoiseParameters> getKey(String mod_id, String name){
        return(ResourceKey.create(Registries.NOISE, ResourceLocation.fromNamespaceAndPath(mod_id, name)));
    }
}
