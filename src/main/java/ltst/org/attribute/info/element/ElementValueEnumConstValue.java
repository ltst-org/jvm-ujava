package ltst.org.attribute.info.element;

import cn.hutool.core.util.ByteUtil;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

public class ElementValueEnumConstValue extends ElementValue{
    public short typeNameIndex;
    public short constNameIndex;
    public ElementValueEnumConstValue(ClassReader cr){
        this.typeNameIndex = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.constNameIndex = ByteUtil.bytesToShort(cr.readU2(),ByteOrder.BIG_ENDIAN);
    }
}
