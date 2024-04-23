package ltst.org.attribute.info.bootstrap;

import cn.hutool.core.util.ByteUtil;
import ltst.org.classfile.ClassReader;

import java.nio.ByteOrder;

/**
 *  *     {
 *  *         u2 bootstrap_method_ref;
 *  *         u2 num_bootstrap_arguments;
 *  *         u2 bootstrap_arguments[num_bootstrap_arguments];
 *  *     }
 */
public class BootstrapMethodInfo {
    public short bootstrapMethodRef;
    public short numBootstrapArguments;
    public short[] bootstrapArguments;
    public BootstrapMethodInfo(ClassReader cr){
        this.bootstrapMethodRef = ByteUtil.bytesToShort(cr.readU2(), ByteOrder.BIG_ENDIAN);
        this.numBootstrapArguments = ByteUtil.bytesToShort(cr.readU2(),ByteOrder.BIG_ENDIAN);
        this.bootstrapArguments = new short[numBootstrapArguments];
        for (int i = 0; i < this.bootstrapArguments.length; i++) {
            this.bootstrapArguments[i] = ByteUtil.bytesToShort(cr.readU2(),ByteOrder.BIG_ENDIAN);
        }
    }
}
