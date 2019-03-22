package javamiddle.f_multithread;

import javabasic.E_ExtendInterfaceAbstract.*;

//创建多线程的三种方式：
//
//1. 继承Thread类 See KillThread.java
//2. 实现Runnable接口 See KillRunnable.java
//3. 匿名类的方式  see KillAnonymous
//
//注： 启动线程是start()方法，run()并不能启动一个新的线程
public class ThreadBasicMethods {

    /*
     * f_multithread.sleep(1000); 表示当前线程暂停1000毫秒 ，其他线程不受影响
     */
    public static void threadSleep() {
        Thread t1 = new Thread() {
            public void run() {
                int seconds = 0;
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.printf("已经玩了LOL %d 秒%n", seconds++);
                }
            }
        };
        t1.start();
    }

    /*
     * 首先解释一下主线程的概念
        所有进程，至少会有一个线程即主线程，即main方法开始执行，就会有一个看不见的主线程存在。
        执行t.join，即表明在主线程中加入该线程。
        主线程会等待该线程结束完毕， 才会往下运行。
     */
    public static void joinMainThread() {
        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;
        gareen.damage = 50;

        final Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;

        final Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;

        final Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 80;

        Thread t1 = new Thread() {
            public void run() {
                while (!teemo.isDead()) {
                    gareen.attackHero(teemo);
                }
            }
        };

        t1.start();

        //代码执行到这里，一直是main线程在运行
        try {
            //t1线程加入到main线程中来，只有t1线程运行结束，才会继续往下走
            t1.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Thread t2 = new Thread() {
            public void run() {
                while (!leesin.isDead()) {
                    bh.attackHero(leesin);
                }
            }
        };
        //会观察到盖伦把提莫杀掉后，才运行t2线程
        t2.start();
    }

    /*
     * 当线程处于竞争关系的时候，优先级高的线程会有更大的几率获得CPU资源
        为了演示该效果，要把暂停时间去掉，多条线程各自会尽力去占有CPU资源
        同时把英雄的血量增加100倍，攻击减低到1，才有足够的时间观察到优先级的演示
        如图可见，线程1的优先级是MAX_PRIORITY，所以它争取到了更多的CPU资源执行代码
     */
    public static void threadPriority() {
        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 6160;
        gareen.damage = 1;

        final Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 3000;
        teemo.damage = 1;

        final Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 5000;
        bh.damage = 1;

        final Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 4505;
        leesin.damage = 1;

        Thread t1 = new Thread() {
            public void run() {

                while (!teemo.isDead()) {
                    gareen.attackHero(teemo);
                }

            }
        };

        Thread t2 = new Thread() {
            public void run() {
                while (!leesin.isDead()) {
                    bh.attackHero(leesin);
                }
            }
        };

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();

        t2.start();


    }


    /*
     *当前线程，临时暂停，使得其他线程可以有更多的机会占用CPU资源
     */
    public static void threadYield() {
        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 61600;
        gareen.damage = 1;

        final Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 30000;
        teemo.damage = 1;

        final Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 50000;
        bh.damage = 1;

        final Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 45050;
        leesin.damage = 1;

        Thread t1 = new Thread() {
            public void run() {

                while (!teemo.isDead()) {

                    gareen.attackHero(teemo);
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                while (!leesin.isDead()) {
                    //临时暂停，使得t1可以占用CPU资源
                    Thread.yield();

                    bh.attackHero(leesin);
                }
            }
        };

        t1.setPriority(5);
        t2.setPriority(5);
        t1.start();
        t2.start();
    }

    /*
     * 守护线程的概念是： 当一个进程里，所有的线程都是守护线程的时候，结束当前进程。

        就好像一个公司有销售部，生产部这些和业务挂钩的部门。
        除此之外，还有后勤，行政等这些支持部门。

        如果一家公司销售部，生产部都解散了，那么只剩下后勤和行政，那么这家公司也可以解散了。

        守护线程就相当于那些支持部门后勤和行政，如果一个进程只剩下守护线程，那么进程就会自动结束。

        守护线程通常会被用来做日志，性能统计等工作。
     */
    public static void threadSetDaemon() {
        Thread t1 = new Thread() {
            public void run() {
                int seconds = 0;

                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.printf("已经玩 了LOL %d 秒%n", seconds++);

                }
            }
        };
        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 6160;
        gareen.damage = 100;

        final Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 30000;
        teemo.damage = 1;
        t1.setDaemon(true);
        t1.start();
        Thread t2 = new Thread() {
            public void run() {

                while (!teemo.isDead()) {
                    Thread.yield();
                    gareen.attackHero(teemo);
                }
            }
        };
        t2.start();
    }


    /*
       stop（）and suspend（） already deprecated
       Stop（）： this method will release the lock, and other threads may see the different states of object
       suspend（）： dead lock problem-> this method will not release lock
       solution： 让线程自行进入执行完run（）， 设置flag

       但是当thread处于非运行状态（wait(), sellp(), IO blocking） setFlag 也没用
       sleep() wait() 用 interrupt（）方法打破阻塞 在run（）catch InterruptedException 使线程安全推出
       如果是IO，比如readLine（）阻塞，那就用close（）方法，引起IOException，捕获异常结束线程
     */
    public static void threadStop() {

     /*   让线程自行进入执行完run（）， 设置flag
            class MyThread implements Runnable{
            private volatile boolean flag;
            @Override
            public void run(){
                while(flag)
                    System.out.println("asdasdasd");
            }

            public static void setFlag (){
                this.flag=false;
            }
        }*/
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread sleep()");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("thread is interrupted!");
                }
            }
        });
        thread.start();
        thread.interrupt();
    }

    public static void main(String[] args) {
        threadStop();
    }

}
