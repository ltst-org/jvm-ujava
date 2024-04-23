package ltst.org.attribute.info.typeannotation.targetinfo;

import cn.hutool.core.util.ByteUtil;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

/**
 * {
 *     u2 start_pc
 *     u2 length;
 *     u2 index;
 * }
 */
public class LocalvarTable {
    public short startPc;
    public short length;
    public short index;
    public LocalvarTable(ClassReader cr){
        this.startPc = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.length = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.index = ByteUtil.bytesToShort(cr.readU2(),ByteOrder.BIG_ENDIAN);
    }
}
