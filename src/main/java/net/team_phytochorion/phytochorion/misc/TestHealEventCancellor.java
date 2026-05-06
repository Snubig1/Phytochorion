package net.team_phytochorion.phytochorion.misc;

import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class TestHealEventCancellor {

    @SubscribeEvent
    public void heal(LivingHealEvent event) {
        event.setCanceled(true);
        System.out.println("Healed (or did you)");
    }
}
