package ltst.org.attribute.info.stackmapframe;

import cn.hutool.core.util.ByteUtil;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

/**
 *  CHOP: 表示操作数栈顶部的部分项被移除，局部变量表状态不变。
 *  same_frame_extended{
 *      u1 frame_type = SAME_FRAME_EXTENDED;
 *      u2 offset_delta;
 *  }
 *  拥有和前一个栈帧映射相同的 locals[] 表,同时对应的 stack[] 表的成员个数是 0 。与帧类型 same_frame 不同，需要使用 offsetDelta 指定
 */
public class SameFrameExtended extends StackMapFrame{
    public static final byte tagType = FrameTag.SAME_FRAME_EXTENDED;

    public short offsetDelta;
    public SameFrameExtended(ClassReader cr){
        this.tag = cr.readU1();
        this.offsetDelta = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
    }
}
