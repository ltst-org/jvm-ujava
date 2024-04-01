package ltst.org.constantpool.constantinfo;

import cn.hutool.core.util.ByteUtil;
import lombok.ToString;
import ltst.org.classfile.ClassReader;
import ltst.org.constantpool.ConstantTag;
import ltst.org.constantpool.CpInfo;

import java.nio.ByteOrder;

/**
 * CONSTANT_InterfaceMethodref_info
 * tag = CONSTANT_InterfaceMethodref(11)
 *
 * CONSTANT_InterfaceMethodref_info {
 *     u1 tag;
 *     u2 class_index;
 *     u2 name_and_type_index;
 * }
 */
@ToString
public class InterfaceMethodRef extends CpInfo {
    public short classIndex;
    public short nameAndTypeIndex;
    public InterfaceMethodRef(short classIndex, short nameAndTypeIndex){
       this.tag = ConstantTag.CONSTANT_InterfaceMethodref;
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
    public static InterfaceMethodRef parse(ClassReader cr){
        return new InterfaceMethodRef(
                ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN), //classIndex
                ByteUtil.bytesToShort(cr.readU2(),ByteOrder.BIG_ENDIAN) //nameAndTypeIndex
        );
    }
}
