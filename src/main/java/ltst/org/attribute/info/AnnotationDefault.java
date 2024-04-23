package ltst.org.attribute.info;

import cn.hutool.core.util.ByteUtil;
import ltst.org.attribute.info.element.ElementValue;
import ltst.org.attribute.info.element.ElementValueFactory;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

/**
 * AnnotationDefault 属性是个变长属性，它出现在某些method_info结构体的属性表里，而那种method_info结构题，则用来表示注解类型中的元素。
 * AnnotationDefault 记录了由method_info结构所表示的那个元素的默认值
 * AnnotationDefault_attribute {
 *     u2 attribute_name_Index;
 *     u4 attribute_length;
 *     element_value default_value;
 * }
 */
public class AnnotationDefault {
    public short attributeNameIndex;
    public int attributeLength;
    public ElementValue defaultValue;
    public AnnotationDefault(ClassReader cr){
        this.attributeNameIndex = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.attributeLength = ByteUtil.bytesToInt(cr.readU4(),ByteOrder.BIG_ENDIAN);
        this.defaultValue = ElementValueFactory.getElement(cr);
    }
}
