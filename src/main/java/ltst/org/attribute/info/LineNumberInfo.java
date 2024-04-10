package ltst.org.attribute.info;

import cn.hutool.core.util.ByteUtil;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

public class LineNumberInfo {
    public short startPc;
    public short lineNumber;
    public LineNumberInfo(ClassReader cr){
        this.startPc = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.lineNumber = ByteUtil.bytesToShort(cr.readU2(),ByteOrder.BIG_ENDIAN);
    }
}
