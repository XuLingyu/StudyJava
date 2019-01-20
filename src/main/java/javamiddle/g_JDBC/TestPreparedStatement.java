package javamiddle.g_JDBC;

import java.sql.*;


//Statement :
// 普通的不带参的查询SQL；
// Statement 每次执行sql语句，数据库都要执行sql语句的编译 ，
// 最好用于仅执行一次查询并返回结果的情形，效率高于PreparedStatement.

//PreparedStatement :
// 可变参数的SQL,编译一次,执行多次,效率高;
// 安全性好，有效防止Sql注入等问题;
// 支持批量更新,批量删除;


//CallableStatement :
// 继承自PreparedStatement,支持带参SQL操作;
// 支持调用存储过程,提供了对输出和输入/输出参数的支持;
//存储过程(Stored Procedure),是一组为了完成特定功能的SQL 语句，类似一门程序设计语言，
// 也包括了数据类型、流程控制、输入和输出和它自己的函数库。存储过程可以说是一个记录集，它是由一些T-SQL语句组成的代码块，
// 这些T-SQL语句代码像一个方法一样实现一些功能（对单表或多表的增删改查），然后再给这个代码块取一个名字，在用到这个功能的时候调用他就行了。
//create proc StuProc
//@sname varchar(100)
//as
//begin
//select S#,Sname,Sage,Ssex from student where sname=@sname
//end
//go
//
//exec StuProc '赵雷'   //执行语句

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


//CallableStatement :(用于执行对数据库已存储过程的调用)

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
        //null menas auto increment
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
            end = System.currentTimeMillis();
            System.out.println("start time:" + start + "; end time:" + end + "; Run Time:" + (end - start) + "(ms)");

            //PreparedStatement插入
            start1 = System.currentTimeMillis();
            for (int j = 0; j < 10000; j++) {
                ps.setString(1, "英雄" + j);
                ps.setFloat(2, 313.0f);
                ps.setInt(3, 50);
                ps.addBatch();
            }
            ps.executeBatch();
            end1 = System.currentTimeMillis();
            System.out.println("start time:" + start1 + "; end time:" + end1 + "; Run Time:" + (end1 - start1) + "(ms)");

            CallableStatement cstmt = c.prepareCall("{call getTestData(?,?)}");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
