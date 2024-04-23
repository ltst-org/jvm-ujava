package ltst.org.attribute.info;

import cn.hutool.core.util.ByteUtil;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

public class ParameterAnnotation {
    public short numAnnotations;
    public Annotation[] annotations;
    public ParameterAnnotation(ClassReader cr){
        this.numAnnotations = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.annotations = new Annotation[this.numAnnotations];
        for (int i = 0; i < this.annotations.length; i++) {
            this.annotations[i] = new Annotation(cr);
        }
    }
}
