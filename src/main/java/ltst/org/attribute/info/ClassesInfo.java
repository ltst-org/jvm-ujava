package ltst.org.attribute.info;

import cn.hutool.core.util.ByteUtil;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

public class ClassesInfo {
    public short innerClassInfoIndex;
    public short outerClassInfoIndex;
    public short innerNameIndex;
    public short innerClassAccessFlags;
    public ClassesInfo(ClassReader cr){
        this.innerClassInfoIndex = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.outerClassInfoIndex = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.innerNameIndex = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.innerClassAccessFlags = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
    }
}
