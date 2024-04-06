package ltst.org.field;

import lombok.Builder;
import lombok.Getter;
import ltst.org.attribute.AttributeInfo;

/**
 * 每个字段 （field） 都由 field_info 结构所定义
 * field_info{
 *     u2 access_flags;
 *     u2 name_index; 对应常量池的一个索引 对应的成员必须是 CONSTANT_Utf8_info结构
 *     u2 descriptor_index; 对应常量池的一个索引 对应的成员必须是 CONSTANT_Utf8_info结构
 *     u2 attributes_count; 表示当前字段的附加属性的数量
 *     attribute_info attributes[attributes_count]; 属性表每个成员的属性
 * }
 *
 * access_flags 表示字段的访问全县和基本属性
 *  ACC_PUBLIC      0x0001 声明 public 可以从包外访问
 *  ACC_PRIVATE     0x0002 声明为 private
 *  ACC_PROTECTED   0x0004 声明为 protected 子类可以访问
 *  ACC_STATIC      0x0008 声明为 static
 *  ACC_FINAL       0x0010 声明为 final
 *  ACC_VOLATILE    0x0040 声明为 volatile
 *  ACC_TRANSIENT   0x0080 声明为 transient 被标识的字段不会为持久化对象管理器所写入或者读取
 *  ACC_SYNTHETIC   0x1000 被表示的字段由编译器产生，没有写在源码中
 *  ACC_ENUM        0x4000 该字段为 某个枚举类型的成员
 */
@Getter
@Builder
public class fieldInfo {
    public short accessFlags;
    public short nameIndex;
    public short descriptorIndex;
    public short attributesCount;
    public AttributeInfo[] attributes[];
}
