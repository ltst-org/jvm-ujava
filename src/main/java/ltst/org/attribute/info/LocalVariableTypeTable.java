package ltst.org.attribute.info;

import cn.hutool.core.util.ByteUtil;
import ltst.org.attribute.AttributeInfo;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

/**
 * LocalVariableTypeTable 是可选的变长属性，位于Code的属性表中。调试器在执行方法的过程中，可以用它来确定某个局部变量的值。
 * LocalVariableTypeTable_attribute{
 *     u2 attribute_name_Index;
 *     u4 attribute_length;
 *     u2 local_variable_type_table_length;
 *     {
 *         u2 start_pc;
 *         u2 length;
 *         u2 name_index;
 *         u2 signature_index;
 *         u2 index;
 *     } local_variable_type_table[local_variable_type_table_length];
 *
 *     与 LocalVariableTable 不同，这里主要描述签名
 * }
 */
public class LocalVariableTypeTable extends AttributeInfo {
    public short localVariableTypeTableLength;
    public LocalVariableTypeInfo[] localVariableTypeInfos;

    public LocalVariableTypeTable(ClassReader cr) {
        super(cr);
        this.localVariableTypeTableLength = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.localVariableTypeInfos = new LocalVariableTypeInfo[localVariableTypeTableLength];
        for (int i = 0; i < this.localVariableTypeInfos.length; i++) {
            this.localVariableTypeInfos[i] = new LocalVariableTypeInfo(cr);;
        }
    }
}
