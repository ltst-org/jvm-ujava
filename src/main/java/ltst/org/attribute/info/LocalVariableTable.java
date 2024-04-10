package ltst.org.attribute.info;

import cn.hutool.core.util.ByteUtil;
import ltst.org.attribute.AttributeInfo;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

/**
 * LocalVariableTable 属性是可选变长属性，位于Code属性的属性表中。
 * 调试器在执行方法的过程中可以用它来确定某个局部变量的位置
 * LocalVariableTable_attribute{
 *     u2 attribute_name_index;
 *     u4 attribute_length;
 *     u2 local_variable_table_length;
 *     {
 *         u2 start_pc;
 *         u2 length;
 *         u2 name_index;
 *         u2 descriptor_index;
 *         u2 index;
 *     } local_variable_table[local_variable_table_length];
 * }
 */
public class LocalVariableTable extends AttributeInfo {
    public short localVariableTableLength;
    public LocalVariableInfo[] localVariableInfos;
    public LocalVariableTable(ClassReader cr) {
        super(cr);
        this.localVariableTableLength = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.localVariableInfos = new LocalVariableInfo[localVariableTableLength];
        for (int i = 0; i < this.localVariableInfos.length; i++) {
            this.localVariableInfos[i] = new LocalVariableInfo(cr);
        }
    }
}
