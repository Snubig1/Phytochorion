package net.team_phytochorion.phytochorion.mixin.points;

import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.LineNumberNode;
import org.spongepowered.asm.mixin.injection.InjectionPoint;
import org.spongepowered.asm.mixin.injection.InjectionPoint.AtCode;
import org.spongepowered.asm.mixin.injection.struct.InjectionPointData;

import java.util.Collection;
import java.util.HashMap;


@AtCode("START_LOOP")
public class StartOfLoop extends InjectionPoint {

    public StartOfLoop(InjectionPointData data) {
        super(data);
    }

    @Override
    public boolean checkPriority(int targetPriority, int ownerPriority) {
        return true;
    }

    @Override
    public boolean find(String desc, InsnList insns, Collection<AbstractInsnNode> nodes) {
        HashMap<Integer, Integer> foundLineNrs = new HashMap<>();
        for (int i = 0; i < insns.size(); i++ )
        {
            if (insns.get(i).getType() == AbstractInsnNode.LINE) {
                int currentLineNr = ((LineNumberNode)insns.get(i)).line;
                if (!foundLineNrs.containsKey(currentLineNr))
                    foundLineNrs.put(currentLineNr, i);
                else
                {
                    System.out.println("=========================================================");
                    System.out.println(insns.get(foundLineNrs.get(currentLineNr)));
                    nodes.add(insns.get(foundLineNrs.get(currentLineNr)));
                }
            }
        }
        return true;
    }
}
