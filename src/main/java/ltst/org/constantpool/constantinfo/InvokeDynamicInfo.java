package ltst.org.constantpool.constantinfo;

import cn.hutool.core.util.ByteUtil;
import lombok.ToString;
import ltst.org.classfile.ClassReader;
import ltst.org.constantpool.ConstantTag;
import ltst.org.constantpool.CpInfo;

import java.nio.ByteOrder;

/**
 * 用于表示 invokeDynamic 指令
 * CONSTANT_InvokeDynamic_info {
 *     u1 tag;
 *     u2 bootstrap_method_attr_index;
 *     u2 name_and_type_index;
 * }
 */
@ToString
public class InvokeDynamicInfo extends CpInfo {
    /**
     * u2 类型
     * 需对应 当前 class 文件中 引导方法表 的 bootstrap_methods 数组的有效索引
     */
    public short bootStrapMethodAttrIndex;
    /**
     * u2 类型
     * 对应常量池的有效索引 对应的成员必须是 CONSTANT_NameAndType_info
     */
    public short nameAndTypeIndex;
    public InvokeDynamicInfo(short bootStrapMethodAttrIndex,short nameAndTypeIndex){
        this.tag = ConstantTag.CONSTANT_InvokeDynamic;
        this.bootStrapMethodAttrIndex = bootStrapMethodAttrIndex;
        this.nameAndTypeIndex = nameAndTypeIndex;
    }

    public static InvokeDynamicInfo parse(ClassReader cr){
        return new InvokeDynamicInfo(
                ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN),// bootStrapMethodAttrIndex
                ByteUtil.bytesToShort(cr.readU2(),ByteOrder.BIG_ENDIAN)//nameAndTypeIndex
        );
    }
}
