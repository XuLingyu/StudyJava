package javahigh.annotation.MetaAnnotation;

import javahigh.annotation.diyannotation.DBUtil;
import javahigh.annotation.diyannotation.JDBCConfig;

//@Inherited 表示该注解具有继承性。如例，设计一个DBUtil的子类，其getConnection2方法，可以获取到父类DBUtil上的注解信息。
public class AnnotationInherited extends DBUtil {
    public static String getConnection2() throws  SecurityException {
        //获取到父类DBUtil上的注解信息。 JDBCConfig config = DBUtil.class.getAnnotation(JDBCConfig.class);
        JDBCConfig config = AnnotationInherited.class.getAnnotation(JDBCConfig.class);
        String ip = config.ip();
        int port = config.port();
        String database = config.database();
        String encoding = config.encoding();
        String loginName = config.loginName();
        String password = config.password();

        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encoding);
        return url;
    }

    public static void main(String[] args) throws  SecurityException {
        System.out.println(getConnection2());
    }
}
