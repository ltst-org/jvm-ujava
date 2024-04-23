package ltst.org.attribute.info.parameters;

import cn.hutool.core.util.ByteUtil;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

/**
 *   {
 *      u2 name_index;
 *      u2 access_flags;
 *   }parameters[parameters_count];
 */
public class Parameters {
    public short nameIndex;
    public short accessFlags;
    public Parameters(ClassReader cr){
        this.nameIndex = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.accessFlags = ByteUtil.bytesToShort(cr.readU2(),ByteOrder.BIG_ENDIAN);
    }
}
