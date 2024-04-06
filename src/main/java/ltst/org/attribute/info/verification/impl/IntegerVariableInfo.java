package ltst.org.attribute.info.verification.impl;

import lombok.Getter;
import lombok.ToString;
import ltst.org.attribute.info.verification.VerificationInfo;
import ltst.org.attribute.info.verification.VerifyTag;
import ltst.org.classfile.ClassReader;

/**
 * Integer_variable_info {
 *     u1 tag = ITEM_Integer;
 * }
 */
@Getter
@ToString
public class IntegerVariableInfo extends VerificationInfo {
    public IntegerVariableInfo(ClassReader cr){
        this.tag = VerifyTag.ITEM_Integer;
    }
}
