package net.team_phytochorion.phytochorion.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.entity.monster.Witch;
import net.team_phytochorion.phytochorion.effect.PhytochorionMobEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Witch.class)
public class MixinSappedWitch {

    @WrapOperation(method = "aiStep", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/monster/Witch;getMaxHealth()F"))
    private float hasSappedWrap(Witch instance, Operation<Float> original) {
        if (instance.hasEffect(PhytochorionMobEffects.SAPPED.get()))return instance.getHealth();
        return original.call(instance);
    }


}
