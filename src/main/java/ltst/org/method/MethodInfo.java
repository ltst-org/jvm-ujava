package ltst.org.method;

import cn.hutool.core.util.ByteUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ltst.org.attribute.AttributeInfo;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

/**
 * 每个方法 （method） 都由 method_info 结构所定义
 * method_info{
 *     u2 access_flags;
 *     u2 name_index; 对应常量池的一个索引 对应的成员必须是 CONSTANT_Utf8_info结构
 *     u2 descriptor_index; 对应常量池的一个索引 对应的成员必须是 CONSTANT_Utf8_info结构
 *     u2 attributes_count; 表示当前字段的附加属性的数量
 *     attribute_info attributes[attributes_count]; 属性表每个方法的属性
 * }
 *
 * access_flags 表示方法的访问全县和基本属性
 *  ACC_PUBLIC          0x0001 声明 public 可以从包外访问
 *  ACC_PRIVATE         0x0002 声明为 private
 *  ACC_PROTECTED       0x0004 声明为 protected 子类可以访问
 *  ACC_STATIC          0x0008 声明为 static
 *  ACC_FINAL           0x0010 声明为 final
 *  ACC_SYNCHRONIZED    0x0020 声明为 synchronized 同步锁
 *  ACC_BRIDGE          0x0040 声明为 bridge 由 编译器产生
 *  ACC_VARARGS         0x0080 表示方法带有变长参数
 *  ACC_NATIVE          0x0100 声明为 native 表示方法不是由java语言实现的
 *  ACC_ABSTRACT        0x0400 声明为 abstract 方法没有代码实现，抽象方法
 *  ACC_STRICT          0x0800 声明为 strictfp 使用FP-strict 浮点模式
 *  ACC_SYNTHETIC       0x1000 该方法由编译器合成，而不是源代码编译而来
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MethodInfo {
    public short accessFlags;
    public short nameIndex;
    public short descriptorIndex;
    public short attributesCount;
    public AttributeInfo[] attributes;
    public MethodInfo(ClassReader cr){
        this.accessFlags = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.nameIndex = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.descriptorIndex = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.attributesCount = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.attributes = new AttributeInfo[attributesCount];
        for (int i = 0; i < this.attributes.length; i++) {
            this.attributes[i] = new AttributeInfo(cr);
        }
    }
}
