package ltst.org.attribute.info.verification.impl;

import lombok.Getter;
import lombok.ToString;
import ltst.org.attribute.info.verification.VerificationInfo;
import ltst.org.attribute.info.verification.VerifyTag;
import ltst.org.classfile.ClassReader;

/**
 * UninitializedThis_variable_info {
 *     u1 tag = ITEM_UninitializedThis;
 * }
 */
@Getter
@ToString
public class UninitializedThisVariableInfo extends VerificationInfo {
    public UninitializedThisVariableInfo(ClassReader cr){
        this.tag = VerifyTag.ITEM_UninitializedThis;
    }
}
