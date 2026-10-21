package net.team_phytochorion.phytochorion.block;


import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
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

public class ButterflyWeed extends FlowerBlock implements BonemealableBlock {
    public ButterflyWeed() {
        super(() -> MobEffects.SLOW_FALLING, 4, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
    }

    public void animateTick(BlockState p_222503_, Level p_222504_, BlockPos p_222505_, RandomSource p_222506_) {
        int i = p_222505_.getX();
        int j = p_222505_.getY();
        int k = p_222505_.getZ();
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for(int l = 0; l < 14; ++l) {
            blockpos$mutableblockpos.set(i + Mth.nextInt(p_222506_, -5, 5), j + p_222506_.nextInt(7), k + Mth.nextInt(p_222506_, -5, 5));
            BlockState blockstate = p_222504_.getBlockState(blockpos$mutableblockpos);
            if (!blockstate.isCollisionShapeFullBlock(p_222504_, blockpos$mutableblockpos)) {
                p_222504_.addParticle(ParticleTypes.END_ROD, (double)blockpos$mutableblockpos.getX() + p_222506_.nextDouble(), (double)blockpos$mutableblockpos.getY() + p_222506_.nextDouble(), (double)blockpos$mutableblockpos.getZ() + p_222506_.nextDouble(), 0.0D, 0.0D, 0.0D);
            }
        }

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
