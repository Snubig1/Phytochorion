package net.team_phytochorion.phytochorion.mixin;


import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.team_phytochorion.phytochorion.misc.FullBlockClimbable;
import org.spongepowered.asm.mixin.Mixin;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.Optional;


@Mixin(LivingEntity.class)
public abstract class MixinFullBlockClimbable extends Entity {

    public MixinFullBlockClimbable(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @ModifyVariable(method = "onClimbable", at = @At("STORE"), name = "ladderPos")
    public Optional<BlockPos> onClimbable(Optional<BlockPos> ladderPos)
    {
        LivingEntity thisEntity = (LivingEntity)(Object)this;
        if (ladderPos.isEmpty()) return FullBlockClimbable.isOnFullBlockClimbable(level(), thisEntity);
        else return ladderPos;
    }
}

