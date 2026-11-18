package net.team_phytochorion.phytochorion.block;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.team_phytochorion.phytochorion.block.entity.ButterflyWeedEntity;
import net.team_phytochorion.phytochorion.misc.PhytochorionRegistries;


public class ButterflyWeedBlock extends FlowerBlock implements BonemealableBlock, EntityBlock {
    public ButterflyWeedBlock() {
        super(() -> MobEffects.SLOW_FALLING, 4, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
    }

    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
        if (blockEntity instanceof ButterflyWeedEntity butterflyWeedBlockEntity) {
            System.out.println(butterflyWeedBlockEntity.butterflyParticles);
        }
        int i = pPos.getX();
        int j = pPos.getY();
        int k = pPos.getZ();
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for(int l = 0; l < 14; ++l) {
            blockpos$mutableblockpos.set(i + Mth.nextInt(pRandom, -5, 5), j + pRandom.nextInt(7), k + Mth.nextInt(pRandom, -5, 5));
            BlockState blockstate = pLevel.getBlockState(blockpos$mutableblockpos);
            if (!blockstate.isCollisionShapeFullBlock(pLevel, blockpos$mutableblockpos)) {
                pLevel.addParticle(ParticleTypes.END_ROD, (double)blockpos$mutableblockpos.getX() + pRandom.nextDouble(), (double)blockpos$mutableblockpos.getY() + pRandom.nextDouble(), (double)blockpos$mutableblockpos.getZ() + pRandom.nextDouble(), 0.0D, 0.0D, 0.0D);
            }
        }

    }

    public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        if (pLevel instanceof ServerLevel) {
            pLevel.registryAccess().registryOrThrow(PhytochorionRegistries.BUTTERFLIES);
        }
        return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
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

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new ButterflyWeedEntity(pPos, pState);
    }
}
