package ltst.org.attribute.info;

import cn.hutool.core.util.ByteUtil;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

public class ExceptionInfo {
    public short startPc;
    public short endPc;
    public short handlerPc;
    public short catchType;
    public ExceptionInfo(ClassReader cr){
        this.startPc = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.endPc = ByteUtil.bytesToShort(cr.readU2(),ByteOrder.BIG_ENDIAN);
        this.handlerPc = ByteUtil.bytesToShort(cr.readU2(),ByteOrder.BIG_ENDIAN);
        this.catchType = ByteUtil.bytesToShort(cr.readU2(),ByteOrder.BIG_ENDIAN);
    }
}
