package ltst.org.attribute.info;

import cn.hutool.core.util.ByteUtil;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

/**
 * RuntimeInvisibleTypeAnnotations 属性是 ClassFIle、field_info、method_info 结构或code 属性 attributes表中的变长属性
 * RuntimeInvisibleTypeAnnotations 属性记录了 对应类声明、字段或方法声明所使用的类型上面的不可见注解，也记录了标注在对应方法体中某个表达式所使用的类型上面的运行时不可见注解。
 * RuntimeInvisibleTypeAnnotations_attribute {
 *     u2 attribute_name_index;
 *     u2 attribute_length;
 *     u2 num_annotations;
 *     type_annotation annotations[num_annotations];
 * }
 */
public class RuntimeInvisibleTypeAnnotations {
    public short attributeNameIndex;
    public short attributeLength;
    public short numAnnotations;
    public TypeAnnotation[] annotations;
    public RuntimeInvisibleTypeAnnotations(ClassReader cr){
        this.attributeNameIndex = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.attributeLength = ByteUtil.bytesToShort(cr.readU2(),ByteOrder.BIG_ENDIAN);
        this.numAnnotations = ByteUtil.bytesToShort(cr.readU2(),ByteOrder.BIG_ENDIAN);
        this.annotations = new TypeAnnotation[numAnnotations];
        for (int i = 0; i < this.annotations.length; i++) {
            this.annotations[i] = new TypeAnnotation(cr);
        }
    }
}
