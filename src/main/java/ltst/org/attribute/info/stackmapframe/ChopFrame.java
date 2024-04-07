package ltst.org.attribute.info.stackmapframe;

import cn.hutool.core.util.ByteUtil;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

/**
 *  CHOP: 表示操作数栈顶部的部分项被移除，局部变量表状态不变。
 *  chop_frame{
 *      u1 frame_type = CHOP;
 *      u2 offset_delta;
 *  }
 *  操作数栈为空，并且拥有和前一个栈帧映射相同的 locals[] 表 但是该表缺少最后的k个locals项，k值由 251-frame_type 确定。这种类型的栈帧 会给出明确的 offset_delta 值
 */
public class ChopFrame extends StackMapFrame{
    public static final byte tagType = FrameTag.CHOP_FRAME;
    public short offsetDelta;
    public ChopFrame(ClassReader cr,byte frameType){
        this.tag = frameType;
        this.offsetDelta = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
    }
}
