package ltst.org.attribute.info.stackmapframe;

import cn.hutool.core.util.ByteUtil;
import ltst.org.attribute.info.verification.VerificationFactory;
import ltst.org.attribute.info.verification.VerificationInfo;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

/**
 * full_frame{
 *     u1 frame_type = FULL_FRAME;
 *     u2 offset_delta;
 *     u2 number_of_locals;
 *     verification_type_info locals[number_of_locals];
 *     u2 number_of_stack_items;
 *     verification_type_info stack[number_of_stack_items];
 * }
 */
public class FullFrame extends StackMapFrame{
    public static final byte tagType = FrameTag.FULL_FRAME;
    public short offsetDelta;
    public short numberOfLocals;
    public VerificationInfo[] locals;
    public short numberOfStackItems;
    public VerificationInfo[] stack;
    public FullFrame(ClassReader cr,byte frameType){
        this.tag = frameType;
        this.offsetDelta = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.numberOfLocals = ByteUtil.bytesToShort(cr.readU2(),ByteOrder.BIG_ENDIAN);
        this.locals = new VerificationInfo[this.numberOfLocals];
        for (int i = 0; i < this.locals.length; i++) {
            locals[i] = new VerificationFactory(cr).getInfo();
        }
        this.numberOfStackItems = ByteUtil.bytesToShort(cr.readU2(),ByteOrder.BIG_ENDIAN);
        this.stack = new VerificationInfo[this.numberOfStackItems];
        for (int i = 0; i < this.stack.length; i++) {
            stack[i] = new VerificationFactory(cr).getInfo();
        }
    }
}
