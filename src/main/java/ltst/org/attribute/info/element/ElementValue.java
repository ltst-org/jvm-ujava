package ltst.org.attribute.info.element;

/**
 * 联合体结构根据tag来判断具体的结构
 * element_value{
 *     u1 tag;
 *     union {
 *         u2 const_value_index;
 *
 *         {
 *             u2 type_name_index;
 *             u2 const_name_index;
 *         } enum_const_value;
 *
 *         u2 class_info_index;
 *
 *         annotation annotation_value;
 *
 *         {
 *             u2 num_values;
 *             element_value values[num_values];
 *         } array_value;
 *     } value;
 *
 *     tag 以及 对应的联合体项
 *
 *     B byte - const_value_index;
 *     C char - const_value_index;
 *     D double - const_value_index
 *     F float - const_value_index
 *     I int - const_value_index
 *     J long - const_value_index
 *     S short - const_value_index
 *     Z boolean - const_value_index
 *     s String - const_value_index
 *     e 枚举类型 - enum_const_value
 *     c Class - class_info_index
 *     @ 注解类型 - annotation_value
 *     [ 数组类型 - array_value
 * }
 */
public class ElementValue {
    public byte tag;
}
