package net.team_phytochorion.phytochorion.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.team_phytochorion.phytochorion.Phytochorion;

public class PhytochorionMobEffects {

    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Phytochorion.MOD_ID);

    public static final RegistryObject<MobEffect> SAPPED =  EFFECTS.register("sapped", () -> new Sapped(MobEffectCategory.HARMFUL, 13550788));


    public static void register(IEventBus eventBus) {
        EFFECTS.register(eventBus);
    }
}
