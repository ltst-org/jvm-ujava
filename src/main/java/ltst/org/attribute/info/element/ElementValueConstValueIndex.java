package ltst.org.attribute.info.element;

import cn.hutool.core.util.ByteUtil;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

public class ElementValueConstValueIndex extends ElementValue{
    public short constValueIndex;
    public ElementValueConstValueIndex(ClassReader cr){
        this.constValueIndex = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
    }
}
