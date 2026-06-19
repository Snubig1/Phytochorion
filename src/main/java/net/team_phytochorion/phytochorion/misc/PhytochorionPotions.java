package net.team_phytochorion.phytochorion.misc;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.team_phytochorion.phytochorion.Phytochorion;
import net.team_phytochorion.phytochorion.effect.PhytochorionMobEffects;

public class PhytochorionPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, Phytochorion.MOD_ID);

    public static final RegistryObject<Potion> SAPPING = POTIONS.register("sapping", () -> new Potion(new MobEffectInstance(PhytochorionMobEffects.SAPPED.get(), 432)));
    public static final  RegistryObject<Potion> LONG_SAPPING = POTIONS.register("long_sapping", () -> new Potion(new MobEffectInstance(PhytochorionMobEffects.SAPPED.get(), 900)));


    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
