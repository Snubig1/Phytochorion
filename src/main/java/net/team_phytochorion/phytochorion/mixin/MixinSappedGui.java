package net.team_phytochorion.phytochorion.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.team_phytochorion.phytochorion.effect.PhytochorionMobEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Gui.class)
public class MixinSappedGui {

    @Inject(method = "renderHearts", at = @At(value = "LOOP"))
    protected void renderHearts(GuiGraphics pGuiGraphics, Player pPlayer, int pX, int pY, int pHeight, int pOffsetHeartIndex, float pMaxHealth, int pCurrentHealth, int pDisplayHealth, int pAbsorptionAmount, boolean pRenderHighlight, CallbackInfo ci, @Local(name = "l1") int l1, @Local(name = "i2") int i2, @Local(name = "j2") int j2, @Local(name = "flag") boolean flag)
    {
        if (pPlayer.hasEffect(PhytochorionMobEffects.SAPPED.get())){
            if (!flag && pCurrentHealth <= j2) {
                pGuiGraphics.blit(PHYTOCHORION_GUI_ICONS_LOCATION, l1, i2, 0, 0, 9, 9);
            } else if (pCurrentHealth - 1 == j2) {
                pGuiGraphics.blit(PHYTOCHORION_GUI_ICONS_LOCATION, l1, i2, 9, 0, 9, 9);
            }
        }
    }

    @Unique
    private static final ResourceLocation PHYTOCHORION_GUI_ICONS_LOCATION = ResourceLocation.fromNamespaceAndPath("phytochorion", "textures/gui/icons.png");

}
