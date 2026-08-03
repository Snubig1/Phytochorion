package net.team_phytochorion.phytochorion.world.feature.tree.Custom;


import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.team_phytochorion.phytochorion.world.feature.tree.PhytochorionTrunkPlacers;

import java.util.List;
import java.util.function.BiConsumer;

public class LargeGinkgoTrunkPlacer extends GiantTrunkPlacer {
    public static final Codec<LargeGinkgoTrunkPlacer> CODEC = RecordCodecBuilder.create((placer) ->
            trunkPlacerParts(placer).and(IntProvider.NON_NEGATIVE_CODEC.fieldOf("branch_free_height").forGetter((p_226242_) -> {
                return p_226242_.branchFreeHeight;
            })).apply(placer, LargeGinkgoTrunkPlacer::new));


    private final IntProvider branchFreeHeight;

    public LargeGinkgoTrunkPlacer(int pBaseHeight, int pHeightRandA, int pHeightRandB, IntProvider pBranchFreeHeight) {
        super(pBaseHeight, pHeightRandA, pHeightRandB);
        this.branchFreeHeight = pBranchFreeHeight;
    }

    @Override
    protected TrunkPlacerType<?> type() { return PhytochorionTrunkPlacers.LARGE_GINKGO_TRUNK_PLACER.get(); }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, RandomSource pRandom, int pFreeTreeHeight, BlockPos pPos, TreeConfiguration pConfig) {
        BlockPos blockpos = pPos.below();

        setDirtAt(pLevel, pBlockSetter, pRandom, blockpos, pConfig);
        setDirtAt(pLevel, pBlockSetter, pRandom, blockpos.east(), pConfig);
        setDirtAt(pLevel, pBlockSetter, pRandom, blockpos.south(), pConfig);
        setDirtAt(pLevel, pBlockSetter, pRandom, blockpos.south().east(), pConfig);

        for(int i = 0; i < pFreeTreeHeight; ++i) {
            this.placeLogIfFree(pLevel, pBlockSetter, pRandom, pPos.offset(0, i, 0).mutable(), pConfig);
            this.placeLogIfFree(pLevel, pBlockSetter, pRandom, pPos.offset(1, i, 0).mutable(), pConfig);
            this.placeLogIfFree(pLevel, pBlockSetter, pRandom, pPos.offset(1, i, 1).mutable(), pConfig);
            this.placeLogIfFree(pLevel, pBlockSetter, pRandom, pPos.offset(0, i, 1).mutable(), pConfig);
        }
        this.placeLogIfFree(pLevel, pBlockSetter, pRandom, pPos.offset(0, pFreeTreeHeight, 0).mutable(), pConfig);
        return computeFoliageAttachements(pPos);
    }

    public List<FoliagePlacer.FoliageAttachment> computeFoliageAttachements(BlockPos pPos){
        List<FoliagePlacer.FoliageAttachment> list = Lists.newArrayList();

        list.add(new FoliagePlacer.FoliageAttachment(pPos.offset(2, 5, 2), 0, false));


        return list;
    }

    @Override
    public int getTreeHeight(RandomSource pRandom) {
        return this.baseHeight + pRandom.nextInt(pRandom.nextInt(this.heightRandA + this.heightRandB + 1)+1);
    }
}
