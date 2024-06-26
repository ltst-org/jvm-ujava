package ltst.org.classfile;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ByteUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import lombok.Getter;
import lombok.ToString;
import ltst.org.attribute.AttributeInfo;
import ltst.org.constantpool.ConstantTag;
import ltst.org.constantpool.CpInfo;
import ltst.org.constantpool.constantinfo.*;
import ltst.org.field.FieldInfo;
import ltst.org.method.MethodInfo;

import java.io.File;
import java.io.IOException;
import java.nio.ByteOrder;
import java.nio.file.Files;


/**
 * class 文件解析抽象
 */
@Getter
@ToString
public class ClassFile {
    private static final Log log = LogFactory.get(ClassFile.class);
    /**
     * class 文件路径
     */
    private final String classFilePath;
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
    private CpInfo[] constantPool;
    /**
     * 访问标志
     */
    private short accessFlags;
    /**
     * 当前类索引
     */
    private short thisClass;
    /**
     * 父类索引
     */
    private short superClass;
    /**
     * 接口计数器
     */
    private short interfacesCount;
    /**
     * 接口表
     */
    private short[] interfaces;
    /**
     * 字段计数器
     */
    private short fieldsCount;
    /**
     * 字段表
     */
    private FieldInfo[] fields;
    /**
     * 方法计数器
     */
    private short methodCount;
    /**
     * 方法表
     */
    private MethodInfo[] method;
    /**
     * 属性计数器
     */
    private short attributesCount;
    /**
     * 属性表
     */
    private AttributeInfo[] attributes;

    public static String byte2Hex(byte[] bytes){
        StringBuilder bf = new StringBuilder();
        for (byte aByte : bytes) {
            bf.append(String.format("%02X",aByte));
        }
        return bf.toString();
    }
    public ClassFile(String classFilePath){
        this.classFilePath = classFilePath;
    }

    public void parseClass() throws IOException {
        // 解析前的检查
        if(!FileUtil.exist(this.classFilePath)){
            log.error("被解析的class文件不存在");
            return;
        }
        //开始解析
        ClassReader cr = new ClassReader(Files.newInputStream(new File(this.classFilePath).toPath()));
        this.magic = byte2Hex(cr.readU4());
        log.debug("ClassFile parse magic:{}",this.magic);
        this.minorVersion = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        log.debug("ClassFile parse minor:{}",this.minorVersion);
        this.majorVersion = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        log.debug("ClassFile parse major:{}",this.majorVersion);
        this.constantPoolCount = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        log.debug("ClassFile parse constantPoolCount:{}",this.constantPoolCount);

        parseConstantPool(cr);

        for (int i = 1; i < this.constantPool.length; i++) {
            log.debug("ClassFile parse constantPool i:{},cpInfo:{},str:{}",i,this.constantPool[i],this.constantPool[i].tag != ConstantTag.CONSTANT_Utf8 ? "":new String(((Utf8Info)this.constantPool[i]).bytes));
        }

        this.accessFlags = ByteUtil.bytesToShort(cr.readU2(),ByteOrder.BIG_ENDIAN);
        log.debug("ClassFile parse accessFlags:{}",this.accessFlags);
        this.thisClass =ByteUtil.bytesToShort(cr.readU2(),ByteOrder.BIG_ENDIAN);
        log.debug("ClassFile parse thisClass:{}",this.thisClass);
        this.superClass =ByteUtil.bytesToShort(cr.readU2(),ByteOrder.BIG_ENDIAN);
        log.debug("ClassFile parse superClass:{}",this.superClass);
        this.interfacesCount =ByteUtil.bytesToShort(cr.readU2(),ByteOrder.BIG_ENDIAN);
        log.debug("ClassFile parse interfacesCount:{}",this.interfacesCount);

        parseInterfaces(cr);
        for (int i = 0; i < this.interfaces.length; i++) {
            log.debug("ClassFile parse interfaces i:{},interface:{}",i,this.interfaces[i]);
        }

        this.fieldsCount = ByteUtil.bytesToShort(cr.readU2(),ByteOrder.BIG_ENDIAN);
        log.debug("ClassFile parse fieldsCount:{}",this.fieldsCount);
        parseFields(cr);
        for (int i = 0; i < this.fields.length; i++) {
            log.debug("ClassFile parse fields i:{},fieldInfo:{}",i,this.fields[i]);
        }

        this.methodCount = ByteUtil.bytesToShort(cr.readU2(),ByteOrder.BIG_ENDIAN);
        log.debug("ClassFile parse methodCount:{}",this.methodCount);
        parseMethods(cr);
        for (int i = 0; i < this.method.length; i++) {
            log.debug("ClassFile parse method i:{},methodInfo:{}",i,this.method[i]);
        }

        this.attributesCount = ByteUtil.bytesToShort(cr.readU2(),ByteOrder.BIG_ENDIAN);
        log.debug("ClassFile parse attributesCount:{}",this.attributesCount);
        parseAttributes(cr);
        for (int i = 0; i < this.attributes.length; i++) {
            log.debug("ClassFile parse attribute i:{},attributeInfo:{}",i,this.attributes[i]);
        }

        //解析后 关闭 数据流
        cr.close();
    }

    private void parseAttributes(ClassReader cr) {
        AttributeInfo[] attributeInfos = new AttributeInfo[this.attributesCount];
        for (int i = 0; i < attributeInfos.length; i++) {
            attributeInfos[i] = new AttributeInfo(cr);
        }
        this.attributes = attributeInfos;
    }

    private void parseMethods(ClassReader cr) {
        MethodInfo[] methodInfos = new MethodInfo[this.methodCount];
        for (int i = 0; i < methodInfos.length; i++) {
            methodInfos[i] = new MethodInfo(cr);
        }
        this.method = methodInfos;
    }

    private void parseFields(ClassReader cr) {
        FieldInfo[] fieldInfos = new FieldInfo[this.fieldsCount];
        for (int i = 0; i < fieldInfos.length; i++) {
            fieldInfos[i] = new FieldInfo(cr);
        }
        this.fields = fieldInfos;
    }

    private void parseInterfaces(ClassReader cr) {
        short[] interfaces = new short[this.interfacesCount];
        for (int i = 0; i < interfaces.length; i++) {
            this.interfaces[i] = ByteUtil.bytesToShort(cr.readU2(),ByteOrder.BIG_ENDIAN);
        }
        this.interfaces = interfaces;
    }

    /**
     * 解析常量池
     * @param cr class 读取工具
     */
    private void parseConstantPool(ClassReader cr){
        CpInfo[] constantPool = new CpInfo[this.constantPoolCount];
        // 常量池 0 号位置 空出来的原因是 表示 没有索引，
        // 部分场景中 InnerClasses_attribute 中的 classes inner_name_index , Code_attribute 中的 exception_table 中的 catch_type 以上这些值部分场景中 可能为 0
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
        this.constantPool = constantPool;
    }


}
