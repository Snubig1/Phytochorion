package net.team_phytochorion.phytochorion.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Gui.class)
public class MixinSappedGui {

    @Inject(method = "renderHearts", at = @At(value = "LABEL"))
    protected void renderHearts(GuiGraphics pGuiGraphics, Player pPlayer, int pX, int pY, int pHeight, int pOffsetHeartIndex, float pMaxHealth, int pCurrentHealth, int pDisplayHealth, int pAbsorptionAmount, boolean pRenderHighlight, CallbackInfo ci, @Local(name = "i") int i, @Local(name = "l1") int l1, @Local(name = "i2") int i2)
    {
        //this.renderHeart(pGuiGraphics, Gui.HeartType.FROZEN, l1, i2, i, pRenderHighlight, false);
    }
    @Inject(method = "renderHeart", at = @At(value = "TAIL"))
    private void renderHeart(GuiGraphics pGuiGraphics, Gui.HeartType pHeartType, int pX, int pY, int pYOffset, boolean pRenderHighlight, boolean pHalfHeart, CallbackInfo ci)
    {
        //pGuiGraphics.blit(GUI_ICONS_LOCATION, 50, 50, 0, 0, 250, 250);

    }

    @Shadow
    protected static final ResourceLocation GUI_ICONS_LOCATION = ResourceLocation.parse("textures/gui/icons.png");
    @Shadow
    private void renderHeart(GuiGraphics pGuiGraphics, Gui.HeartType pHeartType, int pX, int pY, int pYOffset, boolean pRenderHighlight, boolean pHalfHeart) {}

}
