package net.team_phytochorion.phytochorion.misc;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class FullBlockClimbable {
    public static Optional<BlockPos> isOnFullBlockClimbable(Level level, @NotNull LivingEntity entity) {
        if (!(entity instanceof Player && entity.isSpectator())) {
            AABB entityBoundingBox = entity.getBoundingBox();
            int minX = Mth.floor(entityBoundingBox.minX- 0.125);
            int minZ = Mth.floor(entityBoundingBox.minZ- 0.125);
            int Y = Mth.floor((int)entityBoundingBox.minY);
            int maxX = Mth.floor(entityBoundingBox.maxX+ 0.125);
            int maxZ = Mth.floor(entityBoundingBox.maxZ+ 0.125);
            for (int X = minX; X <= maxX; X++){
                for (int Z = minZ; Z <= maxZ; Z++){
                    if (level.getBlockState(new BlockPos(X, Y, Z)).is(PhytochorionTags.CLIMBABLE_FULL_BLOCK)){
                        return Optional.of(new BlockPos(X, Y, Z));
                    }
                }
            }
        }
        return Optional.empty();
    }
}
