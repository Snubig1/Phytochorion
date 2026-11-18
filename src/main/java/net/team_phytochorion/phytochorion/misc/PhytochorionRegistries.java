package net.team_phytochorion.phytochorion.misc;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DataPackRegistryEvent;
import net.team_phytochorion.phytochorion.Phytochorion;
import net.team_phytochorion.phytochorion.butterfly.ButterflyDataDescription;

public class PhytochorionRegistries {
    public static final ResourceKey<Registry<ButterflyDataDescription>> BUTTERFLIES = ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath(Phytochorion.MOD_ID, "butterflies"));


    public static void register(IEventBus eventBus) {
        eventBus.addListener((DataPackRegistryEvent.NewRegistry event) ->
        {
            event.dataPackRegistry(BUTTERFLIES, ButterflyDataDescription.CODEC);
        });
    }
}
