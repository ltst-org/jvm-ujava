package ltst.org.constantpool.constantinfo;

import cn.hutool.core.util.ByteUtil;
import lombok.ToString;
import ltst.org.classfile.ClassReader;
import ltst.org.constantpool.ConstantTag;
import ltst.org.constantpool.CpInfo;

import java.nio.ByteOrder;

/**
 * 用于表示方法类型
 * CONSTANT_MethodType_info {
 *     u1 tag;
 *     u2 descriptor_index;
 * }
 */
@ToString
public class MethodTypeInfo extends CpInfo {
    /**
     * u2 类型
     * 对应常量池有效索引 对应的成员必须是 CONSTANT_Utf8
     */
    public short descriptorIndex;

    public MethodTypeInfo(short descriptorIndex){
        this.tag = ConstantTag.CONSTANT_MethodType;
        this.descriptorIndex = descriptorIndex;
    }
    public static MethodTypeInfo parse(ClassReader cr){
        return new MethodTypeInfo(
                ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN)
        );
    }
}
