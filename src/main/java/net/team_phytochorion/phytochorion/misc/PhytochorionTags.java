package net.team_phytochorion.phytochorion.misc;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.team_phytochorion.phytochorion.Phytochorion;
import static net.minecraft.resources.ResourceLocation.fromNamespaceAndPath;

public class PhytochorionTags {

    public static final TagKey<Block> CLIMBABLE_FULL_BLOCK = tag("climbable_full_block");

    private static TagKey<Block> tag(String tag) {
        return BlockTags.create( fromNamespaceAndPath(Phytochorion.MOD_ID, tag));
    }
}
