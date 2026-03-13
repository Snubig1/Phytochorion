package net.team_phytochorion.phytochorion.world.levelgen;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

public class PhytochorionSurfaceRuleData {
    private static final SurfaceRules.RuleSource COARSE_DIRT = makeStateRule(Blocks.COARSE_DIRT);
    private static final SurfaceRules.RuleSource PODZOL = makeStateRule(Blocks.PODZOL);
    private static final SurfaceRules.RuleSource MUD = makeStateRule(Blocks.MUD);


    public static SurfaceRules.RuleSource makeRules()
    {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);
        //SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

        return SurfaceRules.sequence(

                SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), SurfaceRules.ifTrue(SurfaceRules.isBiome(PhytochorionBiomes.ARAUCARIA_FOREST) ,SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(60),0),SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(1,1), SurfaceRules.sequence(
                        SurfaceRules.ifTrue(SurfaceRules.noiseCondition(PhytochorionNoises.ARAUCARIA_SURFACE,0.20),COARSE_DIRT),
                        SurfaceRules.ifTrue(SurfaceRules.noiseCondition(PhytochorionNoises.ARAUCARIA_SURFACE,-0.30),PODZOL),
                        MUD
                ))))))
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block)
    {
        return SurfaceRules.state(block.defaultBlockState());
    }

    private static SurfaceRules.ConditionSource surfaceNoiseAbove(double p_194809_) {
        return SurfaceRules.noiseCondition(PhytochorionNoises.ARAUCARIA_SURFACE, p_194809_ / 8.25D, Double.MAX_VALUE);
    }
}
