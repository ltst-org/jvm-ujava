package ltst.org.attribute.info;

import cn.hutool.core.util.ByteUtil;
import ltst.org.attribute.AttributeInfo;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

/**
 * EnclosingMethod 属性是可选的定长属性，位于ClassFile 结构的属性表中
 * EnclosingMethod_attribute{
 *     u2 attribute_name_index;
 *     u4 attribute_length;
 *     u2 class_index;
 *     u2 method_index;
 * }
 */
public class EnclosingMethod extends AttributeInfo {
    public short classIndex;
    public short methodIndex;
    public EnclosingMethod(ClassReader cr) {
        super(cr);
        this.classIndex = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.methodIndex = ByteUtil.bytesToShort(cr.readU2(),ByteOrder.BIG_ENDIAN);
    }
}
