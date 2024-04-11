package ltst.org.attribute.info.element;

import ltst.org.classfile.ClassReader;

/**
 * 根据tag 类型创建 ElementValue对象
 */
public class ElementValueFactory {
    public static ElementValue getElement(ClassReader cr){
        byte tag = cr.readU1();
        switch (tag){
            case 'B':
            case 'C':
            case 'D':
            case 'F':
            case 'I':
            case 'J':
            case 'S':
            case 'Z':
            case 's': return new ElementValueConstValueIndex(cr);
            case 'e': return new ElementValueEnumConstValue(cr);
            case 'c': return new ElementValueClassInfoIndex(cr);
            case '@': return new ElementValueAnnotation(cr);
            case '[': return new ElementValueArrayValue(cr);
        }
        return null;
    }
}
