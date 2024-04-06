package ltst.org.attribute.info.verification.impl;

import lombok.Getter;
import lombok.ToString;
import ltst.org.attribute.info.verification.VerificationInfo;
import ltst.org.attribute.info.verification.VerifyTag;
import ltst.org.classfile.ClassReader;

/**
 * Null_variable_info {
 *     u1 tag = ITEM_Null;
 * }
 */
@Getter
@ToString
public class NullVariableInfo extends VerificationInfo {
    public NullVariableInfo(ClassReader cr){
        this.tag = VerifyTag.ITEM_Null;
    }
}
