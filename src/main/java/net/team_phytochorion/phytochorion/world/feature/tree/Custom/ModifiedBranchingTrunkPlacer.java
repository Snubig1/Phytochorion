package net.team_phytochorion.phytochorion.world.feature.tree.Custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.team_phytochorion.phytochorion.world.feature.tree.PhytochorionTrunkPlacers;

import java.util.List;
import java.util.function.BiConsumer;

public class ModifiedBranchingTrunkPlacer extends TrunkPlacer {
    public static final Codec<ModifiedBranchingTrunkPlacer> CODEC = RecordCodecBuilder.create((placer) ->
            trunkPlacerParts(placer).apply(placer, ModifiedBranchingTrunkPlacer::new));

    public ModifiedBranchingTrunkPlacer(int pBaseHeight, int pHeightRandA, int pHeightRandB) {
        super(pBaseHeight, pHeightRandA, pHeightRandB);
    }
    protected TrunkPlacerType<?> type() {
        return PhytochorionTrunkPlacers.MODIFIED_BRANCHING_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, RandomSource pRandom, int pFreeTreeHeight, BlockPos pPos, TreeConfiguration pConfig) {
        return List.of();
    }
}
