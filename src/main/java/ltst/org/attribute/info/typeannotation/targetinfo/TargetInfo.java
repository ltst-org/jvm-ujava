package ltst.org.attribute.info.typeannotation.targetinfo;

/*
 * target_type 的值
 * 0x00 泛型类或接口的类型参数声明            type_parameter_target
 * 0x01 泛型方法或构造器的类型参数声明         type_parameter_target
 * 0x10 类或接口声明中的extends子句的类型     supertype_target
 * 0x11 声明泛型类或接口的类型参数界限         type_parameter_bound_target
 * 0x12 声明泛型方法或构造器的类型参数界限      type_parameter_bound_target
 * 0x13 字段声明中的类型                     empty_target
 * 0x14 方法的返回值类型                     empty_target
 * 0x15 方法或构造器的接收者(receiver)类型    empty_target
 * 0x16 方法、构造器或lambda表达式形参中的类型 formal_parameter_target
 * 0x17 方法或构造器 throws子句中的类型       throw_target
 *
 * 0x40 局部变量声明中的类型                                          localvar_taret
 * 0x41 资源变量声明中的类型                                          localvar_target
 * 0x42 异常参数声明中的类型                                          catch_target
 * 0x43 instanceof表达式中的类型                                     offset_target
 * 0x44 new 表达式中的类型                                           offset_target
 * 0x45 以 ::new 的形式来表述的方法引用表达式的类型                      offset_target
 * 0x46 以 ::Identifier 的形式来表述方法引用表达式中的类型               offset_target
 * 0x47 类型转换表达式中的类型                                        type_argument_target
 * 0x48 new 表达式中的泛型构造器或显示构造器调用语句中的类型参数            type_argument_target
 * 0x49 方法带哦用表达式中的泛型方法的类型参数                           type_argument_target
 * 0x4A 以::new的形式来表述的方法引用表达式中，泛型构造器的参数类型         type_argument_target
 * 0x4B 以::Identifier 的形式来表述的方法引用表达式中，泛型方法的参数类型   type_argument_target
 */
public class TargetInfo {

}
