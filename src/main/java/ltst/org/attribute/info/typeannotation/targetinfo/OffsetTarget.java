package ltst.org.attribute.info.typeannotation.targetinfo;

import cn.hutool.core.util.ByteUtil;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

/**
 * offset_target {
 *     u2 offset;
 * }
 */
public class OffsetTarget extends TargetInfo{
    public short offset;
    public OffsetTarget(ClassReader cr){
        this.offset = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
    }
}
