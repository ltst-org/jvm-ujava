package ltst.org.constantpool.constantinfo;

import cn.hutool.core.util.ByteUtil;
import lombok.ToString;
import ltst.org.classfile.ClassReader;
import ltst.org.constantpool.ConstantTag;
import ltst.org.constantpool.CpInfo;

import java.nio.ByteOrder;

/**
 * CONSTANT_Double_Info
 * tag = CONSTANT_Double(6)
 * nameIndex 指向常量池有效索引，一定是 UTF8 info
 *
 * CONSTANT_Double_info {
 *     u1 tag;
 *     u4 high_bytes;
 *     u4 low_bytes;
 * }
 */
@ToString
public class DoubleInfo extends CpInfo {
    /**
     * u4 类型
     */
    public int highBytes;
    /**
     * u4 类型
     */
    public int lowBytes;
    public DoubleInfo(int highBytes, int lowBytes){
        this.tag = ConstantTag.CONSTANT_Double;
        this.highBytes = highBytes;
        this.lowBytes = lowBytes;
    }

    public static DoubleInfo parse(ClassReader cr){
        return new DoubleInfo(
                ByteUtil.bytesToInt(cr.readU4(), ByteOrder.BIG_ENDIAN),
                ByteUtil.bytesToInt(cr.readU4(),ByteOrder.BIG_ENDIAN)
        );
    }
}
