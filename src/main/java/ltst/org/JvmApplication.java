package ltst.org;


import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

public class JvmApplication {
    private static Log log = LogFactory.get(JvmApplication.class);
    /**
     * 主启动函数
     * @param args
     */
    public static void main(String[] args) {
        log.info("JvmApplication main run start");
    }
}
