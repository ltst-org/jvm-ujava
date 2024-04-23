package ltst.org.attribute.info.typeannotation.targetinfo;

import cn.hutool.core.util.ByteUtil;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

/**
 * localvar_target {
 *  u2 table_ength;
 *  {
 *      u2 start_pc;
 *      u2 length;
 *      u2 index;
 *  }table[table_length];
 * }
 */
public class LocalvarTarget extends TargetInfo{
    public short tableLength;
    public LocalvarTable[] tables;
    public LocalvarTarget(ClassReader cr){
        this.tableLength = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.tables = new LocalvarTable[tableLength];
        for (int i = 0; i < this.tables.length; i++) {
            tables[i] = new LocalvarTable(cr);
        }
    }
}
