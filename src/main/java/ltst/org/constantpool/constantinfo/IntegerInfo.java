package ltst.org.constantpool.constantinfo;

import cn.hutool.core.util.ByteUtil;
import lombok.ToString;
import ltst.org.classfile.ClassReader;
import ltst.org.constantpool.ConstantTag;
import ltst.org.constantpool.CpInfo;

import java.nio.ByteOrder;

/**
 * 表示 4 字节 int 数值常量
 * CONSTANT_Integer_info {
 *     u1 tag;
 *     u4 bytes;
 * }
 */
@ToString
public class IntegerInfo extends CpInfo {
    /**
     * u4 类型
     * 4字节 的 数值 常量
     */
    public int bytes;
    public IntegerInfo (int bytes){
        this.tag = ConstantTag.CONSTANT_Integer;
        this.bytes = bytes;
    }
    public static IntegerInfo parse(ClassReader cr){
        return new IntegerInfo(
                ByteUtil.bytesToInt(cr.readU4(), ByteOrder.BIG_ENDIAN)
        );
    }
}
