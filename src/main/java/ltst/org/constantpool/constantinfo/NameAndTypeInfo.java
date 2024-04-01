package ltst.org.constantpool.constantinfo;

import cn.hutool.core.util.ByteUtil;
import lombok.ToString;
import ltst.org.classfile.ClassReader;
import ltst.org.constantpool.ConstantTag;
import ltst.org.constantpool.CpInfo;

import java.nio.ByteOrder;

/**
 * 用于表示字段或方法
 * CONSTANT_NameAndType_info {
 *     u1 tag;
 *     u2 name_index;
 *     u2 descriptor_index;
 * }
 *
 */
@ToString
public class NameAndTypeInfo extends CpInfo {
    /**
     * u2 类型
     * 常量池有效索引 对应的常量池成员为 CONSTANT_Utf8_info
     */
    public short nameIndex;
    /**
     * u2 类型
     * 常量池有效索引 对应的常量池成员为 CONSTANT_Utf8_info
     */
    public short descriptorIndex;
    public NameAndTypeInfo(short nameIndex,short descriptorIndex){
        this.tag = ConstantTag.CONSTANT_NameAndType;
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
    }

    public static NameAndTypeInfo parse(ClassReader cr){
        return new NameAndTypeInfo(
                ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN),//nameIndex
                ByteUtil.bytesToShort(cr.readU2(),ByteOrder.BIG_ENDIAN)//descriptorIndex;
        );
    }
}
