package net.team_phytochorion.phytochorion.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class PhytochorionHangingSignBlockEntity extends HangingSignBlockEntity {
    public PhytochorionHangingSignBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(PhytochorionBlockEntities.PHYTOCHORION_HANGING_SIGN.get(), pPos, pBlockState);
    }

    @Override
    public BlockEntityType<?> getType(){
        return PhytochorionBlockEntities.PHYTOCHORION_HANGING_SIGN.get();
    }
}
