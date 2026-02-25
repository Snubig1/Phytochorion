package net.team_phytochorion.phytochorion.world.feature.tree.Custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.team_phytochorion.phytochorion.world.feature.tree.PhytochorionFoliagePlacers;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;


public class AraucariaFoliagePlacer extends FoliagePlacer {
    public static final Codec<AraucariaFoliagePlacer> CODEC = RecordCodecBuilder.create((placer) ->
            foliagePlacerParts(placer).apply(placer, AraucariaFoliagePlacer::new));

    public AraucariaFoliagePlacer(IntProvider p_161411_, IntProvider p_161412_) {
        super(p_161411_, p_161412_);
    }

    @Override
    protected FoliagePlacerType<?> type() {return PhytochorionFoliagePlacers.ARAUCARIA_FOLIAGE_PLACER.get();}

    @Override
    protected void createFoliage(LevelSimulatedReader level, FoliagePlacer.FoliageSetter biConsumer, RandomSource random, TreeConfiguration configuration, int p_161426_, FoliageAttachment attachment, int p_161428_, int p_161429_, int p_161430_) {
        Direction direction;

        tryPlaceLeaf(level, biConsumer, random, configuration, attachment.pos());

        if (attachment.radiusOffset() == 1)
        {
            tryPlaceLeaf(level, biConsumer, random, configuration, attachment.pos().above());
            tryPlaceLeaf(level, biConsumer, random, configuration, attachment.pos().north());
            tryPlaceLeaf(level, biConsumer, random, configuration, attachment.pos().south());
            tryPlaceLeaf(level, biConsumer, random, configuration, attachment.pos().west());
            tryPlaceLeaf(level, biConsumer, random, configuration, attachment.pos().east());
            tryPlaceLeaf(level, biConsumer, random, configuration, attachment.pos().above().north(2));
            tryPlaceLeaf(level, biConsumer, random, configuration, attachment.pos().above().south(2));
            tryPlaceLeaf(level, biConsumer, random, configuration, attachment.pos().above().west(2));
            tryPlaceLeaf(level, biConsumer, random, configuration, attachment.pos().above().east(2));
        }

        if (attachment.radiusOffset() >= 10) direction = Direction.values()[attachment.radiusOffset()-10];
        else direction = Direction.values()[attachment.radiusOffset()];


        if (attachment.radiusOffset() != 0 && attachment.radiusOffset() != 1) {
            tryPlaceLeaf(level, biConsumer, random, configuration, attachment.pos().relative(direction, 1));
            tryPlaceLeaf(level, biConsumer, random, configuration, attachment.pos().relative(direction, -1).relative(direction.getClockWise(), 1));
            tryPlaceLeaf(level, biConsumer, random, configuration, attachment.pos().relative(direction, -1).relative(direction.getClockWise(), -1));

            if (attachment.radiusOffset()< 10){
                tryPlaceLeaf(level, biConsumer, random, configuration, attachment.pos().relative(direction.getClockWise(), 1));
                tryPlaceLeaf(level, biConsumer, random, configuration, attachment.pos().relative(direction.getClockWise(), -1));
            }
            if (attachment.doubleTrunk()){
                tryPlaceLeaf(level, biConsumer, random, configuration, attachment.pos().relative(direction, 2).above());

                if (attachment.radiusOffset()< 10){
                    tryPlaceLeaf(level, biConsumer, random, configuration, attachment.pos().relative(direction, -1).relative(direction.getClockWise(), 2).above());
                    tryPlaceLeaf(level, biConsumer, random, configuration, attachment.pos().relative(direction, -1).relative(direction.getClockWise(), -2).above());
                    tryPlaceLeaf(level, biConsumer, random, configuration, attachment.pos().relative(direction, 1).relative(direction.getClockWise(), 2).above());
                    tryPlaceLeaf(level, biConsumer, random, configuration, attachment.pos().relative(direction, 1).relative(direction.getClockWise(), -2).above());
                }
                else{
                    tryPlaceLeaf(level, biConsumer, random, configuration, attachment.pos().relative(direction.getClockWise(), 2).above());
                }
            }
        }

        if (attachment.radiusOffset() == 0){
            tryPlaceLeaf(level, biConsumer, random, configuration, attachment.pos().north());
            tryPlaceLeaf(level, biConsumer, random, configuration, attachment.pos().south());
            tryPlaceLeaf(level, biConsumer, random, configuration, attachment.pos().west());
            tryPlaceLeaf(level, biConsumer, random, configuration, attachment.pos().east());
        }
    }


    @Override
    public int foliageHeight(RandomSource p_68568_, int p_68569_, TreeConfiguration p_68570_) {
        return 0;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource p_68562_, int p_68563_, int p_68564_, int p_68565_, int p_68566_, boolean p_68567_) {
        return false;
    }
}
