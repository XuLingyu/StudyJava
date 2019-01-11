package javamiddle.g_JDBC;

import java.sql.*;

//向数据库中插入10000条数据，分别使用Statement和PreparedStatement，比较各自花的时间差异

////PreparedStatement  VS. Statement
////优点1-参数设置
////优点2-性能表现
////优点3-防止SQL注入式攻击
//
//// PreparedStatement 执行10次，只需要1次把SQL语句传输到数据库端
//// 数据库对带?的SQL进行预编译
//
//// 每次执行，只需要传输参数到数据库端
//// 1. 网络传输量比Statement更小
//// 2. 数据库不需要再进行编译，响应更快

public class TestPreparedStatement {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/how2java";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    static long start;
    static long end;
    static long start1;
    static long end1;

    public static void main(String[] args) {

        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String sql = "insert into hero values(null,?,?,?)";
        try (Connection c = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                Statement s = c.createStatement();
                PreparedStatement ps = c.prepareStatement(sql))
        {

            //Statement 插入
            start = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                String sql0 = "insert into hero values(null," + "'英雄" + i + "'" + "," + 303.0f + "," + 50 + ")";
                s.execute(sql0);
            }
            s.close();
            end = System.currentTimeMillis();
            System.out.println("start time:" + start + "; end time:" + end + "; Run Time:" + (end - start) + "(ms)");

            //PreparedStatement插入
            start1 = System.currentTimeMillis();
            for (int j = 0; j < 10000; j++) {
                ps.setString(1, "英雄" + j);
                ps.setFloat(2, 313.0f);
                ps.setInt(3, 50);
                ps.execute();
            }
            end1 = System.currentTimeMillis();
            System.out.println("start time:" + start1 + "; end time:" + end1 + "; Run Time:" + (end1 - start1) + "(ms)");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
