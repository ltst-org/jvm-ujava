package ltst.org.attribute.info.element;

import cn.hutool.core.util.ByteUtil;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

public class ElementValueClassInfoIndex extends ElementValue{
    public short classInfoIndex;
    public ElementValueClassInfoIndex(ClassReader cr){
        this.classInfoIndex = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
    }
}
