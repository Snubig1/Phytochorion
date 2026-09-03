package net.team_phytochorion.phytochorion.world.feature.tree.Custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
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

    static Direction[] directionMap = {Direction.NORTH,Direction.EAST, Direction.SOUTH, Direction.WEST};

    @Override
    protected void createFoliage(LevelSimulatedReader pLevel, FoliageSetter pBlockSetter, RandomSource pRandom, TreeConfiguration pConfig, int pMaxFreeTreeHeight, FoliageAttachment pAttachment, int pFoliageHeight, int pFoliageRadius, int pOffset) {
        tryPlaceLeaf(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos());

        int branchLen = 0;

        boolean topBranch = pAttachment.radiusOffset() >= 10;

        Direction direction = directionMap[(pAttachment.radiusOffset() - (topBranch? 10: 0))/2];
        System.out.println(direction);
        System.out.println((pAttachment.radiusOffset() - (topBranch? 10: 0))/2);
        System.out.println(pAttachment.pos());
        if (topBranch) branchLen =  pRandom.nextInt(2, 4);
        else branchLen =  pRandom.nextInt(3, 6);

        for (int currentBranchLen = 0; currentBranchLen < branchLen; currentBranchLen++)
        {
            tryPlaceLeaf(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().relative(direction, currentBranchLen));
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
}
