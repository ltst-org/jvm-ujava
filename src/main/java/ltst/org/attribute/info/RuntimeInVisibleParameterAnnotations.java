package ltst.org.attribute.info;

import ltst.org.attribute.AttributeInfo;
import ltst.org.classfile.ClassReader;

/**
 * RuntimeInVisibleParameterAnnotations 是边长属性，位于 method_info 结构得属性表中。
 * RuntimeInVisibleParameterAnnotations 属性记录了 对应方法得形式参数生命上面得运行时不可见注解
 * 每个 method_info 结构的属性表中最多只能包含一个  RuntimeInVisibleParameterAnnotations 属性
 *
 * RuntimeInVisibleParameterAnnotations_attribute {
 *     u2 attribute_name_index;
 *     u4 attribute_length;
 *     u1 num_parameters;
 *     {
 *         u2 num_annotations;
 *         annotation annotations[num_annotations];
 *     } parameter_annotations[num_parameters];
 * }
 */
public class RuntimeInVisibleParameterAnnotations extends AttributeInfo {
    public byte numParameters;
    public ParameterAnnotation[] parameterAnnotaion;

    public RuntimeInVisibleParameterAnnotations(ClassReader cr) {
        super(cr);
        this.numParameters = cr.readU1();
        this.parameterAnnotaion = new ParameterAnnotation[numParameters];
        for (int i = 0; i < this.parameterAnnotaion.length; i++) {
            this.parameterAnnotaion[i] = new ParameterAnnotation(cr);
        }
    }
}
