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
     * 主启动函数
     * @param args 入参
     */
    public static void main(String[] args) throws IOException {
        log.info("JvmApplication main run start");
        File f = new File("src/main/resources/class/TestHelloWorld.class");
        log.info("class file path :{}",f.getAbsolutePath());
        if(!f.exists()){
            throw new RuntimeException("被解析的class文件不存在");
        }
        ClassFile cf = new ClassFile();
        cf.parseClass(new ClassReader(Files.newInputStream(f.toPath())));
        log.info("after parse ClassFile :{}",cf);
    }
}
