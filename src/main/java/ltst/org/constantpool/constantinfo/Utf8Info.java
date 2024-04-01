package ltst.org.constantpool.constantinfo;

import cn.hutool.core.util.ByteUtil;
import lombok.ToString;
import ltst.org.classfile.ClassReader;
import ltst.org.constantpool.ConstantTag;
import ltst.org.constantpool.CpInfo;

import java.nio.ByteOrder;

/**
 * 用于表示字符串常量的值
 * CONSTANT_Utf8_info{
 *     u1 tag;
 *     u2 length;
 *     u1 bytes[length];
 * }
 */
@ToString
public class Utf8Info extends CpInfo {
    /**
     * u1 类型
     * byte 数组的长度
     */
    public short length;
    /**
     * uN 类型
     * 表示字符串值的 byte 数组
     */
    public byte[] bytes;
    public Utf8Info(short length,byte[] bytes){
        this.tag = ConstantTag.CONSTANT_Utf8;
        this.length = length;
        this.bytes = bytes;
    }
    public static Utf8Info parse(ClassReader cr){
        short length = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        return new Utf8Info(
                length,//length
                cr.readN(length)//bytes
        );
    }
}
