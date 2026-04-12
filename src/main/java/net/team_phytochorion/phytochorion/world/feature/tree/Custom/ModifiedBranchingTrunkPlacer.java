package net.team_phytochorion.phytochorion.world.feature.tree.Custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.team_phytochorion.phytochorion.world.feature.tree.PhytochorionTrunkPlacers;

import java.util.List;
import java.util.function.BiConsumer;
/*
public class ModifiedBranchingTrunkPlacer extends TrunkPlacer {
    public static final Codec<ModifiedBranchingTrunkPlacer> CODEC = RecordCodecBuilder.create((placer) -> {
        return trunkPlacerParts(placer).and(placer.group(IntProvider.codec(-80, 80).fieldOf("min_branch_height").forGetter((p_161784_) -> {
            return p_161784_.minBrachHeight;
        }))).apply(placer, ModifiedBranchingTrunkPlacer::new);
    });
    private final IntProvider minBrachHeight;

    public ModifiedBranchingTrunkPlacer(int pBaseHeight, int pHeightRandA, int pHeightRandB, IntProvider p_161774_) {
        super(pBaseHeight, pHeightRandA, pHeightRandB);
        this.minBrachHeight = p_161774_;
    }
    protected TrunkPlacerType<?> type() {
        return PhytochorionTrunkPlacers.MODIFIED_BRANCHING_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, RandomSource pRandom, int pFreeTreeHeight, BlockPos pPos, TreeConfiguration pConfig) {
        return List.of();
    }
}
*/