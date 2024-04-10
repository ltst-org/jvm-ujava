package ltst.org.attribute.info;

import cn.hutool.core.util.ByteUtil;
import ltst.org.attribute.AttributeInfo;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

/**
 * LineNumberTable 属性是可选的定长属性 位于Code的属性表中
 * LineNumberTable_attribute{
 *     u2 attribute_name_index;
 *     u4 attribute_length;
 *     u2 line_number_table_length;
 *     {
 *         u2 start_pc;
 *         u2 line_number;
 *     }line_number_table[line_number_table_length];
 * }
 */
public class LineNumberTable extends AttributeInfo {
    public short lineNumberTableLength;
    public LineNumberInfo[] lineNumbers;

    public LineNumberTable(ClassReader cr) {
        super(cr);
        this.lineNumberTableLength = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.lineNumbers = new LineNumberInfo[lineNumberTableLength];
        for (int i = 0; i < this.lineNumbers.length; i++) {
            this.lineNumbers[i] = new LineNumberInfo(cr);
        }
    }
}
