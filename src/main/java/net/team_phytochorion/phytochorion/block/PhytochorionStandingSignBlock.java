package net.team_phytochorion.phytochorion.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.team_phytochorion.phytochorion.block.entity.PhytochorionSignBlockEntity;

public class PhytochorionStandingSignBlock extends StandingSignBlock {
    public PhytochorionStandingSignBlock(Properties pProperties, WoodType pType) {
        super(pProperties, pType);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState){
        return new PhytochorionSignBlockEntity(pPos, pState);
    }
}
