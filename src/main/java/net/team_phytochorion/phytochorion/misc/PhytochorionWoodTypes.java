package net.team_phytochorion.phytochorion.misc;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.team_phytochorion.phytochorion.Phytochorion;

public class PhytochorionWoodTypes {
    public static final WoodType ARAUCARIA = WoodType.register(new WoodType(Phytochorion.MOD_ID + ":araucaria", BlockSetType.OAK));
    public static final WoodType GINKGO = WoodType.register(new WoodType(Phytochorion.MOD_ID + ":ginkgo", BlockSetType.OAK));
}
