package net.team_phytochorion.phytochorion.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class Sapped extends MobEffect {
    protected Sapped(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        
    }

        @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier){
        return true;
    }
}
