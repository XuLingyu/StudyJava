package javamiddle.g_JDBC;

import java.sql.*;

/*CREATE TABLE hero (
        id int(11) AUTO_INCREMENT,//自增长id
        ...
        }*/

/*
Statement stmt =  stmt = conn.createStatement();
statement.executeUpdate("DROP TABLE IF EXISTS  REGISTRATION ");
String sql = "CREATE TABLE REGISTRATION " +
                   "(id INTEGER not NULL, " +
                   " first VARCHAR(255), " +
                   " last VARCHAR(255), " +
                   " age INTEGER, " +
                   " PRIMARY KEY ( id ))";
 stmt.executeUpdate(sql);
 */

//Delete
//String sql2 = "delete from hero where id = 5" ;
//Update
//String sql3 = "update hero set name = 'name 5' where id = 3";
//查询
        /*String sql = "select * from hero";
         //执行查询语句，并把结果集返回给ResultSet
        ResultSet rs = s.executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt("id");// 可以使用字段名
            String name = rs.getString(2);// 也可以使用字段的顺序
            float hp = rs.getFloat("hp");
            int damage = rs.getInt(4);
            System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
        }*/

public class TestJDBC {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/how2java";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public static void execute(String sql) {
        try (Connection connection = DriverManager
                .getConnection("jdbc:myql://127.0.0.1:3306/how2java?charsetEncoding=UTF-8", "root", "admin");
             Statement statement = connection.createStatement();) {
            if (sql.toLowerCase().startsWith("insert")) {
                System.out.println("执行增加语句");
                statement.execute(sql);
            } else if (sql.toLowerCase().startsWith("delete")) {
                System.out.println("执行删除语句");
                statement.execute(sql);
            } else if (sql.toLowerCase().startsWith("update")) {
                System.out.println("执行修改语句");
                statement.execute(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {


        String sql = "insert into hero values(null,?,?,?)";
        try (Connection c = DriverManager.getConnection(
                DB_URL, USER, PASSWORD);
            PreparedStatement ps = c.prepareStatement(sql)) {

            Class.forName(JDBC_DRIVER);

            for (int i = 0; i < 10; i++) {
                ps.setString(1, "提莫");
                ps.setFloat(2, 313.0f);
                ps.setInt(3, 50);
                ps.execute();
            }
            // 查看数据库层面的元数据
            // 即数据库服务器版本，驱动版本，都有哪些数据库等等
            DatabaseMetaData dbmd = c.getMetaData();

            // 获取数据库服务器产品名称
            System.out.println("数据库产品名称:\t"+dbmd.getDatabaseProductName());
            // 获取数据库服务器产品版本号
            System.out.println("数据库产品版本:\t"+dbmd.getDatabaseProductVersion());
            // 获取数据库服务器用作类别和表名之间的分隔符 如test.user
            System.out.println("数据库和表分隔符:\t"+dbmd.getCatalogSeparator());
            // 获取驱动版本
            System.out.println("驱动版本:\t"+dbmd.getDriverVersion());

            System.out.println("可用的数据库列表：");
            // 获取数据库名称
            ResultSet rs = dbmd.getCatalogs();
            while (rs.next()) {
                System.out.println("数据库名称:\t"+rs.getString(1));
            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}

