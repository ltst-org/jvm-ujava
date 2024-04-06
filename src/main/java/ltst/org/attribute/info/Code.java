package ltst.org.attribute.info;

import cn.hutool.core.util.ByteUtil;
import lombok.Getter;
import ltst.org.attribute.AttributeInfo;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

/**
 * Code 属性 是变长属性，位于 method_info 结构的属性表中。
 * Code 属性中包含 某个方法、实例初始化方法、类或者接口初始化方法
 * Code_attribute{
 *     u2 attribute_name_Index;
 *     u2 attribute_length;
 *     u2 max_stack; //操作数栈最大深度
 *     u2 max_locals; // 局部变量表中的 局部变量数据 ， long 和 double 索引占用两个 槽位
 *     u4 code_length; // code 数组的字节数
 *     u1 code[code_length]; // code 实际字节吗内容
 *     u2 exception_table_length; // exception_table 表中成员个数
 *     exception_table[exception_table_length]{
 *         u2 start_pc; //
 *         u2 end_pc; // start_pc end_pc 共同表明 异常处理器中的有效范围
 *         u2 handler_pc; // 表示一个异常处理器的起点
 *         u2 catch_type;
 *     } // 数组的每个成员是 code[] 数组中的一个一场处理器，异常处理器的顺序是有意义的。
 *     u2 attributes_count;
 *     attribute_info attributes[attributes_count];
 * }
 */
@Getter
public class Code extends AttributeInfo{
    public short maxStack;
    public short maxLocals;
    public int codeLength;
    public byte[] code;
    public short exceptionTableLength;
    public ExceptionInfo[] exceptionTable;
    public short attributesCount;
    public AttributeInfo[] attributes;
    static class ExceptionInfo{
        public short startPc;
        public short endPc;
        public short handlerPc;
        public short catchType;
    }
    public Code(ClassReader cr){
        super(cr);
        this.maxStack = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.maxLocals = ByteUtil.bytesToShort(cr.readU2(),ByteOrder.BIG_ENDIAN);
        this.codeLength = ByteUtil.bytesToInt(cr.readU4(),ByteOrder.BIG_ENDIAN);
        this.code = cr.readN(this.codeLength);
        this.exceptionTableLength = ByteUtil.bytesToShort(cr.readU2(),ByteOrder.BIG_ENDIAN);
        this.exceptionTable = new ExceptionInfo[this.exceptionTableLength];
        for (int i = 0; i < exceptionTable.length; i++) {
            exceptionTable[i] = new ExceptionInfo();
            exceptionTable[i].startPc = ByteUtil.bytesToShort(cr.readU2(),ByteOrder.BIG_ENDIAN);
            exceptionTable[i].endPc = ByteUtil.bytesToShort(cr.readU2(),ByteOrder.BIG_ENDIAN);
            exceptionTable[i].handlerPc = ByteUtil.bytesToShort(cr.readU2(),ByteOrder.BIG_ENDIAN);
            exceptionTable[i].catchType = ByteUtil.bytesToShort(cr.readU2(),ByteOrder.BIG_ENDIAN);
        }
        this.attributesCount = ByteUtil.bytesToShort(cr.readU2(),ByteOrder.BIG_ENDIAN);
        this.attributes = new AttributeInfo[this.attributesCount];
        for (int i = 0; i < attributes.length; i++) {
            attributes[i] = new AttributeInfo(cr);
        }
    }
}
