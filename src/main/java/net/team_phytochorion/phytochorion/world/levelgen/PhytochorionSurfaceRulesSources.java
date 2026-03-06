package net.team_phytochorion.phytochorion.world.levelgen;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.util.KeyDispatchDataCodec;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.SingleThreadedRandomSource;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class PhytochorionSurfaceRulesSources {

    static record RandomBlockRuleSource(BlockState resultState, SurfaceRules.StateRule rule) implements SurfaceRules.RuleSource {
        static final KeyDispatchDataCodec<PhytochorionSurfaceRulesSources.RandomBlockRuleSource> CODEC = KeyDispatchDataCodec.of(BlockState.CODEC.xmap(PhytochorionSurfaceRulesSources.RandomBlockRuleSource::new, PhytochorionSurfaceRulesSources.RandomBlockRuleSource::resultState).fieldOf("result_state"));
        RandomBlockRuleSource(BlockState... p_189517_) {

            this(p_189517_[0], new SurfaceRules.StateRule(p_189517_[0]));
        }

        public KeyDispatchDataCodec<? extends SurfaceRules.RuleSource> codec() {
            return CODEC;
        }

        public SurfaceRules.SurfaceRule apply(SurfaceRules.Context pContext) {
            return this.rule;
        }
    }

    static Codec<? extends SurfaceRules.RuleSource> bootstrap(Registry<Codec<? extends SurfaceRules.RuleSource>> pRegistry) {
        return PhytochorionSurfaceRulesSources.register(pRegistry, "random_block", PhytochorionSurfaceRulesSources.RandomBlockRuleSource.CODEC);
    }

    static <A> Codec<? extends A> register(Registry<Codec<? extends A>> pRegistry, String pName, KeyDispatchDataCodec<? extends A> pValue) {
        return Registry.register(pRegistry, pName, pValue.codec());
    }
}
