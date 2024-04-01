package ltst.org.constantpool.constantinfo;

import cn.hutool.core.util.ByteUtil;
import lombok.ToString;
import ltst.org.classfile.ClassReader;
import ltst.org.constantpool.ConstantTag;
import ltst.org.constantpool.CpInfo;

import java.nio.ByteOrder;

/**
 * 表示 float 的数值常量
 * CONSTANT_Float_info {
 *     u1 tag;
 *     u4 bytes;
 * }
 */
@ToString
public class FloatInfo extends CpInfo {
    /**
     * u4 类型
     * 4字节 的 数值 常量
     */
    public int bytes;
    public FloatInfo(int bytes){
        this.tag = ConstantTag.CONSTANT_Float;
        this.bytes = bytes;
    }
    public static FloatInfo parse(ClassReader cr){
        return new FloatInfo(
                ByteUtil.bytesToInt(cr.readU4(), ByteOrder.BIG_ENDIAN)
        );
    }
}
