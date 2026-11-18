package net.team_phytochorion.phytochorion.butterfly;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Collections;
import java.util.List;

public class ButterflyDataDescription {

    public final ResourceLocation butterflyParticle;
    public final List<BlockState> blocks;


    public static final  Codec<ButterflyDataDescription> CODEC = RecordCodecBuilder.create(
            instance -> instance.group(
                    ResourceLocation.CODEC.fieldOf("butterfly_particle").forGetter((ButterflyDataDescription description) -> description.butterflyParticle),
                    BlockState.CODEC.listOf().fieldOf("blocks").forGetter((ButterflyDataDescription description) -> description.blocks)
            ).apply(instance, ButterflyDataDescription::new)
    );

    public ButterflyDataDescription(ResourceLocation pButterflyParticle, List<BlockState> pBlockstates) {
        butterflyParticle = pButterflyParticle;
        blocks = pBlockstates;
    }
}
