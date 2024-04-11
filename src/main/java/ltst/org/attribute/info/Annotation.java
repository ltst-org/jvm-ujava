package ltst.org.attribute.info;

import cn.hutool.core.util.ByteUtil;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

/**
 * 该成员位于 RuntimeVisibleAnnotations 属性中
 */
public class Annotation {
    public short type_index;
    public short numElementValuePairs;
    public ElementValuePairsInfo[] elementValuePairs;
    public Annotation(ClassReader cr){
        this.type_index = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.numElementValuePairs = ByteUtil.bytesToShort(cr.readU2(),ByteOrder.BIG_ENDIAN);
        this.elementValuePairs = new ElementValuePairsInfo[numElementValuePairs];
        for (int i = 0; i < this.elementValuePairs.length; i++) {
            this.elementValuePairs[i] = new ElementValuePairsInfo(cr);
        }
    }
}
