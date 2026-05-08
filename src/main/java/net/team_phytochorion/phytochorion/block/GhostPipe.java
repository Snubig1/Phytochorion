package net.team_phytochorion.phytochorion.block;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import javax.annotation.Nullable;

public class GhostPipe extends FlowerBlock implements BonemealableBlock {
    public GhostPipe() {
        super(() -> MobEffects.WEAKNESS, 9, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
    }

    @Override
    public void playerDestroy(Level pLevel, Player pPlayer, BlockPos pPos, BlockState pState, @Nullable BlockEntity pBlockEntity, ItemStack pTool) {
        pPlayer.awardStat(Stats.BLOCK_MINED.get(this));
        pPlayer.causeFoodExhaustion(0.005F);
        pLevel.setBlock(pPos, this.defaultBlockState(), 3);
        //Forge: Don't drop xp as part of the resources as it is handled by the patches in ServerPlayerGameMode#destroyBlock
        dropResources(pState, pLevel, pPos, pBlockEntity, pPlayer, pTool, false);
    }

    public boolean isValidBonemealTarget(LevelReader pLevelReader, BlockPos pPos, BlockState pBlockState, boolean pIsClientside) {
        return true;
    }
    public boolean isBonemealSuccess(Level pLevel, RandomSource pRandomSource, BlockPos pPos, BlockState pBlockState) {
        return true;
    }
    public void performBonemeal(ServerLevel pServerLevel, RandomSource pRandomSource, BlockPos pPos, BlockState pBlockState) {
        for (Direction direction: Direction.Plane.HORIZONTAL.shuffledCopy(pRandomSource)) {
            BlockPos positionToPlace = pPos.relative(direction, 1);
            if (pServerLevel.isEmptyBlock(positionToPlace) && this.canSurvive(this.defaultBlockState(), pServerLevel, positionToPlace)) {
                pServerLevel.setBlock(positionToPlace, this.defaultBlockState(), 3);
                break;
            }
        }

    }
}
