package ltst.org.attribute.info.verification.impl;

import lombok.Getter;
import lombok.ToString;
import ltst.org.attribute.info.verification.VerificationInfo;
import ltst.org.attribute.info.verification.VerifyTag;
import ltst.org.classfile.ClassReader;

/**
 * Top_variable_info {
 *     u1 tag = ITEM_Top;
 * }
 */
@Getter
@ToString
public class TopVariableInfo extends VerificationInfo {
    public TopVariableInfo(ClassReader cr){
        this.tag = VerifyTag.ITEM_Top;
    }
}
