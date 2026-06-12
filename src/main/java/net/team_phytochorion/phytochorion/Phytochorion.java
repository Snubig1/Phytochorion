package net.team_phytochorion.phytochorion;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.Sheets;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.team_phytochorion.phytochorion.block.entity.PhytochorionBlockEntities;
import net.team_phytochorion.phytochorion.effect.PhytochorionMobEffects;
import net.team_phytochorion.phytochorion.items.PhytochorionItems;
import net.team_phytochorion.phytochorion.misc.PhytochorionBurnables;
import net.team_phytochorion.phytochorion.misc.PhytochorionCreativeModeTabs;
import net.team_phytochorion.phytochorion.misc.PhytochorionWoodTypes;
import net.team_phytochorion.phytochorion.world.feature.PhytochorionFeatures;
import net.team_phytochorion.phytochorion.world.feature.tree.PhytochorionFoliagePlacers;
import net.team_phytochorion.phytochorion.world.feature.tree.PhytochorionTrunkPlacers;
import net.team_phytochorion.phytochorion.world.levelgen.PhytochorionRegion;
import net.team_phytochorion.phytochorion.world.levelgen.PhytochorionSurfaceRuleData;
import org.slf4j.Logger;

import net.team_phytochorion.phytochorion.block.PhytochorionBlocks;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

import static net.minecraft.resources.ResourceLocation.fromNamespaceAndPath;


@Mod(Phytochorion.MOD_ID)
public class Phytochorion
{
    public static final String MOD_ID = "phytochorion";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Phytochorion(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();
        modEventBus.addListener(this::commonSetup);
        PhytochorionCreativeModeTabs.register(modEventBus);
        PhytochorionBlocks.register(modEventBus);
        PhytochorionMobEffects.register(modEventBus);
        PhytochorionBlockEntities.register(modEventBus);
        PhytochorionFeatures.register(modEventBus);
        PhytochorionTrunkPlacers.register(modEventBus);
        PhytochorionFoliagePlacers.register(modEventBus);
        PhytochorionItems.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    //game starts
    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() ->
        {
            Regions.register(new PhytochorionRegion(fromNamespaceAndPath(MOD_ID, "overworld"), 1));
            SurfaceRuleManager.addToDefaultSurfaceRulesAtStage(SurfaceRuleManager.RuleCategory.OVERWORLD, SurfaceRuleManager.RuleStage.AFTER_BEDROCK,0, PhytochorionSurfaceRuleData.makeRules());
            PhytochorionBurnables.AddBurnables();
            System.out.println("test");
        });
    }

    //world starts
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        //client starts
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            Sheets.addWoodType(PhytochorionWoodTypes.ARAUCARIA);
            Sheets.addWoodType(PhytochorionWoodTypes.GINKGO);
        }
    }

    @SubscribeEvent
    public void heal(LivingHealEvent event) {
        if (event.getEntity().hasEffect(PhytochorionMobEffects.SAPPED.get())) {
            event.setCanceled(true);
            System.out.println("Healed (or did you)");
        }
    }
}
