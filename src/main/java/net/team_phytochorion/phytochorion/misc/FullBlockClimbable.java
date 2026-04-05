package net.team_phytochorion.phytochorion.misc;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class FullBlockClimbable {
    public static Optional<BlockPos> isOnFullBlockClimbable(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull LivingEntity entity) {
        if (!(entity instanceof Player && entity.isSpectator())) {
            AABB entityBoundingBox = entity.getBoundingBox();
            int minX = Mth.floor(entityBoundingBox.minX);
            int minY = Mth.floor(entityBoundingBox.minY);
            int minZ = Mth.floor(entityBoundingBox.minZ);

            for (int y2 = minY; (double) y2 < entityBoundingBox.maxY; ++y2) {
                for (int x2 = minX; (double) x2 < entityBoundingBox.maxX; ++x2) {
                    for (int z2 = minZ; (double) z2 < entityBoundingBox.maxZ; ++z2) {
                        BlockPos tmp = new BlockPos(x2, y2, z2);
                        state = level.getBlockState(tmp);
                        if (state.is(BlockTags.ACACIA_LOGS)) {
                            return Optional.of(tmp);
                        }
                    }
                }
            }

        }
        return Optional.empty();
    }
}
