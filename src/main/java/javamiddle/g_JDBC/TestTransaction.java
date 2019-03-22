package javamiddle.g_JDBC;


import java.sql.*;
import java.util.Scanner;

/*
A transaction consists of one or many date base sql statements.
Only when all operations have been completed executed, the transaction can be submitted to the database

当c.setAutoCommit(false);时，事务是不会自动提交的
只有主动执行使用 c.commit(); 才会提交进行
设计一个代码，删除表中前10条数据，但是删除前会在控制台弹出一个提示：
是否要删除数据(Y/N)
如果用户输入Y，则删除
如果输入N则不删除。
如果输入的既不是Y也不是N，则重复提示
 */
public class TestTransaction {
    public static void main(String[] args) {
        Connection c = null;
        Statement s = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        try {
            c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root",
                    "123456");
            s = c.createStatement();
            // 有事务的前提下
            // 在事务中的多个操作，要么都成功，要么都失败
            c.setAutoCommit(false);
            for (int i = 2; i < 12; i++) {
                ResultSet rs =  s.executeQuery("select * from hero where id = " + i);
                while(rs.next()){
                    String name = rs.getString("name");
                    float hp = rs.getFloat("hp");
                    int damage = rs.getInt("damage");
                    System.out.println("試圖刪除id="+i+"的數據"+"\t"+name+"\t"+hp+"\t"+damage+"\n");
                }
            }
            System.out.println("是否刪除 : Y/N");
            if(scanner.nextLine().equals("Y")){
                for(int i=2;i<12;i++){
                    s.execute("delete from hero where id = " + i);
                }
            }
            c.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(s != null){
                try {
                    s.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(c != null){
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
