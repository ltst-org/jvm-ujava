package ltst.org.attribute.info;

import cn.hutool.core.util.ByteUtil;
import ltst.org.attribute.AttributeInfo;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

/**
 * RuntimeVisibleAnnotations 属性是变长属性，位于ClassFile、field_info、method_info 结构的属性表中。
 * 表示运行时可见，
 * RuntimeVisibleAnnotations_attribute{
 *     u2 attribute_name_index;
 *     u4 attribute_length;
 *     u2 num_annotations;
 *     annotation annotations[num_annotations];
 * }
 */
public class RuntimeVisibleAnnotations extends AttributeInfo {
    public short numAnnotations;
    public Annotation[] annotations;
    public RuntimeVisibleAnnotations(ClassReader cr) {
        super(cr);
        this.numAnnotations = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.annotations = new Annotation[numAnnotations];
        for (int i = 0; i < this.annotations.length; i++) {
            this.annotations[i] = new Annotation(cr);
        }
    }
}
