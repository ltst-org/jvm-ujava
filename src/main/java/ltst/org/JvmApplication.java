package ltst.org;


import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import ltst.org.classfile.ClassFile;
import ltst.org.classfile.ClassReader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class JvmApplication {
    private static final Log log = LogFactory.get(JvmApplication.class);
    /**
     * 测试使用的 Class 文件地址
     */
    private static final String TEST_CLASS_PATH = "src/main/resources/class/TestHelloWorld.class";
    /**
     * 主启动函数
     * @param args 入参
     */
    public static void main(String[] args) {
        log.info("JvmApplication main run start");
        try{
            ClassFile cf = new ClassFile(TEST_CLASS_PATH);
            cf.parseClass();
            log.info("after parse ClassFile :{}",cf);
        }catch (IOException e){
            log.error("ClassFile parse error",e);
        }
    }
}
