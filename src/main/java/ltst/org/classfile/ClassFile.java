package ltst.org.classfile;

import cn.hutool.core.util.ByteUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import lombok.Getter;
import lombok.ToString;
import ltst.org.constantpool.ConstantTag;
import ltst.org.constantpool.CpInfo;
import ltst.org.constantpool.constantinfo.*;

import java.nio.ByteOrder;


/**
 * class 文件解析抽象
 */
@Getter
@ToString
public class ClassFile {
    private static final Log log = LogFactory.get(ClassFile.class);
    /**
     * 魔术
     */
    private String magic;
    /**
     * 副版本号
     */
    private short minorVersion;
    /**
     * 主版本号
     */
    private short majorVersion;
    /**
     * 常量池大小
     */
    private short constantPoolCount;
    /**
     * 常量池
     */
    private Object[] constantPool;
    /**
     * 访问标志
     */
    private int accessFlags;
    /**
     * 当前类索引
     */
    private String thisClass;
    /**
     * 父类索引
     */
    private String superClass;
    /**
     * 接口计数器
     */
    private int interfacesCount;
    /**
     * 接口表
     */
    private Object[] interfaces;
    /**
     * 字段计数器
     */
    private int fieldsCount;
    /**
     * 字段表
     */
    private Object[] fields;
    /**
     * 方法计数器
     */
    private int methodCount;
    /**
     * 方法表
     */
    private Object[] method;
    /**
     * 属性计数器
     */
    private int attributesCount;
    /**
     * 属性表
     */
    private Object[] attributes;
    public static String byte2Hex(byte[] bytes){
        StringBuilder bf = new StringBuilder();
        for (byte aByte : bytes) {
            bf.append(String.format("%02X",aByte));
        }
        return bf.toString();
    }

    public void parseClass(ClassReader cr) {
        this.magic = byte2Hex(cr.readU4());
        log.debug("ClassFile parse magic:{}",this.magic);
        this.minorVersion = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        log.debug("ClassFile parse minor:{}",this.minorVersion);
        this.majorVersion = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        log.debug("ClassFile parse major:{}",this.majorVersion);
        this.constantPoolCount = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        log.debug("ClassFile parse constantPoolCount:{}",this.constantPoolCount);
        CpInfo[] constantPool = new CpInfo[this.constantPoolCount];
        // 常量池 0 号位置 为 null 可能是用于保留 ？ 未知设定含义
        for (int i = 1 ;i<this.constantPoolCount;i++){
            switch (cr.readU1()){
                case ConstantTag.CONSTANT_Utf8: constantPool[i] = Utf8Info.parse(cr);break;
                case ConstantTag.CONSTANT_Integer: constantPool[i] = IntegerInfo.parse(cr);break;
                case ConstantTag.CONSTANT_Float: constantPool[i] = FloatInfo.parse(cr);break;
                case ConstantTag.CONSTANT_Long: constantPool[i] = LongInfo.parse(cr);i++;break; // long double 需要两个槽位
                case ConstantTag.CONSTANT_Double:constantPool[i] = DoubleInfo.parse(cr);i++;break; // long double 需要两个槽位
                case ConstantTag.CONSTANT_Class:constantPool[i] = ClassInfo.parse(cr);break;
                case ConstantTag.CONSTANT_String:constantPool[i] = StringInfo.parse(cr);break;
                case ConstantTag.CONSTANT_Fieldref:constantPool[i] = FieldRefInfo.parse(cr);break;
                case ConstantTag.CONSTANT_Methodref:constantPool[i] = MethodRefInfo.parse(cr);break;
                case ConstantTag.CONSTANT_InterfaceMethodref:constantPool[i] = InterfaceMethodRef.parse(cr);break;
                case ConstantTag.CONSTANT_NameAndType:constantPool[i] = NameAndTypeInfo.parse(cr);break;
                case ConstantTag.CONSTANT_MethodHandle:constantPool[i] = MethodHandleInfo.parse(cr);break;
                case ConstantTag.CONSTANT_MethodType:constantPool[i] = MethodTypeInfo.parse(cr);break;
                case ConstantTag.CONSTANT_InvokeDynamic:constantPool[i] = InvokeDynamicInfo.parse(cr);break;
            }
        }
        for (int i = 1; i < constantPool.length; i++) {
            log.debug("ClassFile parse constantPool i:{},cpInfo:{},str:{}",i,constantPool[i],constantPool[i].tag != ConstantTag.CONSTANT_Utf8 ? "":new String(((Utf8Info)constantPool[i]).bytes));
        }
    }
}
