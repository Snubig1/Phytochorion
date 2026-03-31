package net.team_phytochorion.phytochorion.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.team_phytochorion.phytochorion.Phytochorion;
import net.team_phytochorion.phytochorion.block.PhytochorionBlocks;

public class PhytochorionBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Phytochorion.MOD_ID);

    public static final RegistryObject<BlockEntityType<PhytochorionSignBlockEntity>> PHYTOCHORION_SIGN = BLOCK_ENTITIES.register("phytochorion_sign", () -> BlockEntityType.Builder.of(PhytochorionSignBlockEntity::new, PhytochorionBlocks.ARAUCARIA_SIGN.get(), PhytochorionBlocks.ARAUCARIA_WALL_SIGN.get(), PhytochorionBlocks.GINKGO_SIGN.get(), PhytochorionBlocks.GINKGO_WALL_SIGN.get()).build(null));
    public static final RegistryObject<BlockEntityType<PhytochorionHangingSignBlockEntity>> PHYTOCHORION_HANGING_SIGN = BLOCK_ENTITIES.register("phytochorion_hanging_sign", () -> BlockEntityType.Builder.of(PhytochorionHangingSignBlockEntity::new, PhytochorionBlocks.ARAUCARIA_HANGING_SIGN.get(), PhytochorionBlocks.ARAUCARIA_WALL_HANGING_SIGN.get(), PhytochorionBlocks.GINKGO_HANGING_SIGN.get(), PhytochorionBlocks.GINKGO_WALL_HANGING_SIGN.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
