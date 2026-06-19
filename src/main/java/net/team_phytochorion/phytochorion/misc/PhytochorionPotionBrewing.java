package net.team_phytochorion.phytochorion.misc;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.team_phytochorion.phytochorion.block.PhytochorionBlocks;

public class PhytochorionPotionBrewing {

    public static void addRecipes()
    {
        PotionBrewing.addMix(Potions.REGENERATION, PhytochorionBlocks.GHOST_PIPE.get().asItem(), PhytochorionPotions.SAPPING.get());
        PotionBrewing.addMix(Potions.STRONG_REGENERATION, PhytochorionBlocks.GHOST_PIPE.get().asItem(), PhytochorionPotions.SAPPING.get());
        PotionBrewing.addMix(Potions.LONG_REGENERATION, PhytochorionBlocks.GHOST_PIPE.get().asItem(), PhytochorionPotions.LONG_SAPPING.get());
        PotionBrewing.addMix(PhytochorionPotions.SAPPING.get(), Items.REDSTONE, PhytochorionPotions.LONG_SAPPING.get());
    }
}
