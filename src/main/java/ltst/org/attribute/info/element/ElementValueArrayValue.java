package ltst.org.attribute.info.element;

import cn.hutool.core.util.ByteUtil;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

public class ElementValueArrayValue extends ElementValue{
    public short numValues;
    public ElementValue[] values;
    public ElementValueArrayValue(ClassReader cr){
        this.numValues = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.values = new ElementValue[numValues];
        for (int i = 0; i < this.values.length; i++) {
            this.values[i] = ElementValueFactory.getElement(cr);
        }
    }
}
