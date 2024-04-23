package ltst.org.attribute.info.typeannotation.targetinfo;

import cn.hutool.core.util.ByteUtil;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

/**
 * throws_target{
 *     u2 throws_type_index;
 * }
 */
public class ThrowsTarget extends TargetInfo{
    public short throwTypeIndex;
    public ThrowsTarget(ClassReader cr){
        this.throwTypeIndex = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
    }
}
