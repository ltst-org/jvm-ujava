package ltst.org.vm;

import ltst.org.classfile.ClassFile;
import ltst.org.vm.heap.JJVMHeap;
import ltst.org.vm.metaspace.JJVMMetaspace;

import java.util.HashMap;
import java.util.Stack;

public class JJVm {
    //vm 启动入口类
    private final ClassFile mainClassFile;
    public JJVm(ClassFile mainClassFile) {
        this.mainClassFile = mainClassFile;
    }

    //内存划分
    //堆
    private JJVMHeap heap;
    //元空间
    private JJVMMetaspace metaspace;
    //虚拟机栈
    private Stack<Object> vmStack;

    public void start() {
        //启动vm 初始化内存区
        heap = new JJVMHeap();
        //加载解析后的 classFile 加载到元空间
        loadMainClass(mainClassFile);
    }
    public void loadMainClass(ClassFile mainClassFile) {

    }
}
