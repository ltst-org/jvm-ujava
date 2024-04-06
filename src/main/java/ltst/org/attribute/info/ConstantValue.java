package ltst.org.attribute.info;

import cn.hutool.core.util.ByteUtil;
import lombok.ToString;
import ltst.org.attribute.AttributeInfo;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

/**
 * ConstantValue_attribute{
 *     u2 attribute_name_index;
 *     u4 attribute_length;
 *     u2 constantvalue_idnex;
 * }
 * constantvalue_index 代表常量池的有效索引。表示该索引处的成员给出了该属性对应的值
 * long                             - CONSTANT_Long
 * float                            - CONSTANT_Float
 * double                           - CONSTANT_Double
 * int、short、char、byte、boolean   - CONSTANT_Integer
 * String                           - CONSTANT_String
 */
@ToString
public class ConstantValue extends AttributeInfo {
    public short constantValueIndex;

    public ConstantValue(ClassReader cr,short constantValueIndex){
        super(cr);
        this.constantValueIndex = constantValueIndex;
    }

    public static ConstantValue parse(ClassReader cr){
        return new ConstantValue(
                cr,
                ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN)
        );
    }
}
