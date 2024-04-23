package ltst.org.attribute.info.typeannotation.targetinfo;

import cn.hutool.core.util.ByteUtil;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

/**
 * catch_target {
 *     u2 exception_table_index;
 * }
 */
public class CatchTarget extends TargetInfo{
    public short exceptionTableIndex;
    public CatchTarget(ClassReader cr){
        this.exceptionTableIndex = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
    }
}
