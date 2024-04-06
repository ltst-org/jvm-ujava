package ltst.org.attribute.info.verification.impl;

import lombok.Getter;
import lombok.ToString;
import ltst.org.attribute.info.verification.VerificationInfo;
import ltst.org.attribute.info.verification.VerifyTag;
import ltst.org.classfile.ClassReader;

/**
 * Long_variable_info {
 *     u1 tag = ITEM_Long;
 * }
 */
@Getter
@ToString
public class LongVariableInfo extends VerificationInfo {
    public LongVariableInfo(ClassReader cr){
        this.tag = VerifyTag.ITEM_Long;
    }
}
