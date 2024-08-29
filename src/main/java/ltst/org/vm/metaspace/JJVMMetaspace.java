package ltst.org.vm.metaspace;

import java.util.HashMap;

public class JJVMMetaspace {
    private HashMap<String,Object> metaspace;
    public JJVMMetaspace() {
        init();
    }
    public void init() {
        metaspace = new HashMap<>();
    }
}
