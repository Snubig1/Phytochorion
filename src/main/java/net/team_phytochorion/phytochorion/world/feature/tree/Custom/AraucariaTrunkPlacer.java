package net.team_phytochorion.phytochorion.world.feature.tree.Custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.RandomSource;
import net.team_phytochorion.phytochorion.blocks.PhytochorionBlocks;
import net.team_phytochorion.phytochorion.world.feature.tree.PhytochorionTrunkPlacers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Tuple;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.IntStream;

public class AraucariaTrunkPlacer extends TrunkPlacer {
    public static final Codec<AraucariaTrunkPlacer> CODEC = RecordCodecBuilder.create((placer) ->
            trunkPlacerParts(placer).apply(placer, AraucariaTrunkPlacer::new));

    public AraucariaTrunkPlacer(int pBaseHeight, int pHeightRandA, int pHeightRandB) {
        super(pBaseHeight, pHeightRandA, pHeightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() { return PhytochorionTrunkPlacers.ARAUCARIA_TRUNK_PLACER.get(); }



    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> biConsumer, RandomSource random, int treeHeight, BlockPos basePos, TreeConfiguration treeConfiguration) {

        List<FoliagePlacer.FoliageAttachment> attachmentPointList = new ArrayList<>();

        int maxBranchAmount = 3;
        int maxBranchLength = 3;

        int branchAmount = random.nextInt(1,maxBranchAmount+1);

        int[] branchLengths = new int[branchAmount];
        branchLengths[0] = random.nextInt(1,maxBranchLength+1);
        for(int i = 1; i < branchAmount; i++)
        {
            List<Integer> potentialBranchLengths = new ArrayList<>(IntStream.range(1, maxBranchLength + 1).boxed().toList());
            potentialBranchLengths.remove((Integer) branchLengths[i - 1]);
            branchLengths[i] = potentialBranchLengths.get(random.nextInt(potentialBranchLengths.size()));
        }



        setDirtAt(level, biConsumer, random, basePos.below(), treeConfiguration);



        for(int i = 0; i < treeHeight; ++i) {

            placeLog(level, biConsumer, random, basePos.above(i), treeConfiguration);
        }

        attachmentPointList.add(new FoliagePlacer.FoliageAttachment(basePos.above(treeHeight), Direction.UP.ordinal(),true));
        Tuple<BlockPos, Direction> tempAtatchmentPoint;
        for(int i = 0; i < branchAmount; i++ )
        {
            int temp = 0;
            if (branchLengths[i] == 1) temp = 10;


            tempAtatchmentPoint = PlaceBranch(biConsumer, basePos.above((treeHeight-(2*i))-2), Direction.NORTH,branchLengths[i], MapRandomFloat(random.nextFloat(),-0.7f,0.7f), 1, random);
            attachmentPointList.add(new FoliagePlacer.FoliageAttachment(tempAtatchmentPoint.getA(),tempAtatchmentPoint.getB().ordinal() + temp,i==0 || branchLengths[i] > branchLengths[i-1]));

            tempAtatchmentPoint = PlaceBranch(biConsumer, basePos.above((treeHeight-(2*i))-2), Direction.SOUTH,branchLengths[i], MapRandomFloat(random.nextFloat(),-0.7f,0.7f), 1, random);
            attachmentPointList.add(new FoliagePlacer.FoliageAttachment(tempAtatchmentPoint.getA(),tempAtatchmentPoint.getB().ordinal() + temp,i==0 || branchLengths[i] > branchLengths[i-1]));

            tempAtatchmentPoint = PlaceBranch(biConsumer, basePos.above((treeHeight-(2*i))-2), Direction.WEST,branchLengths[i], MapRandomFloat(random.nextFloat(),-0.7f,0.7f), 1, random);
            attachmentPointList.add(new FoliagePlacer.FoliageAttachment(tempAtatchmentPoint.getA(),tempAtatchmentPoint.getB().ordinal() + temp,i==0 || branchLengths[i] > branchLengths[i-1]));

            tempAtatchmentPoint = PlaceBranch(biConsumer, basePos.above((treeHeight-(2*i))-2), Direction.EAST,branchLengths[i], MapRandomFloat(random.nextFloat(),-0.7f,0.7f), 1, random);
            attachmentPointList.add(new FoliagePlacer.FoliageAttachment(tempAtatchmentPoint.getA(),tempAtatchmentPoint.getB().ordinal() + temp,i==0 || branchLengths[i] > branchLengths[i-1]));
        }
        if (random.nextBoolean()) attachmentPointList.add(new FoliagePlacer.FoliageAttachment(basePos.above((treeHeight-(2*branchAmount))-2),Direction.DOWN.ordinal(),false));

        if (random.nextInt(0,3) == 0 && (treeHeight - ((branchAmount*2)+4) > 5)) {
            tempAtatchmentPoint = PlaceBranch(biConsumer, basePos.above(random.nextInt(5, (treeHeight - ((branchAmount * 2) + 4)))), Direction.Plane.HORIZONTAL.getRandomDirection(random), random.nextInt(1, 3), Math.signum(random.nextFloat()-0.5f), 0, random);
            attachmentPointList.add(new FoliagePlacer.FoliageAttachment(tempAtatchmentPoint.getA().above(), Direction.UP.ordinal(), true));
        }


        return attachmentPointList;
    }

    private Tuple<BlockPos, Direction> PlaceBranch(BiConsumer<BlockPos,BlockState> biConsumer, BlockPos position, Direction direction, int brancLength, RandomSource random){
        return PlaceBranch(biConsumer, position, direction, brancLength, 0, 1, random);
    }

    private Tuple<BlockPos, Direction> PlaceBranch(BiConsumer<BlockPos,BlockState> biConsumer, BlockPos position, Direction direction, int branchLength, float directionOffsetH, int crownExtendedBy, RandomSource random) {
        BlockState branchBlock = BlockStateProvider.simple(PhytochorionBlocks.ARAUCARIA_BRANCHES.get()).getState(random, position);
        for(int i = 0; i < branchLength; i++)
        {
            PlaceBlock(biConsumer, position.relative(direction,i+1).relative(direction.getClockWise(),Math.round((i+1)*directionOffsetH)), branchBlock.setValue(RotatedPillarBlock.AXIS, direction.getAxis()));
        }
        return new Tuple<>(position.relative(direction,branchLength+crownExtendedBy).relative(direction.getClockWise(),Math.round(branchLength*directionOffsetH)), direction);

    }

    private float MapRandomFloat(float value, float bound_1, float bound_2){
        return value * (bound_2 - bound_1) + bound_1;
    }

    private void PlaceBlock(BiConsumer<BlockPos,BlockState> biConsumer, BlockPos position, BlockState block) {

        biConsumer.accept(position, block);
    }
}
