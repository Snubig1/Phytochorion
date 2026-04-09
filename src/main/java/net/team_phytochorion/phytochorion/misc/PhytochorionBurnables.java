package net.team_phytochorion.phytochorion.misc;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import net.team_phytochorion.phytochorion.block.PhytochorionBlocks;

public class PhytochorionBurnables {

    public static void AddBurnables() {
        FireBlock fireblock = (FireBlock) Blocks.FIRE;
        fireblock.setFlammable(PhytochorionBlocks.ARAUCARIA_PLANKS.get(), 5, 20);
        fireblock.setFlammable(PhytochorionBlocks.GINKGO_PLANKS.get(), 5, 20);
        fireblock.setFlammable(PhytochorionBlocks.ARAUCARIA_SLAB.get(), 5, 20);
        fireblock.setFlammable(PhytochorionBlocks.GINKGO_SLAB.get(), 5, 20);
        fireblock.setFlammable(PhytochorionBlocks.ARAUCARIA_FENCE_GATE.get(), 5, 20);
        fireblock.setFlammable(PhytochorionBlocks.GINKGO_FENCE_GATE.get(), 5, 20);
        fireblock.setFlammable(PhytochorionBlocks.ARAUCARIA_FENCE.get(), 5, 20);
        fireblock.setFlammable(PhytochorionBlocks.GINKGO_FENCE.get(), 5, 20);
        fireblock.setFlammable(PhytochorionBlocks.ARAUCARIA_STAIRS.get(), 5, 20);
        fireblock.setFlammable(PhytochorionBlocks.GINKGO_STAIRS.get(), 5, 20);
        fireblock.setFlammable(PhytochorionBlocks.ARAUCARIA_LOG.get(), 5, 5);
        fireblock.setFlammable(PhytochorionBlocks.GINKGO_LOG.get(), 5, 5);
        fireblock.setFlammable(PhytochorionBlocks.STRIPPED_ARAUCARIA_LOG.get(), 5, 5);
        fireblock.setFlammable(PhytochorionBlocks.STRIPPED_GINKGO_LOG.get(), 5, 5);
        fireblock.setFlammable(PhytochorionBlocks.ARAUCARIA_WOOD.get(), 5, 5);
        fireblock.setFlammable(PhytochorionBlocks.GINKGO_WOOD.get(), 5, 5);
        fireblock.setFlammable(PhytochorionBlocks.STRIPPED_ARAUCARIA_WOOD.get(), 5, 5);
        fireblock.setFlammable(PhytochorionBlocks.STRIPPED_GINKGO_WOOD.get(), 5, 5);
        fireblock.setFlammable(PhytochorionBlocks.ARAUCARIA_LEAVES.get(), 30, 60);
        fireblock.setFlammable(PhytochorionBlocks.GINKGO_LEAVES.get(), 30, 60);
        fireblock.setFlammable(PhytochorionBlocks.ARAUCARIA_BRANCHES.get(), 5, 20);
        fireblock.setFlammable(PhytochorionBlocks.ARAUCARIA_NEEDLES.get(), 60, 100);
        fireblock.setFlammable(PhytochorionBlocks.GHOST_PIPE.get(), 60, 100);
        fireblock.setFlammable(PhytochorionBlocks.RED_GHOST_PIPE.get(), 60, 100);
        fireblock.setFlammable(PhytochorionBlocks.BUTTERFLY_WEED.get(), 60, 100);
    }
}
