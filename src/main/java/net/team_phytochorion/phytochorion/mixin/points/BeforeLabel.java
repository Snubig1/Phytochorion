package net.team_phytochorion.phytochorion.mixin.points;

import java.util.Collection;

import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.InsnList;
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
@AtCode("LABEL")
public class BeforeLabel extends InjectionPoint {

    public BeforeLabel(InjectionPointData data) {
        super(data);
    }

    @Override
    public boolean checkPriority(int targetPriority, int ownerPriority) {
        return true;
    }

    @Override
    public boolean find(String desc, InsnList insns, Collection<AbstractInsnNode> nodes) {
        System.out.println(insns.getFirst());
        System.out.println(insns.get(0));
        System.out.println(insns.get(1));
        System.out.println(insns.get(2));
        System.out.println(insns.size());
        System.out.println("=========================================");
        System.out.println("=========================================");
        System.out.println("=========================================");
        System.out.println("=========================================");
        System.out.println("=========================================");
        nodes.add(insns.getFirst());
        return true;
    }
}
