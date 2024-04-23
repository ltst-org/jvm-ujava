package ltst.org.attribute.info;

import ltst.org.attribute.AttributeInfo;
import ltst.org.classfile.ClassReader;

/**
 * RuntimeVisibleTypeAnnotations 属性是 ClassFile 、 field_info 、method_info 结构或者 code 属性 attributes 表中的变长属性
 * RuntimeVisibleTypeAnnotations 属性记录了标注在对应类声明、字段声明或者方法声明上的运行时可见注解
 * RuntimeVisibleTypeAnnotations_attribute{
 *     u2 attribute_name_index;
 *     u4 attribute_length;
 *     u2 num_annotations;
 *     type_annotation annotations[num_annotations];
 * }
 */
public class RuntimeVisibleTypeAnnotations extends AttributeInfo {
    public short numAnnotations;
    public TypeAnnotation[] annotations;
    public RuntimeVisibleTypeAnnotations(ClassReader cr) {
        super(cr);
    }
}
