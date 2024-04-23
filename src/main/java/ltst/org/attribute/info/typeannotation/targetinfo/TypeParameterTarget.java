package ltst.org.attribute.info.typeannotation.targetinfo;

import ltst.org.classfile.ClassReader;

/**
 * type_parameter_target {
 *     u1 type_parameter_index;
 * }
 */
public class TypeParameterTarget extends TargetInfo{
    public byte typeParameterIndex;
    public TypeParameterTarget(ClassReader cr){
        this.typeParameterIndex = cr.readU1();
    }
}
