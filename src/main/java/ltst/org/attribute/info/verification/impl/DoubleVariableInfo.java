package ltst.org.attribute.info.verification.impl;

import lombok.Getter;
import lombok.ToString;
import ltst.org.attribute.info.verification.VerificationInfo;
import ltst.org.attribute.info.verification.VerifyTag;
import ltst.org.classfile.ClassReader;

/**
 * Double_variable_info {
 *     u1 tag = ITEM_Double;
 * }
 */
@Getter
@ToString
public class DoubleVariableInfo extends VerificationInfo {
    public DoubleVariableInfo(ClassReader cr){
        this.tag = VerifyTag.ITEM_Double;
    }
}
