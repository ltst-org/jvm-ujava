package ltst.org.attribute.info;

import ltst.org.attribute.AttributeInfo;
import ltst.org.classfile.ClassReader;

/**
 * SourceDebugExtension 属性是可选属性，位于ClassFile结构的属性表中
 * 一个CLassFile结构的属性表中，最多只能包含一个 SSourceDebugExtension 属性
 * SourceDebugExtension_attribute{
 *     u2 attribute_name_index;
 *     u4 attribute_length;
 *     u1 debug_extension[attribute_length];
 * }
 */
//TODO 这里数组有点问题
public class SourceDebugExtension extends AttributeInfo {
    public Object[] debugExtension;
    public SourceDebugExtension(ClassReader cr) {
        super(cr);
        this.debugExtension = new Object[this.attributeLength];
    }
}
