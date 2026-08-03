package net.team_phytochorion.phytochorion.world.feature.tree;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.team_phytochorion.phytochorion.Phytochorion;
import net.team_phytochorion.phytochorion.world.feature.tree.Custom.AraucariaTrunkPlacer;
import net.team_phytochorion.phytochorion.world.feature.tree.Custom.LargeGinkgoTrunkPlacer;

public class PhytochorionTrunkPlacers {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACERS = DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, Phytochorion.MOD_ID);

    public static final RegistryObject<TrunkPlacerType<AraucariaTrunkPlacer>> ARAUCARIA_TRUNK_PLACER = TRUNK_PLACERS.register("araucaria_trunk_placer", () -> new TrunkPlacerType<>(AraucariaTrunkPlacer.CODEC));
    public static final RegistryObject<TrunkPlacerType<LargeGinkgoTrunkPlacer>> LARGE_GINKGO_TRUNK_PLACER = TRUNK_PLACERS.register("large_ginkgo_trunk_placer", () -> new TrunkPlacerType<>(LargeGinkgoTrunkPlacer.CODEC));


    public static void register(IEventBus eventBus) {
        TRUNK_PLACERS.register(eventBus);
    }
}
