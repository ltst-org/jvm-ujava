package ltst.org.attribute.info.verification;

import ltst.org.attribute.info.verification.impl.*;
import ltst.org.classfile.ClassReader;

public class VerificationFactory {
    public ClassReader cr;
    public VerificationFactory(ClassReader cr){
        this.cr = cr;
    }

    public VerificationInfo getInfo() {
        byte verifyICationType = cr.readU1();
        switch (verifyICationType){
            case VerifyTag.ITEM_Top:return new TopVariableInfo(cr);
            case VerifyTag.ITEM_Integer:return new IntegerVariableInfo(cr);
            case VerifyTag.ITEM_Float:return new FloatVariableInfo(cr);
            case VerifyTag.ITEM_Null:return new NullVariableInfo(cr);
            case VerifyTag.ITEM_UninitializedThis:return new UninitializedThisVariableInfo(cr);
            case VerifyTag.ITEM_Object:return new ObjectVariableInfo(cr);
            case VerifyTag.ITEM_Uninitialized:return new UninitializedVariableInfo(cr);
            case VerifyTag.ITEM_Long:return new LongVariableInfo(cr);
            case VerifyTag.ITEM_Double:return new DoubleVariableInfo(cr);
        }
        return null;
    }
}
