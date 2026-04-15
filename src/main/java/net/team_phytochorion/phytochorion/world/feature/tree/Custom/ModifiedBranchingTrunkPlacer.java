package net.team_phytochorion.phytochorion.world.feature.tree.Custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.FloatProvider;
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

public class ModifiedBranchingTrunkPlacer extends TrunkPlacer {
    public static final Codec<ModifiedBranchingTrunkPlacer> CODEC = RecordCodecBuilder.create((placer) -> {
        return trunkPlacerParts(placer).and(placer.group(Codec.BOOL.fieldOf("wide").forGetter((p_161784_) -> {
            return p_161784_.wide;
        }),IntProvider.codec(-80, 80).fieldOf("min_branch_height").forGetter((p_161784_) -> {
            return p_161784_.minBrachHeight;
        }),IntProvider.codec(0, 64).fieldOf("branch_length").forGetter((p_161784_) -> {
            return p_161784_.branchLength;
        }),FloatProvider.codec(-10, 10).fieldOf("plus_y").forGetter((p_161784_) -> {
            return p_161784_.plusY;
        }),FloatProvider.codec(-10, 10).fieldOf("y_per_x").forGetter((p_161784_) -> {
            return p_161784_.yPerX;
        }))).apply(placer, ModifiedBranchingTrunkPlacer::new);
    });
    private final boolean wide;
    private final IntProvider minBrachHeight;
    private final IntProvider branchLength;
    private final FloatProvider plusY;
    private final FloatProvider yPerX;


    public ModifiedBranchingTrunkPlacer(int pBaseHeight, int pHeightRandA, int pHeightRandB, boolean pWide, IntProvider pMinBrachHeight, IntProvider pBranchLength, FloatProvider pPlusY, FloatProvider pYPerX) {
        super(pBaseHeight, pHeightRandA, pHeightRandB);
        this.wide = pWide;
        this.minBrachHeight = pMinBrachHeight;
        this.branchLength = pBranchLength;
        this.plusY = pPlusY;
        this.yPerX = pYPerX;
    }
    protected TrunkPlacerType<?> type() {
        return PhytochorionTrunkPlacers.MODIFIED_BRANCHING_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, RandomSource pRandom, int pFreeTreeHeight, BlockPos pPos, TreeConfiguration pConfig) {


        return List.of();
    }
}
