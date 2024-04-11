package ltst.org.attribute.info.element;

import ltst.org.attribute.info.Annotation;
import ltst.org.classfile.ClassReader;

public class ElementValueAnnotation extends ElementValue{
    public Annotation annotation;
    public ElementValueAnnotation(ClassReader cr){
        this.annotation = new Annotation(cr);
    }
}
