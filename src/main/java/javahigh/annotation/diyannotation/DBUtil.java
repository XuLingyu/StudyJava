package javahigh.annotation.diyannotation;

import java.sql.SQLException;

//现在改为了以注解的方式，提供这些信息了（注解方式DBUtil）
@JDBCConfig(ip = "127.0.0.1", database = "test", encoding = "UTF-8", loginName = "root", password = "admin")
public class DBUtil {
    /*static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/

    public static String getConnection() throws SQLException, NoSuchMethodException, SecurityException {
        //接下来就通过反射，获取这个DBUtil这个类上的注解对象（解析注解）
        JDBCConfig config = DBUtil.class.getAnnotation(JDBCConfig.class);

        //拿到注解对象之后，通过其方法，获取各个注解元素的值：
        String ip = config.ip();
        int port = config.port();
        String database = config.database();
        String encoding = config.encoding();
        String loginName = config.loginName();
        String password = config.password();

        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encoding);
        return url;
    }

    public static void main(String[] args) throws NoSuchMethodException, SecurityException, SQLException {
        String c = getConnection();
        System.out.println(c);
    }

}