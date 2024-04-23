package ltst.org.attribute.info;

import cn.hutool.core.util.ByteUtil;
import ltst.org.attribute.info.bootstrap.BootstrapMethodInfo;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

/**
 * BootstrapMethods 属性是变长属性，位于CLassFIle结构的属性表中，它用于保存 由invokedynamic 指令引用的引导方法限定符
 * BootstrapMethods_attribute {
 *     u2 attribute_name_index;
 *     u4 attribute_length;
 *     u2 num_bootstrap_methods;
 *     {
 *         u2 bootstrap_method_ref;
 *         u2 num_bootstrap_arguments;
 *         u2 bootstrap_arguments[num_bootstrap_arguments];
 *     } bootstrap_methods[num_bootstrap_methods];
 * }
 */
public class BootstrapMethods {
    public short attributeNameIndex;
    public int attributeLength;
    public short numBootstrapMethods;
    public BootstrapMethodInfo[] bootstrapMethods;
    public BootstrapMethods(ClassReader cr){
        this.attributeNameIndex = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.attributeLength = ByteUtil.bytesToInt(cr.readU4(),ByteOrder.BIG_ENDIAN);
        this.numBootstrapMethods = ByteUtil.bytesToShort(cr.readU2(),ByteOrder.BIG_ENDIAN);
        this.bootstrapMethods = new BootstrapMethodInfo[numBootstrapMethods];
        for (int i = 0; i < this.bootstrapMethods.length; i++) {
            this.bootstrapMethods[i] = new BootstrapMethodInfo(cr);
        }
    }

}
