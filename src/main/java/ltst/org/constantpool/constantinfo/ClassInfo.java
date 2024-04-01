package ltst.org.constantpool.constantinfo;

import cn.hutool.core.util.ByteUtil;
import lombok.ToString;
import ltst.org.classfile.ClassReader;
import ltst.org.constantpool.ConstantTag;
import ltst.org.constantpool.CpInfo;

import java.nio.ByteOrder;

/**
 * CONSTANT_Class_Info
 * tag = CONSTANT_Class(7)
 * nameIndex 指向常量池有效索引，一定是 UTF8 info
 * CONSTANT_Class_info {
 *     u1 tag;
 *     u2 name_index;
 * }
 */
@ToString
public class ClassInfo extends CpInfo {
    public short classIndex;
    public ClassInfo(short nameIndex){
        this.tag = ConstantTag.CONSTANT_Class;
        this.classIndex = nameIndex;
    }

    public static ClassInfo parse(ClassReader cr){
        return new ClassInfo(
                ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN)
        );
    }
}
