package ltst.org.constantpool.constantinfo;

import cn.hutool.core.util.ByteUtil;
import lombok.ToString;
import ltst.org.classfile.ClassReader;
import ltst.org.constantpool.ConstantTag;
import ltst.org.constantpool.CpInfo;

import java.nio.ByteOrder;

/**
 * CONSTANT_String
 * tag = CONSTANT_String(10)
 * 表示 String 类型的常量对象
 * CONSTANT_String_info {
 *     u1 tag;
 *     u2 string_index;
 * }
 */
@ToString
public class StringInfo extends CpInfo {
    public short stringIndex;
    public StringInfo(short stringIndex){
        this.tag = ConstantTag.CONSTANT_String;
        /**
         * 常量池有效索引 必须对应 CONSTANT_Utf8
         */
        this.stringIndex = stringIndex;
    }
    public static StringInfo parse(ClassReader cr){
        return new StringInfo(
                ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN)//stringIndex
        );
    }
}
