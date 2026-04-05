
package net.team_phytochorion.phytochorion.block;

import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;


public class AraucariaLeavesBlock extends LeavesBlock {
	public AraucariaLeavesBlock() {
    super(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES));
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false));
    }

    @Override
    public void tick(BlockState p_54426_, ServerLevel p_54427_, BlockPos p_54428_, RandomSource p_54429_) {
        p_54427_.setBlock(p_54428_, updateDistance(p_54426_, p_54427_, p_54428_), 3);
    }

    public boolean isRandomlyTicking(BlockState p_54449_) {
        return !p_54449_.getValue(PERSISTENT);
    }

    @Override
    public void randomTick(BlockState p_54451_, ServerLevel p_54452_, BlockPos p_54453_, RandomSource p_54454_) {

        tick(p_54451_, p_54452_, p_54453_, p_54454_);
        p_54451_ = updateDistance(p_54451_, p_54452_, p_54453_);

        if (!p_54451_.getValue(PERSISTENT) && p_54451_.getValue(DISTANCE) == 7) {
            dropResources(p_54451_, p_54452_, p_54453_);
            p_54452_.removeBlock(p_54453_, false);
        }

    }
    static Vec3i[] directionArray = new Vec3i[]{
            new Vec3i(1,0,0),
            new Vec3i(-1,0,0),
            new Vec3i(0,1,0),
            new Vec3i(0,-1,0),
            new Vec3i(0,0,1),
            new Vec3i(0,0,-1),
            new Vec3i(1,-1,0),
            new Vec3i(-1,-1,0),
            new Vec3i(0,-1,1),
            new Vec3i(0,-1,-1),
            new Vec3i(1,-1,1),
            new Vec3i(1,-1,-1),
            new Vec3i(-1,-1,1),
            new Vec3i(-1,-1,-1)

    };

    private static BlockState updateDistance(BlockState p_54436_, LevelAccessor p_54437_, BlockPos p_54438_) {
        int i = 7;
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();



        for(Vec3i direction : directionArray) {
            blockpos$mutableblockpos.setWithOffset(p_54438_, direction);
            i = Math.min(i, getDistanceAt(p_54437_.getBlockState(blockpos$mutableblockpos)) + 1);
            if (i == 1) {
                break;
            }
        }
        return p_54436_.setValue(DISTANCE, i);
    }

    private static int getDistanceAt(BlockState p_54464_) {
        if (p_54464_.is(BlockTags.LOGS)||p_54464_.is(PhytochorionBlocks.ARAUCARIA_BRANCHES.get())) {
            return 0;
        } else {
            return p_54464_.getBlock() instanceof LeavesBlock ? p_54464_.getValue(DISTANCE) : 7;
        }
    }
}
