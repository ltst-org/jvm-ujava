package ltst.org.constantpool.constantinfo;

import cn.hutool.core.util.ByteUtil;
import lombok.ToString;
import ltst.org.classfile.ClassReader;
import ltst.org.constantpool.ConstantTag;
import ltst.org.constantpool.CpInfo;

import java.nio.ByteOrder;

/**
 * CONSTANT_Fieldref
 * tag = CONSTANT_Fieldref(9)
 *
 * CONSTANT_Fieldref_info {
 *     u1 tag;
 *     u2 class_index; 必须指向常量池的 CONSTANT_Class_info
 *     u2 name_and_type_index; 必须指向常量池的 CONSTANT_NameAndType_info
 * }
 */
@ToString
public class FieldRefInfo extends CpInfo {
    public short classIndex;
    public short nameAndTypeIndex;
    public FieldRefInfo(short classIndex,short nameAndTypeIndex){
        this.tag = ConstantTag.CONSTANT_Fieldref;
        /**
         * classIndex 是指 CONSTANT_Class 的索引
         */
        this.classIndex = classIndex;
        /**
         * u2 类型
         * nameAndTypeIndex 是指 CONSTANT_NameAndType 的 索引
         */
        this.nameAndTypeIndex = nameAndTypeIndex;
    }
    public static FieldRefInfo parse(ClassReader cr){
        return new FieldRefInfo(
                ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN),
                ByteUtil.bytesToShort(cr.readU2(),ByteOrder.BIG_ENDIAN)
        );
    }
}
