package ltst.org.attribute.info;

import cn.hutool.core.util.ByteUtil;
import ltst.org.attribute.info.element.ElementValue;
import ltst.org.attribute.info.element.ElementValueFactory;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

/**
 * 位于 Annotation 属性中
 */
public class ElementValuePairsInfo {
    public short elementNameIndex;
    public ElementValue elementValue;
    public ElementValuePairsInfo(ClassReader cr){
        this.elementNameIndex = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.elementValue = ElementValueFactory.getElement(cr);
    }
}
