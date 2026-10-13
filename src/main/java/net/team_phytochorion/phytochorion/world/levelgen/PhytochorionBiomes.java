package net.team_phytochorion.phytochorion.world.levelgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.team_phytochorion.phytochorion.Phytochorion;

public class PhytochorionBiomes {
    public static final ResourceKey<Biome> ARAUCARIA_FOREST = getKey(Phytochorion.MOD_ID,"araucaria_forest");
    public static final ResourceKey<Biome> SNOWY_ARAUCARIA_FOREST = getKey(Phytochorion.MOD_ID,"snowy_araucaria_forest");

    public static final ResourceKey<Biome> GINKGO_FOREST = getKey(Phytochorion.MOD_ID,"ginkgo_forest");
    public static final ResourceKey<Biome> SPARSE_GINKGO_FOREST = getKey(Phytochorion.MOD_ID,"sparse_ginkgo_forest");

    private static ResourceKey<Biome> getKey(String mod_id, String name){
        return(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(mod_id, name)));
    }
}
