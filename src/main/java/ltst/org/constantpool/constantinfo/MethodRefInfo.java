package ltst.org.constantpool.constantinfo;

import cn.hutool.core.util.ByteUtil;
import lombok.ToString;
import ltst.org.classfile.ClassReader;
import ltst.org.constantpool.ConstantTag;
import ltst.org.constantpool.CpInfo;

import java.nio.ByteOrder;

/**
 * CONSTANT_Methodref
 * tag = CONSTANT_Methodref(10)
 *
 * CONSTANT_Methodref_info{
 *     u1 tag;
 *     u2 class_index;
 *     u2 name_and_type_index;
 * }
 */
@ToString
public class MethodRefInfo extends CpInfo {
    public short classIndex ;
    public short nameAndTypeIndex;
    public MethodRefInfo(short classIndex, short nameAndTypeIndex){
        this.tag = ConstantTag.CONSTANT_Methodref;
        /**
         * classIndex 是指 CONSTANT_Class 的索引
         */
        this.classIndex = classIndex;
        /**
         * u2 类型
         * nameAndTypeIndex 是指 CONSTANT_NameAndType 的 索引
         * 如果一个 CONSTANT_Methodref 方法名是已 < 开头 即 '\u003c' 那么方法名一定是 <init> 为类的初始化方法，返回类型必须是 void
         */
        this.nameAndTypeIndex = nameAndTypeIndex;
    }
    public static MethodRefInfo parse(ClassReader cr){
        return new MethodRefInfo(
                ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN),
                ByteUtil.bytesToShort(cr.readU2(),ByteOrder.BIG_ENDIAN)
        );
    }
}
