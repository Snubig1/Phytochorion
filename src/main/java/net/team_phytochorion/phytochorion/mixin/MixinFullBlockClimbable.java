package net.team_phytochorion.phytochorion.mixin;


import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Optional;


@Mixin(LivingEntity.class)
public abstract class MixinFullBlockClimbable extends Entity {

    public MixinFullBlockClimbable(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Inject(method = "onClimbable", at = @At("TAIL"), locals = LocalCapture.CAPTURE_FAILHARD)
    public void onClimbable(CallbackInfoReturnable<Boolean> cir, BlockPos blockpos, BlockState blockstate, Optional<BlockPos> ladderPos)
    {
        //ladderPos =
        LivingEntity thisEntity = (LivingEntity)(Object)this;
        level().addParticle(ParticleTypes.NOTE, thisEntity.getBoundingBox().minX, thisEntity.getBoundingBox().maxY, thisEntity.getBoundingBox().minZ, 0, 0, 0);

    }
}

