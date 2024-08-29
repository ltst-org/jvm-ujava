package ltst.org.vm.heap;

import java.util.HashMap;

/**
 * jjvmheap
 */
public class JJVMHeap {
    private HashMap<String,Object> oldHeap;
    private HashMap<String,Object> edenHeap;
    private HashMap<String,Object> s1Heap;
    private HashMap<String,Object> s2Heap;
    public JJVMHeap() {
        init();
    }
    public void init(){
        oldHeap = new HashMap<>();
        edenHeap = new HashMap<>();
        s1Heap = new HashMap<>();
        s2Heap = new HashMap<>();
    }
}
