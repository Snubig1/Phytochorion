package net.team_phytochorion.phytochorion.misc;

import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class TestHealEventCancellor {

    @SubscribeEvent
    public void heal(LivingHealEvent event) {
        if (event.getEntity().hasEffect(MobEffects.BLINDNESS)) {
            event.setCanceled(true);
        }
        System.out.println("Item picked up!");
    }
}
