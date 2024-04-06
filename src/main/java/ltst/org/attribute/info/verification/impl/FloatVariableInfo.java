package ltst.org.attribute.info.verification.impl;

import lombok.Getter;
import lombok.ToString;
import ltst.org.attribute.info.verification.VerificationInfo;
import ltst.org.attribute.info.verification.VerifyTag;
import ltst.org.classfile.ClassReader;

/**
 * Float_variable_info {
 *     u1 tag = ITEM_Float;
 * }
 */
@Getter
@ToString
public class FloatVariableInfo extends VerificationInfo {
    public FloatVariableInfo(ClassReader cr){
        this.tag = VerifyTag.ITEM_Float;
    }
}
