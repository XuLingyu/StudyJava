package javamiddle.g_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;


public class MyConnectionPool {
    //List<Connection> cp = Collections.synchronizedList(new LinkedList<>());
    LinkedList<Connection> cp = new LinkedList<>();
    int size;

    //构造大小为size的连接池
    public MyConnectionPool(int size){
        this.size = size;
        init();
    }


    public void init(){
        //不需要close connection 不能使用try-with-resource
        try{
            Class.forName("com.mysql.jdbc.Driver");

            for(int i = 0; i< 10; i ++){
                Connection c = DriverManager.getConnection
                        ("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "admin");
                cp.offer(c);
            }

        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // synchronized 同步
    public synchronized Connection getConnection(){
        while(cp.isEmpty()){
            //当前线程等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return cp.pollFirst();
    }
    //synchronized 同步
    public synchronized void returnConnection(Connection c){
            cp.add(c);
            cp.notifyAll();
    }
}
