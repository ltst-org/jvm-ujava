package ltst.org.attribute.info.stackmapframe;

/**
 * same_frame 0-63
 * same_locals_1_stack_item_frame = 64-127
 * same_locals_1_stack_item_frame_extended 247
 * chop_frame 248-250
 * same_frame_extended 251
 * append_frame 252-254
 * full_frame 255
 *
 * 一个典型的StackMapFrame条目可以是以下几种类型之一：
 * SAME: 表示从上一个合法帧到当前帧，局部变量表和操作数栈的状态没有变化。
 * SAME_LOCALS_1_STACK_ITEM: 表示局部变量表不变，但操作数栈顶部增加了一个类型项。
 * CHOP: 表示操作数栈顶部的部分项被移除，局部变量表状态不变。
 * APPEND: 表示在局部变量表新增了一些变量，操作数栈状态不变。
 * FULL_FRAME: 包含完整的局部变量表和操作数栈的状态信息。
 */
public class StackMapFrame {
    public byte tag;
}
