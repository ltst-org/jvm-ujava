package ltst.org.attribute;

import cn.hutool.core.util.ByteUtil;
import lombok.Getter;
import lombok.ToString;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

/**
 * 属性 （class） 在class文件格式中的ClassFIle结构、field info结构、method_info结构和 code_attribute结构都又使用
 */
@Getter
@ToString
public class AttributeInfo {
    public short attributeNameIndex;
    public int attributeLength;

    public AttributeInfo(ClassReader cr){
        this.attributeNameIndex = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.attributeLength = ByteUtil.bytesToInt(cr.readU4(),ByteOrder.BIG_ENDIAN);
    }
}
