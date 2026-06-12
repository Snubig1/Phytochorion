package net.team_phytochorion.phytochorion.mixin.points;

import java.util.Collection;
import java.util.HashMap;

import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.LineNumberNode;
import org.spongepowered.asm.mixin.injection.InjectionPoint;
import org.spongepowered.asm.mixin.injection.InjectionPoint.AtCode;
import org.spongepowered.asm.mixin.injection.struct.InjectionPointData;

/**
 * <p>This injection point simply returns the first instruction in the target
 * method body, allowing the injection to be placed at the "head" of the target
 * method. It accepts no parameters and only returns a single insn in all
 * circumstances.</p>
 *
 * <p>Example:</p>
 * <blockquote><pre>
 *   &#064;At("LABEL")</pre>
 * </blockquote>
 */
@AtCode("LOOP")
public class EndOfLoop extends InjectionPoint {

    public EndOfLoop(InjectionPointData data) {
        super(data);
    }

    @Override
    public boolean checkPriority(int targetPriority, int ownerPriority) {
        return true;
    }

    @Override
    public boolean find(String desc, InsnList insns, Collection<AbstractInsnNode> nodes) {
        HashMap<Integer, LineNumberNode> foundLineNrs = new HashMap<>();
        for (int i = 0; i < insns.size(); i++ )
        {
            if (insns.get(i).getType() == AbstractInsnNode.LINE) {
                int currentLineNr = ((LineNumberNode)insns.get(i)).line;
                if (!foundLineNrs.containsKey(currentLineNr))
                    foundLineNrs.put(currentLineNr, ((LineNumberNode)insns.get(i)));
                else
                {
                    nodes.add(insns.get(i));
                    System.out.println(currentLineNr);
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
                }

            }
        }
        return true;
    }
}
