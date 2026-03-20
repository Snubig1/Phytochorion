package net.team_phytochorion.phytochorion.world.levelgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class PhytochorionBiomes {
    public static final ResourceKey<Biome> ARAUCARIA_FOREST = getKey("minecraft","araucaria_forest");

    private static ResourceKey<Biome> getKey(String mod_id, String name){
        return(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(mod_id, name)));
    }
}
