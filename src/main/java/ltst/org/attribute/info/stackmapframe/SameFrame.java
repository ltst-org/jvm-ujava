package ltst.org.attribute.info.stackmapframe;

import cn.hutool.core.util.ByteUtil;
import ltst.org.classfile.ClassReader;

/**
 * same_frame {
 *     u1 frame_type = SAME;
 * }
 * SAME: 表示从上一个合法帧到当前帧，局部变量表和操作数栈的状态没有变化。
 * 表示当前帧拥有和前一个栈帧映射完全相同的 locals[]表，并且对应的 stack[] 表的成员个数为0，当前帧的 offset_delta 就使用 frame_type 项的值来表示
 */
public class SameFrame extends StackMapFrame{
    public static final byte tagType = FrameTag.SAME_FRAME;
    public SameFrame(ClassReader cr){
        this.tag = cr.readU1();
    }
}
