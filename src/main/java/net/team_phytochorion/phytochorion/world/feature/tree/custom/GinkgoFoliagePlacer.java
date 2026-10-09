package net.team_phytochorion.phytochorion.world.feature.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.team_phytochorion.phytochorion.world.feature.tree.PhytochorionFoliagePlacers;

public class GinkgoFoliagePlacer  extends FoliagePlacer {
    public static final Codec<GinkgoFoliagePlacer> CODEC = RecordCodecBuilder.create((placer) ->
            foliagePlacerParts(placer).apply(placer, GinkgoFoliagePlacer::new));

    public GinkgoFoliagePlacer(IntProvider pRadius, IntProvider pOffset) {
        super(pRadius, pOffset);
    }

    @Override
    protected FoliagePlacerType<?> type() {return PhytochorionFoliagePlacers.GINKGO_FOLIAGE_PLACER.get();}

    static final Direction[] directionMap = {
            Direction.NORTH,
            Direction.EAST,
            Direction.SOUTH,
            Direction.WEST
    };

    @Override
    protected void createFoliage(LevelSimulatedReader pLevel, FoliageSetter pBlockSetter, RandomSource pRandom, TreeConfiguration pConfig, int pMaxFreeTreeHeight, FoliageAttachment pAttachment, int pFoliageHeight, int pFoliageRadius, int pOffset) {
        int branchLen;

        if (pAttachment.radiusOffset() == 100)
        {
            tryPlaceLeaf(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().offset(pRandom.nextInt(0,2),2, pRandom.nextInt(0,2)));

            placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().offset(0,1, 0), Direction.EAST, 2, 0f, 0f);
            placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().offset(0,1, 1), Direction.EAST, 2, 0f, 0f);

            placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().offset(-1,0, 0), Direction.EAST, 4, 0f, 0f);
            placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().offset(-1,0, 1), Direction.EAST, 4, 0f, 0f);
            placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().offset(0,0, -1), Direction.EAST, 2, 0f, 0f);
            placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().offset(0,0, 2), Direction.EAST, 2, 0f, 0f);

            placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().offset(-2,-1, 0), Direction.EAST, 6, 0.25f, 0.4f);
            placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().offset(-2,-1, 1), Direction.EAST, 6, 0.25f, 0.4f);
            placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().offset(-1,-1, -1), Direction.EAST, 4, 0.25f, 0.4f);
            placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().offset(-1,-1, 2), Direction.EAST, 4, 0.25f, 0.4f);
            placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().offset(0,-1, -2), Direction.EAST, 2, 0.25f, 0.4f);
            placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().offset(0,-1, 3), Direction.EAST, 2, 0.25f, 0.4f);

            return;
        }

        boolean topBranch = pAttachment.radiusOffset() >= 10;

        int horisontalPos = pAttachment.radiusOffset() - (topBranch ? 10 : 0);
        Direction direction = directionMap[horisontalPos / 2];
        int handedness = (horisontalPos % 2) * 2 -1;

        if (topBranch) branchLen =  pRandom.nextInt(2, 4);
        else branchLen =  pRandom.nextInt(3, 6);

        BlockPos currentPos;
        int offsetAngle = pRandom.nextInt(-1, 3);
        int offsetCumulative = offsetAngle;
        float veritacalOffsetAngle = MapRandomFloat(pRandom.nextFloat(), -0.45F, 0.65F);
        for (int currentBranchProgress = 0; currentBranchProgress < branchLen; currentBranchProgress++)
        {
            currentPos = pAttachment.pos().above((int)(veritacalOffsetAngle * (currentBranchProgress+1))).relative(direction, currentBranchProgress).relative(direction.getClockWise(), handedness * (offsetCumulative/2));

            if (placeLog(pLevel, pBlockSetter, currentPos, pConfig.trunkProvider.getState(pRandom, pAttachment.pos()), direction)) {
                tryPlaceLeaf(pLevel, pBlockSetter, pRandom, pConfig, currentPos.above());
                //placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().relative(direction.getClockWise(),(currentBranchProgress > 0? -1: -2)), direction.getClockWise(), (currentBranchProgress > 0? 3: 5), 0.25f, 0.4f);
                placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos(), direction.getClockWise(), 5, 0f, 0f);

                if (currentBranchProgress == 0) tryPlaceLeaf(pLevel, pBlockSetter, pRandom, pConfig, currentPos.relative(direction, -1));
                if (currentBranchProgress == branchLen-1) {
                    tryPlaceLeaf(pLevel, pBlockSetter, pRandom, pConfig, currentPos.relative(direction, 1));
                    tryPlaceLeaf(pLevel, pBlockSetter, pRandom, pConfig, currentPos.relative(direction, 2));
                    if (pRandom.nextBoolean()) tryPlaceLeaf(pLevel, pBlockSetter, pRandom, pConfig, currentPos.relative(direction, 3));
                    tryPlaceLeaf(pLevel, pBlockSetter, pRandom, pConfig, currentPos.relative(direction, 1).relative(direction.getClockWise(), 1));
                    tryPlaceLeaf(pLevel, pBlockSetter, pRandom, pConfig, currentPos.relative(direction, 1).relative(direction.getClockWise(), -1));
                    if (pRandom.nextBoolean()) tryPlaceLeaf(pLevel, pBlockSetter, pRandom, pConfig, currentPos.relative(direction, 2).relative(direction.getClockWise(), 1));
                    if (pRandom.nextBoolean()) tryPlaceLeaf(pLevel, pBlockSetter, pRandom, pConfig, currentPos.relative(direction, 2).relative(direction.getClockWise(), -1));
                }


            }else break;
            offsetAngle = Math.max(-1 ,Math.min(2 ,offsetAngle + pRandom.nextInt(-1, 2)));
            offsetCumulative += offsetAngle;
        }
    }

    @Override
    public int foliageHeight(RandomSource pRandom, int pHeight, TreeConfiguration pConfig) {
        return 0;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource pRandom, int pLocalX, int pLocalY, int pLocalZ, int pRange, boolean pLarge) {
        return false;
    }

    private float MapRandomFloat(float value, float bound_1, float bound_2){
        return value * (bound_2 - bound_1) + bound_1;
    }

    private boolean placeLog(LevelSimulatedReader pLevel, FoliageSetter pBlockSetter, BlockPos pPos, BlockState pBlock, Direction pDirection){
        if (!TreeFeature.validTreePos(pLevel, pPos)) {
            return false;
        }
        pBlockSetter.set(pPos, pBlock.trySetValue(RotatedPillarBlock.AXIS, pDirection.getAxis()));
        return true;
    }

    private void placeLeavesRow(LevelSimulatedReader pLevel, FoliagePlacer.FoliageSetter pFoliageSetter, RandomSource pRandom, TreeConfiguration pTreeConfiguration, BlockPos pPos, Direction pDirection, int pLength, float pDroopChance, float pDroopExtensionChance){
        BlockPos.MutableBlockPos mutableBlockPos = pPos.mutable();


        for (int i = 0; i < pLength; ++i){
            if (tryPlaceLeaf(pLevel, pFoliageSetter, pRandom, pTreeConfiguration, mutableBlockPos) && pRandom.nextFloat() <= pDroopChance){
                tryPlaceLeaf(pLevel, pFoliageSetter, pRandom, pTreeConfiguration, mutableBlockPos.below());
                if (pRandom.nextFloat() <= pDroopExtensionChance){
                    tryPlaceLeaf(pLevel, pFoliageSetter, pRandom, pTreeConfiguration, mutableBlockPos.below(2));
                }
            }
            mutableBlockPos.move(pDirection);
        }
        System.out.println(pPos);
    }
}
