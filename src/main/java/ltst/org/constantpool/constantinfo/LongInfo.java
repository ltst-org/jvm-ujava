package ltst.org.constantpool.constantinfo;

import cn.hutool.core.util.ByteUtil;
import lombok.ToString;
import ltst.org.classfile.ClassReader;
import ltst.org.constantpool.ConstantTag;
import ltst.org.constantpool.CpInfo;

import java.nio.ByteOrder;

/**
 * CONSTANT_Long_Info
 * tag = CONSTANT_Long(5)
 *
 * CONSTANT_Long_info{
 *     u1 tag;
 *     u4 high_bytes;
 *     u4 low_bytes;
 * }
 */
@ToString
public class LongInfo extends CpInfo {
    /**
     * u4 类型
     */
    public int highBytes;
    /**
     * u4 类型
     */
    public int lowBytes;
    public LongInfo(int highBytes,int lowBytes){
        this.tag = ConstantTag.CONSTANT_Long;
        this.highBytes = highBytes;
        this.lowBytes = lowBytes;
    }
    public static LongInfo parse(ClassReader cr){
        return new LongInfo(
                ByteUtil.bytesToInt(cr.readU4(), ByteOrder.BIG_ENDIAN),//high_bytes
                ByteUtil.bytesToInt(cr.readU4(),ByteOrder.BIG_ENDIAN)//low_bytes
        );
    }
}
