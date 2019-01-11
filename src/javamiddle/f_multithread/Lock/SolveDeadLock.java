package javamiddle.f_multithread.Lock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SolveDeadLock {
    static boolean locked1;
    static boolean locked2;

    public static String now() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    public static void log(String msg) {
        System.out.printf("%s %s %s %n", now(), Thread.currentThread().getName(), msg);
    }

    //t1线需要使用lock1  1s  lock2 5s；均只能等待3s
    //t2线需要使用lock2  5s  lock1 5s；均只能等待3s
    //第一秒结束后 t1占用完lock1 并释放掉，等待正在被t2占用的lock2，
    //但是三秒后t2还是没有释放lock2，所以放弃了。不会造成死锁。
    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        // 第一个线程
        //t1线需要使用lock1  1s  lock2 5s；均只能等待3s
        Thread t1 = new Thread() {
            @Override
            public void run() {
                log("线程启动！");
                log("试图占有对象 lock1");
                locked1 = false;
                locked2 = false;

                try {
                    // 尝试三秒中
                    locked1 = lock1.tryLock(3, TimeUnit.SECONDS);
                    if (locked1) {
                        log("占有目标lock1进行1秒的业务");
                        Thread.sleep(1000);
                        lock1.unlock();
                        log("占有目标lock1进行1秒的业务结束释放lock1");
                    } else {
                        log("经过三秒的等待，还没有占有目标,放弃！");
                    }
                    // 尝试三秒中
                    locked2 = lock2.tryLock(3, TimeUnit.SECONDS);
                    if (locked2) {
                        log("占有目标lock2进行5秒的业务");
                        Thread.sleep(5000);
                        lock2.unlock();
                        log("占有目标lock1进行5秒的业务结束释放 lock2");
                    } else {
                        log("经过三秒的等待，还没有占有目标,放弃！");
                    }
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }

            }
        };
        t1.setName("crh1");
        t1.start();

        // 第二个线程
        // t2线需要使用lock2  5s  lock1 5s；均只能等待3s
        Thread t2 = new Thread() {
            @Override
            public void run() {
                log("线程启动！");
                log("试图占有对象 lock2");
                locked1 = false;
                locked2 = false;

                try {
                    // 尝试三秒中
                    locked2 = lock2.tryLock(3, TimeUnit.SECONDS);
                    if (locked2) {
                        log("占有目标lock2进行5秒的业务");
                        Thread.sleep(5000);
                        lock2.unlock();
                        log("占有目标lock2进行5秒的业务结束释放lock2");
                    } else {
                        log("经过三秒的等待，还没有占有目标,放弃！");
                    }
                    // 尝试三秒中
                    locked1 = lock1.tryLock(3, TimeUnit.SECONDS);
                    if (locked1) {
                        log("占有目标lock1进行5秒的业务");
                        Thread.sleep(5000);
                        lock1.unlock();
                        log("占有目标lock1进行5秒的业务结束释放lock1");
                    } else {
                        log("经过三秒的等待，还没有占有目标,放弃！");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t2.setName("crh2");
        t2.start();
    }

}
