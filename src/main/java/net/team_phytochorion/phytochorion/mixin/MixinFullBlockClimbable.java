package net.team_phytochorion.phytochorion.mixin;


import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Optional;


@Mixin(LivingEntity.class)
public class MixinFullBlockClimbable {
    @Inject(method = "onClimbable", at = @At("TAIL"), locals = LocalCapture.CAPTURE_FAILHARD)
    public void onClimbable(CallbackInfoReturnable<Boolean> cir, BlockPos blockpos, BlockState blockstate, Optional<BlockPos> ladderPos)
    {
        //ladderPos =
    }



}

