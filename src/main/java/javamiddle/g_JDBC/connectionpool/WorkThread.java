package javamiddle.g_JDBC.connectionpool;

import javamiddle.g_JDBC.connectionpool.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

class WorkingThread extends Thread {
    private ConnectionPool cp;
    public WorkingThread(String name, ConnectionPool cp) {
        super(name);
        this.cp = cp;
    }

    public void run() {
        Connection c = cp.getConnection();
        System.out.println(this.getName()+ ":\t 获取了一根连接，并开始工作"  );
        try (Statement st = c.createStatement()){

            //模拟时耗１秒的数据库ＳＱＬ语句
            Thread.sleep(1000);
            st.execute("select * from hero");

        } catch (SQLException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        cp.returnConnection(c);
    }
}