package ltst.org.attribute.info.stackmapframe;

import cn.hutool.core.util.ByteUtil;
import ltst.org.attribute.info.verification.VerificationFactory;
import ltst.org.attribute.info.verification.VerificationInfo;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

/**
 *  APPEND: 表示在局部变量表新增了一些变量，操作数栈状态不变。
 *  append_frame{
 *      u1 frame_type = APPEND;
 *      u2 offset_delta;
 *      verification_type_info locals[frame_type-251];
 *  }
 *  操作数栈为空，拥有与前一个栈帧映射相同的 locals[]表，此外还附加了k个以定义的locals项目，k的值由 frame_type - 251 确定
 */
public class AppendFrame extends StackMapFrame{
    public static final byte tagType = FrameTag.APPEND_FRAME;
    public short offsetDelta;
    public VerificationInfo[] locals;
    public AppendFrame(ClassReader cr,byte frameType){
        this.tag = frameType;
        this.offsetDelta = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        locals = new VerificationInfo[this.tag - 251];
        for (int i = 0; i < locals.length; i++) {
            locals[i] = new VerificationFactory(cr).getInfo();
        }
    }
}
