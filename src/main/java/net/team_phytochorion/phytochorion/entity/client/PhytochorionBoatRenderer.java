package net.team_phytochorion.phytochorion.entity.client;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import net.team_phytochorion.phytochorion.Phytochorion;
import net.team_phytochorion.phytochorion.entity.PhytochorionBoatEntity;
import net.team_phytochorion.phytochorion.entity.PhytochorionChestBoatEntity;

import java.util.Map;
import java.util.stream.Stream;

public class PhytochorionBoatRenderer extends BoatRenderer {
    private final Map<PhytochorionBoatEntity.Type, Pair<ResourceLocation, ListModel<Boat>>> boatResources;

    public PhytochorionBoatRenderer(EntityRendererProvider.Context pContext, boolean pChestBoat) {
        super(pContext, pChestBoat);
        this.boatResources = Stream.of(PhytochorionBoatEntity.Type.values()).collect(ImmutableMap.toImmutableMap(type -> type,
                type -> Pair.of(ResourceLocation.fromNamespaceAndPath(Phytochorion.MOD_ID, getTextureLocation(type, pChestBoat)), this.createBoatModel(pContext, type, pChestBoat))));
    }

    private static String getTextureLocation(PhytochorionBoatEntity.Type pType, boolean pChestBoat) {
        return pChestBoat ? "textures/entity/chest_boat/" + pType.getName() + ".png" : "textures/entity/boat/" + pType.getName() + ".png";
    }

    private ListModel<Boat> createBoatModel(EntityRendererProvider.Context pContext, PhytochorionBoatEntity.Type pType, boolean pChestBoat) {
        ModelLayerLocation modellayerlocation = pChestBoat ? PhytochorionBoatRenderer.createChestBoatModelName(pType) : PhytochorionBoatRenderer.createBoatModelName(pType);
        ModelPart modelpart = pContext.bakeLayer(modellayerlocation);
        //this ^^^ here is the one complaining
        return pChestBoat ? new ChestBoatModel(modelpart) : new BoatModel(modelpart);
    }

    public static ModelLayerLocation createBoatModelName(PhytochorionBoatEntity.Type pType) {
        return createLocation("boat/" + pType.getName(), "main");
    }

    public static ModelLayerLocation createChestBoatModelName(PhytochorionBoatEntity.Type pType) {
        return createLocation("chest_boat/" + pType.getName(), "main");
    }

    private static ModelLayerLocation createLocation(String pPath, String pModel) {
        return new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Phytochorion.MOD_ID, pPath), pModel);
    }

    public Pair<ResourceLocation, ListModel<Boat>> getModelWithLocation(Boat boat) {
        if(boat instanceof PhytochorionBoatEntity phytochorionBoat) {
            return this.boatResources.get(phytochorionBoat.getPhytochorionBoatVariant());
        } else if(boat instanceof PhytochorionChestBoatEntity phytochorionChestBoatEntity) {
            return this.boatResources.get(phytochorionChestBoatEntity.getPhytochorionBoatVariant());
        } else {
            return null;
        }
    }
}
