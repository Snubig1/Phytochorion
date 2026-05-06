package net.team_phytochorion.phytochorion.block;


import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class GhostPipe extends FlowerBlock implements BonemealableBlock {
    public GhostPipe() {
        super(() -> MobEffects.WEAKNESS, 9, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
    }

    public boolean isValidBonemealTarget(LevelReader pLevelReader, BlockPos pPos, BlockState pBlockState, boolean pIsClientside) {
        return true;
    }
    public boolean isBonemealSuccess(Level pLevel, RandomSource pRandomSource, BlockPos pPos, BlockState pBlockState) {
        return true;
    }
    public void performBonemeal(ServerLevel pServerLevel, RandomSource pRandomSource, BlockPos pPos, BlockState pBlockState) {
        popResource(pServerLevel, pPos, new ItemStack(this));
    }
}
