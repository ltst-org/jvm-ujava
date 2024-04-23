package ltst.org.attribute.info.typeannotation.targetinfo;

import ltst.org.classfile.ClassReader;

/**
 * type_parameter_bound_target {
 *     u1 type_parameter_index;
 *     u1 bound_index;
 * }
 */
public class TypeParameterBoundTarget extends TargetInfo{
    public byte typeParameterIndex;
    public byte boundIndex;
    public TypeParameterBoundTarget(ClassReader cr){
        this.typeParameterIndex = cr.readU1();
        this.boundIndex = cr.readU1();
    }
}
