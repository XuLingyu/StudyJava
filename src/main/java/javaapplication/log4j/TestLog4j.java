package javaapplication.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

public class TestLog4j {

    static Logger logger = Logger.getLogger(TestLog4j.class);
    public static void main(String[] args) throws InterruptedException {

        //BasicConfigurator.configure();

        //与 Log4j入门 中的BasicConfigurator.configure();方式不同，采用指定配置文件
        //way one: properties file
        //PropertyConfigurator.configure("E:\\StudyJava\\src\\javaapplication\\log4j\\log4j.properties");

        //way two: .xml
        DOMConfigurator.configure("E:\\StudyJava\\src\\javaapplication\\log4j\\log4j.properties");
        for (int i = 0; i < 5000; i++) {
            logger.trace("跟踪信息");
            logger.debug("调试信息");
            logger.info("输出信息");
            logger.warn("警告信息");
            logger.error("错误信息");
            logger.fatal("致命信息");
        }
    }
}
