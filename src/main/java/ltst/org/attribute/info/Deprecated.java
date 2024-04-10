package ltst.org.attribute.info;

import ltst.org.attribute.AttributeInfo;
import ltst.org.classfile.ClassReader;

/**
 * Deprecated属性是可选定长属性，位于ClassFile、field_info、method_info 结构的属性表中
 * 如果 类、属性、或者方法被标记为 Deprecated，那么就说明它将来会被取代
 * Deprecated_attribute{
 *     u2 attribute_name_index;
 *     u4 attribute_length;
 * }
 */
public class Deprecated extends AttributeInfo {

    public Deprecated(ClassReader cr) {
        super(cr);
    }
}
