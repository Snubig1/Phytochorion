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


public class GinkgoFoliagePlacer extends FoliagePlacer {
    public static final Codec<GinkgoFoliagePlacer> CODEC = RecordCodecBuilder.create((placer) ->
            foliagePlacerParts(placer).apply(placer, GinkgoFoliagePlacer::new));

    public GinkgoFoliagePlacer(IntProvider p_161411_, IntProvider p_161412_) {
        super(p_161411_, p_161412_);
    }

    @Override
    protected FoliagePlacerType<?> type() {return PhytochorionFoliagePlacers.GINKGO_FOLIAGE_PLACER.get();}

    @Override
    protected void createFoliage(LevelSimulatedReader level, FoliageSetter foliageSetter, RandomSource random, TreeConfiguration configuration, int p_161426_, FoliageAttachment attachment, int p_161428_, int p_161429_, int p_161430_) {
        tryPlaceLeaf(level, foliageSetter, random, configuration, attachment.pos());
        int topHeight =random.nextInt(2,4);
        for (int y =0; y <= topHeight; ++y)
        {
            tryPlaceLeaf(level, foliageSetter, random, configuration, attachment.pos().above(y));
        }
        for (int y =-5; y <= 0; ++y)
        {
            tryPlaceLeaf(level, foliageSetter, random, configuration, attachment.pos().above(y).north());
            tryPlaceLeaf(level, foliageSetter, random, configuration, attachment.pos().above(y).south());
            tryPlaceLeaf(level, foliageSetter, random, configuration, attachment.pos().above(y).west());
            tryPlaceLeaf(level, foliageSetter, random, configuration, attachment.pos().above(y).east());
        }
        if (random.nextBoolean()) tryPlaceLeaf(level, foliageSetter, random, configuration, attachment.pos().above().north());
        if (random.nextBoolean()) tryPlaceLeaf(level, foliageSetter, random, configuration, attachment.pos().above().south());
        if (random.nextBoolean()) tryPlaceLeaf(level, foliageSetter, random, configuration, attachment.pos().above().west());
        if (random.nextBoolean()) tryPlaceLeaf(level, foliageSetter, random, configuration, attachment.pos().above().east());

        int cornerHeight =random.nextInt(-5,-3);
        int topCornerHeight =random.nextInt(-2,0);
        for (int y =cornerHeight; y <= topCornerHeight; ++y)
            tryPlaceLeaf(level, foliageSetter, random, configuration, attachment.pos().above(y).north().east());

        cornerHeight =random.nextInt(-5,-3);
        topCornerHeight =random.nextInt(-2,0);
        for (int y =cornerHeight; y <= topCornerHeight; ++y)
            tryPlaceLeaf(level, foliageSetter, random, configuration, attachment.pos().above(y).south().west());

        cornerHeight =random.nextInt(-5,-3);
        topCornerHeight =random.nextInt(-2,0);
        for (int y =cornerHeight; y <= topCornerHeight; ++y)
            tryPlaceLeaf(level, foliageSetter, random, configuration, attachment.pos().above(y).north().west());

        cornerHeight =random.nextInt(-5,-3);
        topCornerHeight =random.nextInt(-2,0);
        for (int y =cornerHeight; y <= topCornerHeight; ++y)
            tryPlaceLeaf(level, foliageSetter, random, configuration, attachment.pos().above(y).south().east());



        for (int y =-4; y <= -2; ++y)
            tryPlaceLeaf(level, foliageSetter, random, configuration, attachment.pos().above(y).north(2).east(random.nextInt(-1, 2)));

        for (int y =-4; y <= -2; ++y)
            tryPlaceLeaf(level, foliageSetter, random, configuration, attachment.pos().above(y).south(2).west(random.nextInt(-1, 2)));

        for (int y =-4; y <= -2; ++y)
            tryPlaceLeaf(level, foliageSetter, random, configuration, attachment.pos().above(y).west(2).south(random.nextInt(-1, 2)));

        for (int y =-4; y <= -2; ++y)
            tryPlaceLeaf(level, foliageSetter, random, configuration, attachment.pos().above(y).east(2).north(random.nextInt(-1, 2)));

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
