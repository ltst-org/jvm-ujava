package ltst.org.attribute.info.stackmapframe;

import ltst.org.attribute.info.verification.VerificationFactory;
import ltst.org.attribute.info.verification.VerificationInfo;
import ltst.org.classfile.ClassReader;

/**
 * same_locals_1_stack_item_frame{
 *     u1 frame_type = SAME_LOCALS_1_STACK_ITEM;
 *     verification_type_info stack[1];
 * }
 * 表示当前帧拥有和前一个栈帧映射完全相同的 locals[]表，并且对应的 stack[] 表的成员个数为1，当前帧的 offset_delta 就使用 frame_type-64 的值来表示
 * 并且又一个 verification_type_info 项跟随在此帧类型之后，用于表示哪一个栈顶的成员类型。
 * SAME_LOCALS_1_STACK_ITEM: 表示局部变量表不变，但操作数栈顶部增加了一个类型项。
 */
public class SameLocals1StackItemFrame extends StackMapFrame{
    public static final byte tagType = FrameTag.SAME_LOCALS_1_STACK_ITEM_FRAME;
    public VerificationInfo stack;
    public SameLocals1StackItemFrame(ClassReader cr){
        this.tag = cr.readU1();
        this.stack = new VerificationFactory(cr).getInfo();
    }
}
