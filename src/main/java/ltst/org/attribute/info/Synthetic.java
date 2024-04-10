package ltst.org.attribute.info;

import ltst.org.attribute.AttributeInfo;
import ltst.org.classfile.ClassReader;

/**
 * Synthetic属性是定长属性，位于ClassFile、field_info、method_info 的属性表中
 */
public class Synthetic extends AttributeInfo {
    public Synthetic(ClassReader cr) {
        super(cr);
    }
}
