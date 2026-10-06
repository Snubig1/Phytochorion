package net.team_phytochorion.phytochorion.event;

import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.team_phytochorion.phytochorion.Phytochorion;
import net.team_phytochorion.phytochorion.block.entity.PhytochorionBlockEntities;
import net.team_phytochorion.phytochorion.entity.client.PhytochorionModelLayers;

@Mod.EventBusSubscriber(modid = Phytochorion.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PhytochorionEventBusClientEvents {

    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event){

        event.registerBlockEntityRenderer(PhytochorionBlockEntities.PHYTOCHORION_SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(PhytochorionBlockEntities.PHYTOCHORION_HANGING_SIGN.get(), HangingSignRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event){

        event.registerLayerDefinition(PhytochorionModelLayers.ARAUCARIA_BOAT_LAYER, BoatModel::createBodyModel);
        event.registerLayerDefinition(PhytochorionModelLayers.ARAUCARIA_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
        event.registerLayerDefinition(PhytochorionModelLayers.GINKGO_BOAT_LAYER, BoatModel::createBodyModel);
        event.registerLayerDefinition(PhytochorionModelLayers.GINKGO_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
    }
}
