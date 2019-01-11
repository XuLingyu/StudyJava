package javamiddle.f_multithread.ThreadSynchronous;

import java.text.SimpleDateFormat;
import java.util.Date;

/*   总体解决思路是： 在增加线程访问hp期间，其他线程不可以访问hp
     1. 增加线程获取到hp的值，并进行运算
     2. 在运算期间，减少线程试图来获取hp的值，但是不被允许
     3. 增加线程运算结束，并成功修改hp的值为10001
     4. 减少线程，在增加线程做完后，才能访问hp的值，即10001
     5. 减少线程运算，并得到新的值10000*/

/* synchronized表示当前线程，独占 对象 someObject
    当前线程独占 了对象someObject，如果有其他线程试图占有对象someObject，就会等待，直到当前线程释放对someObject的占用。
    someObject 又叫同步对象，所有的对象，都可以作为同步对象
    为了达到同步的效果，必须使用同一个同步对象

    释放同步对象的方式： synchronized 块自然结束，或者有异常抛出*/

/*
    Synchronized 的两种方式：
    1. 同步对象
    synchronized (someObject) {
        gareen.recover();
    }

    2.同步方法（常用）
    所有方法synchronized这样设计出来的类是线程安全的类。
    public synchronized void recover(){
           hp=hp-1;
    }
     public void recover(){
        synchronized (this) {
            hp=hp-1;
        }
    }

 */
public class SolveSynchronousProblem {
    public static String now() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    public static void main(String[] args) {

        /*是这样的，在以前的JDK版本里，当某个引用要被匿名了所使用，必须用final进行修饰才可以。
        在新的JDK版本里，这个final修饰符被编译器自动加上了，不需要开发人员手动显示得加上。

        你可以试试先把final去掉，然后在匿名类里让这个someObject指向一个新的对象，可以发现，编译器提示这个引用存在final修饰相关限制*/
        final Object[] someObject = {new Object()};

        Thread t1 = new Thread("f_multithread t1") {
            public void run() {
                try {
                    System.out.println(now() + " t1 线程已经运行");
                    System.out.println(now() + this.getName() + " 试图占有对象：someObject");
                    synchronized (someObject[0]) {

                        System.out.println(now() + this.getName() + " 占有对象：someObject");
                        Thread.sleep(5000);
                        System.out.println(now() + this.getName() + " 释放对象：someObject");
                    }
                    System.out.println(now() + " t1 线程结束");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
        t1.start();
        Thread t2 = new Thread() {
            public void run() {
                try {
                    System.out.println(now() + " t2 线程已经运行");
                    System.out.println(now() + this.getName() + " 试图占有对象：someObject");
                    synchronized (someObject[0]) {
                        System.out.println(now() + this.getName() + " 占有对象：someObject");
                        Thread.sleep(5000);
                        System.out.println(now() + this.getName() + " 释放对象：someObject");
                    }
                    System.out.println(now() + " t2 线程结束");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
        t2.setName("f_multithread t2");
        t2.start();
    }
}