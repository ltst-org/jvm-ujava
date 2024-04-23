package ltst.org.attribute.info.typeannotation.targetinfo;

import cn.hutool.core.util.ByteUtil;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

/**
 * supertype_target{
 *     u2 supertype_index;
 * }
 */
public class SupertypeTarget extends TargetInfo{
    public short supertypeIndex;
    public SupertypeTarget(ClassReader cr){
        this.supertypeIndex = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
    }
}
