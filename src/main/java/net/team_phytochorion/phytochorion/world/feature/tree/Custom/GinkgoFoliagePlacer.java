package net.team_phytochorion.phytochorion.world.feature.tree.Custom;

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

    static Direction[] directionMap = {
            Direction.NORTH,
            Direction.EAST,
            Direction.SOUTH,
            Direction.WEST
    };

    @Override
    protected void createFoliage(LevelSimulatedReader pLevel, FoliageSetter pBlockSetter, RandomSource pRandom, TreeConfiguration pConfig, int pMaxFreeTreeHeight, FoliageAttachment pAttachment, int pFoliageHeight, int pFoliageRadius, int pOffset) {
        int branchLen;

        boolean topBranch = pAttachment.radiusOffset() >= 10;

        int horisontalPos = pAttachment.radiusOffset() - (topBranch ? 10 : 0);
        Direction direction = directionMap[horisontalPos / 2];
        int handedness = (horisontalPos % 2) * 2 -1;

        if (topBranch) branchLen =  pRandom.nextInt(2, 4);
        else branchLen =  pRandom.nextInt(3, 6);

        BlockPos currentPos;
        int offsetAngle = pRandom.nextInt(-1, 3);
        int offsetCumulative = offsetAngle;
        placeLog(pLevel, pBlockSetter, pAttachment.pos(), pConfig.trunkProvider.getState(pRandom, pAttachment.pos()), direction);
        for (int currentBranchProgress = 1; currentBranchProgress < branchLen; currentBranchProgress++)
        {
            currentPos = pAttachment.pos().relative(direction, currentBranchProgress).relative(direction.getClockWise(), handedness * (offsetCumulative/2));

            if (placeLog(pLevel, pBlockSetter, currentPos, pConfig.trunkProvider.getState(pRandom, pAttachment.pos()), direction)) {

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

    private boolean placeLog(LevelSimulatedReader pLevel, FoliageSetter pBlockSetter, BlockPos pPos, BlockState pBlock, Direction pDirection){
        if (!TreeFeature.validTreePos(pLevel, pPos)) {
            return false;
        }
        pBlockSetter.set(pPos, pBlock.trySetValue(RotatedPillarBlock.AXIS, pDirection.getAxis()));
        return true;
    }
}
