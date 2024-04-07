package ltst.org.attribute.info;

import cn.hutool.core.util.ByteUtil;
import ltst.org.attribute.AttributeInfo;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

/**
 * InnerClasses 属性是变长属性，位于ClassFile结构的属性表中
 * InnerClasses_attribute{
 *     u2 attribute_name_index; // 对应常量池有效索引，CONSTANT_Utf8_info 类型，表示字符串 “InnerClasses”
 *     u4 attribute_length; // 给出了当前属性的长度，不包括初始的 6个字节
 *     u2 number_of_classes; // 表示 classes[] 数组的成员数量
 *     {
 *         u2 inner_class_info_index; //常量池索引，CONSTANT_Class_info结构
 *         u2 outer_class_info_index; //常量池索引，CONSTANT_Class_info结构
 *         u2 inner_name_index;
 *         u2 inner_class_access_flags;
 *     } classes[number_of_classes];
 * }
 */
public class InnerClasses extends AttributeInfo {
    public short numberOfClasses;
    public ClassesInfo[] classes;

    public InnerClasses(ClassReader cr) {
        super(cr);
        this.numberOfClasses = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.classes = new ClassesInfo[this.numberOfClasses];
        for (int i = 0; i < this.classes.length; i++) {
            classes[i] = new ClassesInfo(cr);
        }
    }
}
