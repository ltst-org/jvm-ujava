package ltst.org.attribute.info.typeannotation.typepath;

import ltst.org.classfile.ClassReader;

/**
 * {
 *     u1 type_path_kind;
 *     u1 type_argument_index;
 * }
 *
 * type_path_kind
 * 0-注解位于数组类型的深处
 * 1-注解位于嵌套类型的深处
 * 2-注解添加在参数化类型中某个通配符类型参数的边界上
 * 3-注解添加在参数化类型中的某个类型参数上
 */
public class PathInfo {
    public byte typePathKind;
    public byte typeArgumentIndex;
    public PathInfo(ClassReader cr){
        this.typePathKind = cr.readU1();
        this.typeArgumentIndex = cr.readU1();
    }
}
