package net.team_phytochorion.phytochorion.misc;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.team_phytochorion.phytochorion.Phytochorion;
import net.team_phytochorion.phytochorion.block.PhytochorionBlocks;
import net.team_phytochorion.phytochorion.items.PhytochorionItems;

public class PhytochorionCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Phytochorion.MOD_ID);

    public static final RegistryObject<CreativeModeTab> PHYTOCHORION_TAB = CREATIVE_MODE_TABS.register("phytochorion_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(PhytochorionBlocks.PINE_SAPLING.get()))
                    .title(Component.translatable("creativetab.phytochorion_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(PhytochorionBlocks.ARAUCARIA_LOG.get());
                        pOutput.accept(PhytochorionBlocks.ARAUCARIA_WOOD.get());
                        pOutput.accept(PhytochorionBlocks.STRIPPED_ARAUCARIA_LOG.get());
                        pOutput.accept(PhytochorionBlocks.STRIPPED_ARAUCARIA_WOOD.get());
                        pOutput.accept(PhytochorionBlocks.ARAUCARIA_PLANKS.get());
                        pOutput.accept(PhytochorionBlocks.ARAUCARIA_STAIRS.get());
                        pOutput.accept(PhytochorionBlocks.ARAUCARIA_SLAB.get());
                        pOutput.accept(PhytochorionBlocks.ARAUCARIA_FENCE.get());
                        pOutput.accept(PhytochorionBlocks.ARAUCARIA_FENCE_GATE.get());
                        pOutput.accept(PhytochorionBlocks.ARAUCARIA_DOOR.get());
                        pOutput.accept(PhytochorionBlocks.ARAUCARIA_TRAPDOOR.get());
                        pOutput.accept(PhytochorionBlocks.ARAUCARIA_PRESSURE_PLATE.get());
                        pOutput.accept(PhytochorionBlocks.ARAUCARIA_BUTTON.get());
                        pOutput.accept(PhytochorionBlocks.GINKGO_LOG.get());
                        pOutput.accept(PhytochorionBlocks.GINKGO_WOOD.get());
                        pOutput.accept(PhytochorionBlocks.STRIPPED_GINKGO_LOG.get());
                        pOutput.accept(PhytochorionBlocks.STRIPPED_GINKGO_WOOD.get());
                        pOutput.accept(PhytochorionBlocks.GINKGO_PLANKS.get());
                        pOutput.accept(PhytochorionBlocks.GINKGO_STAIRS.get());
                        pOutput.accept(PhytochorionBlocks.GINKGO_SLAB.get());
                        pOutput.accept(PhytochorionBlocks.GINKGO_FENCE.get());
                        pOutput.accept(PhytochorionBlocks.GINKGO_FENCE_GATE.get());
                        pOutput.accept(PhytochorionBlocks.GINKGO_DOOR.get());
                        pOutput.accept(PhytochorionBlocks.GINKGO_TRAPDOOR.get());
                        pOutput.accept(PhytochorionBlocks.GINKGO_PRESSURE_PLATE.get());
                        pOutput.accept(PhytochorionBlocks.GINKGO_BUTTON.get());



                        pOutput.accept(PhytochorionItems.ARAUCARIA_SIGN.get());
                        pOutput.accept(PhytochorionItems.ARAUCARIA_HANGING_SIGN.get());
                        pOutput.accept(PhytochorionItems.GINKGO_SIGN.get());
                        pOutput.accept(PhytochorionItems.GINKGO_HANGING_SIGN.get());



                        pOutput.accept(PhytochorionBlocks.ARAUCARIA_BRANCHES.get());
                        pOutput.accept(PhytochorionBlocks.ARAUCARIA_LEAVES.get());
                        pOutput.accept(PhytochorionBlocks.GINKGO_LEAVES.get());
                        pOutput.accept(PhytochorionBlocks.PINE_LEAVES.get());
                        pOutput.accept(PhytochorionBlocks.ARAUCARIA_NEEDLES.get());
                        pOutput.accept(PhytochorionBlocks.ARAUCARIA_SAPLING.get());
                        pOutput.accept(PhytochorionBlocks.GINKGO_SAPLING.get());
                        pOutput.accept(PhytochorionBlocks.PINE_SAPLING.get());
                        pOutput.accept(PhytochorionBlocks.BUTTERFLY_WEED.get());
                        pOutput.accept(PhytochorionBlocks.GHOST_PIPE.get());
                        pOutput.accept(PhytochorionBlocks.RED_GHOST_PIPE.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
