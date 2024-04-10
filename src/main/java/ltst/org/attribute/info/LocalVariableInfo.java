package ltst.org.attribute.info;

import cn.hutool.core.util.ByteUtil;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

public class LocalVariableInfo {
    public short startPc;
    public short length;
    public short nameIndex;
    public short descriptorIndex;
    public short index;
    public LocalVariableInfo(ClassReader cr){
        this.startPc = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.length = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.nameIndex = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.descriptorIndex = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.index = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
    }
}
