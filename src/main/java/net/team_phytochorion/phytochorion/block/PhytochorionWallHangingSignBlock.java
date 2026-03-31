package net.team_phytochorion.phytochorion.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.team_phytochorion.phytochorion.block.entity.PhytochorionHangingSignBlockEntity;

public class PhytochorionWallHangingSignBlock extends WallHangingSignBlock {
    public PhytochorionWallHangingSignBlock(Properties pProperties, WoodType pType) {
        super(pProperties, pType);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState){
        return new PhytochorionHangingSignBlockEntity(pPos, pState);
    }
}
