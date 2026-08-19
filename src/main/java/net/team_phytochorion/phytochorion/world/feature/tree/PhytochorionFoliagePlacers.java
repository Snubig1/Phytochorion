package net.team_phytochorion.phytochorion.world.feature.tree;


import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.team_phytochorion.phytochorion.Phytochorion;
import net.team_phytochorion.phytochorion.world.feature.tree.Custom.AraucariaFoliagePlacer;
import net.team_phytochorion.phytochorion.world.feature.tree.Custom.GinkgoFoliagePlacer;

public class PhytochorionFoliagePlacers {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS = DeferredRegister.create(ForgeRegistries.FOLIAGE_PLACER_TYPES, Phytochorion.MOD_ID);

    public static final RegistryObject<FoliagePlacerType<AraucariaFoliagePlacer>> ARAUCARIA_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("araucaria_foliage_placer", () -> new FoliagePlacerType<>(AraucariaFoliagePlacer.CODEC));
    public static final RegistryObject<FoliagePlacerType<GinkgoFoliagePlacer>> GINKGO_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("ginkgo_foliage_placer", () -> new FoliagePlacerType<>(GinkgoFoliagePlacer.CODEC));

    public static void register(IEventBus eventBus) {
        FOLIAGE_PLACERS.register(eventBus);
    }
}
