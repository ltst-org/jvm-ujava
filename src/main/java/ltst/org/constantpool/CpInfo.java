package ltst.org.constantpool;

import lombok.Getter;
import lombok.ToString;

/**
 * 常量池中的常量类型
 */
@Getter
@ToString
public class CpInfo {
    /**
     * u1 类型
     * 常量类型
     * 1  CONSTANT_Utf8
     * 3  CONSTANT_Integer
     * 4  CONSTANT_Float
     * 5  CONSTANT_Long
     * 6  CONSTANT_Double
     * 7  CONSTANT_Class
     * 8  CONSTANT_String
     * 9  CONSTANT_Fieldref
     * 10 CONSTANT_Methodref
     * 11 CONSTANT_InterfaceMethodref
     * 12 CONSTANT_NameAndType
     * 15 CONSTANT_MethodHandle
     * 16 CONSTANT_MethodType
     * 18 CONSTANT_InvokeDynamic
     */
    public byte tag;
}
