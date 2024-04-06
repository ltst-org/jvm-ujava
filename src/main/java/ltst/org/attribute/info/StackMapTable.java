package ltst.org.attribute.info;

import ltst.org.attribute.AttributeInfo;
import ltst.org.classfile.ClassReader;

/**
 * 变长属性
 * 位于 code 属性的属性表中
 * 在版本号 大于 或者 等于 50.0的class文件中，如果方法的Code属性中没有附带StackMapTable属性，
 * 那就意味着 它带有一个 隐式的栈映射属性  作用等同于 number_of_entries 值为 0 的 StackMapTable
 * StackMapTable_attribute {
 *     u2 attribute_name_index;
 *     u4 attribute_length;
 *     u2 number_of_entries;
 *     stack_map_frame entries[number_of_entries];
 * }
 * stack_map_frame 栈帧映射
 * 显示 或 隐式的指定了某个字节码偏移量，用来表示该帧所针对的字节码位置，
 * 并且指定了次偏移量处的局部变量和操作数栈项(operand stack entry) 所需的核查类型(verification type);
 * entries 表中 的每个栈帧映射，其中某些语义要依赖于它的前一个栈帧映射。
 * 所以 方法的首个栈帧是隐式的，
 * 类型检查器 会根据方法描述符 来算出首个 栈帧。
 * 因此 stack_map_frame 结构体中的 entries[0] 描述的是第二个栈帧映射
 */
public class StackMapTable extends AttributeInfo {
    public short numberOfEntries;
    public Object[] entries[];
    public StackMapTable(ClassReader cr) {
        super(cr);
    }
}
