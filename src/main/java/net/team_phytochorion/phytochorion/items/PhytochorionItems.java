package net.team_phytochorion.phytochorion.items;

import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.team_phytochorion.phytochorion.Phytochorion;
import net.team_phytochorion.phytochorion.block.PhytochorionBlocks;
import net.team_phytochorion.phytochorion.entity.PhytochorionBoatEntity;

public class PhytochorionItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Phytochorion.MOD_ID);

    public static final RegistryObject<Item> ARAUCARIA_SIGN = ITEMS.register("araucaria_sign", () -> new SignItem(new Item.Properties().stacksTo(16), PhytochorionBlocks.ARAUCARIA_SIGN.get(), PhytochorionBlocks.ARAUCARIA_WALL_SIGN.get()));
    public static final RegistryObject<Item> ARAUCARIA_HANGING_SIGN = ITEMS.register("araucaria_hanging_sign", () -> new HangingSignItem(PhytochorionBlocks.ARAUCARIA_HANGING_SIGN.get(), PhytochorionBlocks.ARAUCARIA_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> GINKGO_SIGN = ITEMS.register("ginkgo_sign", () -> new SignItem(new Item.Properties().stacksTo(16), PhytochorionBlocks.GINKGO_SIGN.get(), PhytochorionBlocks.GINKGO_WALL_SIGN.get()));
    public static final RegistryObject<Item> GINKGO_HANGING_SIGN = ITEMS.register("ginkgo_hanging_sign", () -> new HangingSignItem(PhytochorionBlocks.GINKGO_HANGING_SIGN.get(), PhytochorionBlocks.GINKGO_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> ARAUCARIA_BOAT = ITEMS.register("araucaria_boat", () -> new PhytochorionBoatItem(false, PhytochorionBoatEntity.Type.ARAUCARIA, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ARAUCARIA_CHEST_BOAT = ITEMS.register("araucaria_chest_boat", () -> new PhytochorionBoatItem(true, PhytochorionBoatEntity.Type.ARAUCARIA, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> GINKGO_BOAT = ITEMS.register("ginkgo_boat", () -> new PhytochorionBoatItem(false, PhytochorionBoatEntity.Type.GINKGO, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> GINKGO_CHEST_BOAT = ITEMS.register("ginkgo_chest_boat", () -> new PhytochorionBoatItem(true, PhytochorionBoatEntity.Type.GINKGO, new Item.Properties().stacksTo(1)));



    public static final RegistryObject<Item> DRIED_GHOST_PIPE = ITEMS.register("dried_ghost_pipe", () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
