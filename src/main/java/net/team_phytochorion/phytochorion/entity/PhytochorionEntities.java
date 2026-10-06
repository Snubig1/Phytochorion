package net.team_phytochorion.phytochorion.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.team_phytochorion.phytochorion.Phytochorion;

public class PhytochorionEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Phytochorion.MOD_ID);

    public static final RegistryObject<EntityType<PhytochorionBoatEntity>> PHYTOCHORION_BOAT = ENTITY_TYPES.register("phytochorion_boat", () -> EntityType.Builder.<PhytochorionBoatEntity>of(PhytochorionBoatEntity::new, MobCategory.MISC).sized(1.375f, 0.5625f).clientTrackingRange(10).build("phytochorion_boat"));
    public static final RegistryObject<EntityType<PhytochorionChestBoatEntity>> PHYTOCHORION_CHEST_BOAT = ENTITY_TYPES.register("phytochorion_chest_boat", () -> EntityType.Builder.<PhytochorionChestBoatEntity>of(PhytochorionChestBoatEntity::new, MobCategory.MISC).sized(1.375f, 0.5625f).clientTrackingRange(10).build("phytochorion_chest_boat"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
