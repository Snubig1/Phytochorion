package net.team_phytochorion.phytochorion.block;


import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.common.extensions.IForgeBlock;

public class PhytochorionLog extends RotatedPillarBlock implements IForgeBlock {
    private final BlockState strippedBlock;
    public PhytochorionLog(BlockState pStrippedBlock, Properties pProperties) {
        super(pProperties);
        this.strippedBlock = pStrippedBlock;
    }

    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate)
    {
        if (toolAction == ToolActions.AXE_STRIP) {
            if (strippedBlock == null) return null;
            return strippedBlock.setValue(RotatedPillarBlock.AXIS, state.getValue(AXIS));
        }
        return null;
    }
}
