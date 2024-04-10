package ltst.org.attribute.info;

import cn.hutool.core.util.ByteUtil;
import ltst.org.attribute.AttributeInfo;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

/**
 * Signature 属性是可选的定长属性，位于ClassFile、field_info或method_info结构的属性表中
 * Signature_attribute{
 *     u2 attribute_name_index;
 *     u4 attribute_length;
 *     u2 signature_index;
 * }
 */
//TODO 签名 需要详细处理
public class Signature extends AttributeInfo {
    public short signatureIndex;
    public Signature(ClassReader cr) {
        super(cr);
        this.signatureIndex = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
    }
}
