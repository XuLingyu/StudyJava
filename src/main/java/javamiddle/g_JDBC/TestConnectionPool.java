package javamiddle.g_JDBC;

//首先初始化一个有3条连接的数据库连接池
//然后创建100个线程，每个线程都会从连接池中借用连接，并且在借用之后，归还连接。 拿到连接之后，执行一个耗时1秒的SQL语句。
//
//运行程序，就可以观察到如图所示的效果
public class TestConnectionPool {

    public static void main(String[] args) {

        //首先初始化一个有3条连接的数据库连接池
        ConnectionPool cp = new ConnectionPool(3);

        //创建100个线程，每个线程都会从连接池中借用连接，并且在借用之后，归还连接。 拿到连接之后，执行一个耗时1秒的SQL语句。
        for (int i = 0; i < 100; i++) {
            new WorkingThread("working thread" + i, cp).start();
        }

    }
}

