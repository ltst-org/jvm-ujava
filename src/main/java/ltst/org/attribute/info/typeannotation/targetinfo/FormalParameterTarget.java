package ltst.org.attribute.info.typeannotation.targetinfo;

import ltst.org.classfile.ClassReader;

/**
 * formal_parameter_target {
 *     u1 formal_parameter_index;
 * }
 */
public class FormalParameterTarget extends TargetInfo{
    public byte formalParameterIndex;
    public FormalParameterTarget(ClassReader cr){
        this.formalParameterIndex = cr.readU1();
    }
}
