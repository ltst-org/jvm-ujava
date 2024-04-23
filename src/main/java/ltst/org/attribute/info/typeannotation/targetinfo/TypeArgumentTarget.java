package ltst.org.attribute.info.typeannotation.targetinfo;

import cn.hutool.core.util.ByteUtil;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

/**
 * type_argument_target {
 *     u2 offset;
 *     u1 type_argument_index;
 * }
 */
public class TypeArgumentTarget extends TargetInfo{
    public short offset;
    public byte typeArgumentIndex;
    public TypeArgumentTarget(ClassReader cr){
        this.offset = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.typeArgumentIndex = cr.readU1();
    }
}
