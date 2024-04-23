package ltst.org.attribute.info;

import cn.hutool.core.util.ByteUtil;
import ltst.org.attribute.info.parameters.Parameters;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

/**
 * MethodParameters 属性是 method_info 结构属性表中的变长属性，该属性记录了与形式参数有关的信息，例如参数名等
 * MethodParameters_attribute{
 *     u2 attribute_name_index;
 *     u4 attribute_length;
 *     u1 parameters_count;
 *     {
 *         u2 name_index;
 *         u2 access_flags;
 *     }parameters[parameters_count];
 * }
 */
public class MethodParameters {
    public short attributeNameIndex;
    public int attributeLength;
    public byte parametersCount;
    public Parameters[] parameters;
    public MethodParameters(ClassReader cr){
        this.attributeNameIndex = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.attributeLength = ByteUtil.bytesToInt(cr.readU4(),ByteOrder.BIG_ENDIAN);
        this.parametersCount = cr.readU1();
        this.parameters = new Parameters[parametersCount];
        for (int i = 0; i < this.parameters.length; i++) {
            this.parameters[i] = new Parameters(cr);
        }
    }
}
