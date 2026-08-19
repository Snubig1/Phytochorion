package net.team_phytochorion.phytochorion.world.feature.tree.Custom;


import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Tuple;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.team_phytochorion.phytochorion.world.feature.tree.PhytochorionTrunkPlacers;


import java.util.Arrays;
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
        int branchedHeight = pFreeTreeHeight - this.branchFreeHeight.sample(pRandom);
        int branchAmount = branchedHeight + pRandom.nextInt(-1, 2);

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
        this.placeLogIfFree(pLevel, pBlockSetter, pRandom, pPos.above(pFreeTreeHeight).mutable(), pConfig);
        return computeFoliageAttachments(pPos.above(pFreeTreeHeight-1), pRandom, branchedHeight, branchAmount);
    }

    int[] regionCoordOffset = {0, -1, 0, 1};
    private List<FoliagePlacer.FoliageAttachment> computeFoliageAttachments(BlockPos pPos, RandomSource pRandom, int pBranchedHeight, int pBranchAmount){
        boolean[][] attachmentMap = new boolean[8][pBranchedHeight];
        List<FoliagePlacer.FoliageAttachment> returnList = Lists.newArrayList();

        int regionBranchAmount = pBranchAmount / 4;
        int regionBranchRemainder = pBranchAmount % 4;

        Tuple<Integer, Integer>[] regions = new Tuple[] {new Tuple<>(1, regionBranchAmount), new Tuple<>(3, regionBranchAmount), new Tuple<>(5, regionBranchAmount), new Tuple<>(7, regionBranchAmount) };

        switch (regionBranchRemainder ){
            case 1:
                regions[0].setB(regionBranchAmount+1);
                break;
            case 2:
                regions[0].setB(regionBranchAmount+1);
                regions[1].setB(regionBranchAmount+1);
                break;
            case 3:
                regions[0].setB(regionBranchAmount+1);
                regions[1].setB(regionBranchAmount+1);
                regions[2].setB(regionBranchAmount+1);
                break;
        }

        for (Tuple<Integer, Integer> region : regions)
        {
            for (int i = 0; i < region.getB(); i++)
            {
                int x = (pRandom.nextInt(4) + region.getA()) % 8;
                int y = pRandom.nextInt(pBranchedHeight);

                if (attachmentMap[x][y])
                    {
                        boolean foundGood = false;
                        for (int r = 0; r < 4; r++)
                        {
                            if (!attachmentMap[(x + regionCoordOffset[r] + 7) % 8][(y + regionCoordOffset[3 - r] + pBranchedHeight-1) % (pBranchedHeight-1)])
                            {
                                foundGood = true;
                                x = (x + regionCoordOffset[r] + 7) % 8;
                                y = (y + regionCoordOffset[3 - r] + pBranchedHeight-1) % (pBranchedHeight-1);
                                break;
                            }
                        }
                        if (!foundGood) {
                            System.out.println("nothing good at");
                            System.out.println(x);
                            System.out.println(y);
                            continue;
                        }
                    }

                attachmentMap[x][y] = true;
                attachmentMap[(x+1) % 8][y] = true;
                attachmentMap[(x+7) % 8][y] = true;
                attachmentMap[x][Math.min(y+1, pBranchedHeight-1)] = true;
                attachmentMap[x][Math.max(y-1, 0)] = true;

                returnList.add(new FoliagePlacer.FoliageAttachment(getBrancCoords(pPos, new Tuple<>(x, y)), 0, false));
            }
        }

        for (boolean[] list : attachmentMap) {
            System.out.println(Arrays.toString(list));
        }

        return returnList;

    }
    int[] coordOffset = {-1, -1, 0, 1, 2, 2, 1, 0};
    private BlockPos getBrancCoords(BlockPos pBasePos, Tuple<Integer, Integer> pFlatCoords)
    {
        return pBasePos.offset( coordOffset[7 - pFlatCoords.getA()], -pFlatCoords.getB(), coordOffset[pFlatCoords.getA()]);
    }

    @Override
    public int getTreeHeight(RandomSource pRandom) {
        return this.baseHeight + pRandom.nextInt(pRandom.nextInt(this.heightRandA + this.heightRandB + 1)+1);
    }
}
