package ltst.org.attribute.info.verification.impl;

import cn.hutool.core.util.ByteUtil;
import lombok.Getter;
import lombok.ToString;
import ltst.org.attribute.info.verification.VerificationInfo;
import ltst.org.attribute.info.verification.VerifyTag;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

/**
 * Uninitialized_variable_info {
 *     u1 tag = ITEM_Uninitialized;
 * }
 */
@Getter
@ToString
public class UninitializedVariableInfo extends VerificationInfo {
    public short offset;
    public UninitializedVariableInfo(ClassReader cr){
        this.tag = VerifyTag.ITEM_Uninitialized;
        this.offset = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
    }
}
