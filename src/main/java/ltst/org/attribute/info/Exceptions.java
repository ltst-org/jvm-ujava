package ltst.org.attribute.info;

import cn.hutool.core.util.ByteUtil;
import ltst.org.attribute.AttributeInfo;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

/**
 * Exceptions 属性是变长属性，位于 method_info 结构的属性表内。
 * 一个 method_info 只能有一个 Exceptions 属性
 * Exceptions_attribute{
 *     u2 attribute_name_index; //是常量池索引，指向 CONSTANT_Utf8_info ，用以表示字符串 “Exceptions”
 *     u2 attribute_length; //给出了当前属性的长度，不包括初始的 6个字节
 *     u4 number_of_exceptions;
 *     u2 exception_index_table[number_of_exceptions];
 * }
 */
public class Exceptions extends AttributeInfo {
    public short numberOfExceptions;
    public ExceptionInfo[] exceptionIndexTable;
    public Exceptions(ClassReader cr) {
        super(cr);
        this.numberOfExceptions = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.exceptionIndexTable = new ExceptionInfo[this.numberOfExceptions];
        for (int i = 0; i < this.exceptionIndexTable.length; i++) {
            exceptionIndexTable[i] = new ExceptionInfo(cr);
        }
    }
}
