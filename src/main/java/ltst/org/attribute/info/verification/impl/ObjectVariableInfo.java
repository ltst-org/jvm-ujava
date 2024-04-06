package ltst.org.attribute.info.verification.impl;

import cn.hutool.core.util.ByteUtil;
import lombok.Getter;
import lombok.ToString;
import ltst.org.attribute.info.verification.VerificationInfo;
import ltst.org.attribute.info.verification.VerifyTag;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

/**
 * Object_variable_info {
 *     u1 tag = ITEM_Object;
 * }
 */
@Getter
@ToString
public class ObjectVariableInfo extends VerificationInfo {
    public short cpoolIndex;
    public ObjectVariableInfo(ClassReader cr){
        this.tag = VerifyTag.ITEM_Object;
        this.cpoolIndex = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
    }
}
