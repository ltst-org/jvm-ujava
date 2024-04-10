package ltst.org.attribute.info;

import cn.hutool.core.util.ByteUtil;
import ltst.org.attribute.AttributeInfo;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

/**
 * SourceFile 属性是可选的定长属性，位于CLassFile 结构的属性表中
 * 一个ClassFile结构的属性表中最多只能包含一个SourceFile属性
 * SourceFile{
 *     u2 attribute_name_index;
 *     u4 attribute_length;  // sourceFile的该属性必须=2
 *     u2 sourcefile_index; //表示被编译的class的源文件的名字
 * }
 */
public class SourceFile extends AttributeInfo {
    public short sourceFileIndex;
    public SourceFile(ClassReader cr) {
        super(cr);
        this.sourceFileIndex = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
    }
}
