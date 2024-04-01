package ltst.org.constantpool.constantinfo;

import cn.hutool.core.util.ByteUtil;
import lombok.ToString;
import ltst.org.classfile.ClassReader;
import ltst.org.constantpool.ConstantTag;
import ltst.org.constantpool.CpInfo;

import java.nio.ByteOrder;

/**
 * 用于表示方法句柄
 * CONSTANT_MethodHandle_info{
 *     u1 tag;
 *     u2 reference_kind;
 *     u2 reference_index;
 * }
 */
@ToString
public class MethodHandleInfo extends CpInfo {
    /**
     * u1 类型
     * 表示方法句柄的类型
     * 1-9之间(包括1 和 9)
     * 1 - REF_getField
     * 2 - REF_getStatic
     * 3 - REF_putField
     * 4 - REF_putStatic
     * 5 - REF_invokeVirtual
     * 6 - REF_invokeStatic
     * 7 - REF_invokeSpecial
     * 8 - REF_newInvokeSpecial
     * 9 - REF_invokeInterface
     */
    public byte referenceKind;
    /**
     * u2 类型
     * 常量池有效索引
     * 1-4 对应的常量池成员为 CONSTANT_Fieldref_info
     * 5、8 对应的常量池成员为 CONSTANT_Methodref_info
     * 6、7 版本号小于 52 对应的常量池成员为 CONSTANT_Methodref_info 如果版本号 大于52 那么对应的常量池成员为 CONSTANT_Methodref_ifo 或者 CONSTANT_InterfaceMethodref_info
     * 9 对应的常量池成员为 CONSTANT_InterfaceMethodref_info
     * 注意：
     * 1. 如果 referenceKind = 8 那么 CONSTANT_Methodref_info 表示的方法 其名称必须是 <init>
     * 2. 如果 referenceKind = 5、6、7、9 其方法名称不应该是 <init> <clinit>
     */
    public short referenceIndex;
    public MethodHandleInfo(byte referenceKind,short referenceIndex){
        this.tag = ConstantTag.CONSTANT_MethodHandle;
        this.referenceKind = referenceKind;
        this.referenceIndex = referenceIndex;
    }
    public static MethodHandleInfo parse(ClassReader cr){
        return new MethodHandleInfo(
                cr.readU1(), //referenceKind
                ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN) //referenceIndex
        );
    }
}
