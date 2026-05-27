package net.team_phytochorion.phytochorion.block;


import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import javax.annotation.Nullable;

public class GhostPipe extends FlowerBlock implements BonemealableBlock {
    public static final BooleanProperty DAMAGED = BooleanProperty.create("damaged");
    public GhostPipe() {
        super(() -> MobEffects.WEAKNESS, 9, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
        this.registerDefaultState(this.defaultBlockState().setValue(DAMAGED, false));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(DAMAGED);
    }

    @Override
    public void destroy(LevelAccessor pLevel, BlockPos pPos, BlockState pState) {
        if (!pState.getValue(DAMAGED)) {
            pLevel.setBlock(pPos, pState.setValue(DAMAGED, true), 3);
        }
    }

    @Override
    public void playerDestroy(Level pLevel, Player pPlayer, BlockPos pPos, BlockState pState, @Nullable BlockEntity pBlockEntity, ItemStack pTool) {
        if (pState.getValue(DAMAGED)) {
            dropResources(pState, pLevel, pPos, pBlockEntity, pPlayer, pTool, false);
            pPlayer.awardStat(Stats.BLOCK_MINED.get(this));
            pPlayer.causeFoodExhaustion(0.005F);
        }
    }

    @Override
    public void playerWillDestroy(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
        this.spawnDestroyParticles(pLevel, pPlayer, pPos, pState);
        if (!pState.getValue(DAMAGED)) {
            if (pPlayer.isLocalPlayer()) {
                assert ((LocalPlayer) pPlayer).minecraft.gameMode != null;
                ((LocalPlayer) pPlayer).minecraft.gameMode.destroyDelay = 5;
            }
        }


        pLevel.gameEvent(GameEvent.BLOCK_DESTROY, pPos, GameEvent.Context.of(pPlayer, pState));
    }

    public boolean isValidBonemealTarget(LevelReader pLevelReader, BlockPos pPos, BlockState pBlockState, boolean pIsClientside) {
        return true;
    }
    public boolean isBonemealSuccess(Level pLevel, RandomSource pRandomSource, BlockPos pPos, BlockState pBlockState) {
        return true;
    }
    public void performBonemeal(ServerLevel pServerLevel, RandomSource pRandomSource, BlockPos pPos, BlockState pBlockState) {
        this.properties.destroyTime(-1f);
        for (Direction direction: Direction.Plane.HORIZONTAL.shuffledCopy(pRandomSource)) {
            BlockPos positionToPlace = pPos.relative(direction, 1);
            if (pServerLevel.isEmptyBlock(positionToPlace) && this.canSurvive(this.defaultBlockState(), pServerLevel, positionToPlace)) {
                pServerLevel.setBlock(positionToPlace, this.defaultBlockState(), 3);
                break;
            }
        }

    }
}
