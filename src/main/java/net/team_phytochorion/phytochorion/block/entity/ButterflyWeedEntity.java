package net.team_phytochorion.phytochorion.block.entity;

import com.mojang.logging.LogUtils;
import com.mojang.serialization.Dynamic;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.slf4j.Logger;

import java.util.Collections;
import java.util.List;

public class ButterflyWeedEntity extends BlockEntity {

    private static final Logger LOGGER = LogUtils.getLogger();
    public List<ResourceLocation> butterflyParticles;

    public ButterflyWeedEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
        this.butterflyParticles = Collections.emptyList();
    }

    public ButterflyWeedEntity(BlockPos pPos, BlockState pBlockState) {
        this(PhytochorionBlockEntities.BUTTERFLY_WEED.get(), pPos, pBlockState);
    }

    public void load(CompoundTag pTag) {
        super.load(pTag);
        if (pTag.contains("butterfly_particle", Tag.TAG_LIST)) {
            ResourceLocation.CODEC.listOf().parse(new Dynamic<>(NbtOps.INSTANCE, pTag.getCompound("butterfly_particle"))).resultOrPartial(LOGGER::error).ifPresent((p_281146_) -> {
                this.butterflyParticles = p_281146_;
            });
        }
    }

    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        ResourceLocation.CODEC.listOf().encodeStart(NbtOps.INSTANCE, this.butterflyParticles).resultOrPartial(LOGGER::error).ifPresent((p_222820_) -> {
            pTag.put("butterfly_particle", p_222820_);
        });
    }
}
