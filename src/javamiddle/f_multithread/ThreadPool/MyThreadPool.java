package javamiddle.f_multithread.ThreadPool;

import java.util.LinkedList;

//使用线程池的原因：
//每一个线程的启动和结束都是比较消耗时间和占用资源的。
//如果在系统中用到了很多的线程，大量的启动和结束动作会导致系统的性能变卡，响应变慢。
//为了解决这个问题，引入!!!线程池!!!这种设计思想。
//线程池的模式很像生产者消费者模式，消费的对象是!!!!!!!!一个一个的能够运行的任务!!!!!!!!!!!!!!

//线程池设计思路（线程池的思路和生产者消费者模型是很接近）：
//1. 准备一个任务容器
//2. 一次性启动10个消费者线程
//3. 刚开始任务容器是空的，所以线程都wait在上面。
//4. 直到一个外部线程（main）往这个任务容器中扔了一个“任务”，就会有一个消费者线程被唤醒notify
//5. 这个消费者线程取出“任务”，并且执行这个任务，执行完毕后，继续等待下一次任务的到来。
//6. 如果短时间内，有较多的任务加入，那么就会有多个线程被唤醒，去执行这些任务。
//在整个过程中，都不需要创建新的线程，而是循环使用这些已经存在的线程


//讲解：
//1、对10个线程的控制：通过相互抢tasks这个容器对象（以下称为“锁”），
// 谁抢到谁就往下执行，抢的过程就是控制各个线程谁能醒过来的过程。
//2、一开始初始化线程池的时候，就创建了10个线程，并且都因为tasks容器为空而一直处于等待状态，
// 此时是不占有锁的。直到有新的任务出现了，添加到容器中，并且唤醒所有等待这个锁的线程。此时，竞争开始，
// 假设线程2抢到了这个锁（的使用权），那么它就有权利往下继续执行，从而继续执行while (tasks.isEmpty())的判断，
// 并跳出循环，往下运行，运行完了之后，又回到等待判断tasks是否为空的状态，如此循环，实现对10个线程的控制。
// 没有获得同步锁之前，其它线程连判断tasks是否为空的权利都没有。


public class MyThreadPool {
    // 线程池大小
    private final int threadPoolSize;

    // 任务容器
    //因为线程池里面都是线程，实现runnable接口才能做为线程的对象，也是就是new Thread(?)，也就是括号里面的东西，所以得实现runnable
    // 实现runnable接口了就得有run方法，run方法里面就是任务代码了，去掉外壳，反正就是你的任务套个runnable外壳就对了，任务这个东西太虚了，
    private LinkedList<Runnable> tasks = new LinkedList<Runnable>();

    // 试图消费任务的线程
    public MyThreadPool() {
        threadPoolSize = 10;
        // 启动10个任务消费者线程
        synchronized (tasks) {
            for (int i = 0; i < threadPoolSize; i++) {
                new TaskConsumeThread("任务消费者线程 " + i).start();
            }
        }
    }

    //增加一个task 需要唤醒所有wait（）中的任务消费者线程
    public void add(Runnable r) {
        synchronized (tasks) {
            tasks.add(r);
            tasks.notifyAll();
        }
    }

    public void addNosynchronized(Runnable r) {
        tasks.add(r);
    }


    //任务消费者线程
    class TaskConsumeThread extends Thread {
        public TaskConsumeThread(String name) {
            super(name);
        }
        Runnable task;

        public void run() {
            System.out.println("启动： " + this.getName());
            while (true) {
                //
                synchronized (tasks) {
                    //任务为空时， 当前Thread释放占用，等待新任务加入 被唤醒
                    while (tasks.isEmpty()) {
                        try {
                            tasks.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }

                    //任务不为空是 移除tasks中一个最需要被执行的任务 remove没用 要run才算结束
                    task = tasks.removeFirst();

                    // 任务完成 占用结束 允许其他可以添加任务的线程可以继续添加任务
                    tasks.notifyAll();

                }

                System.out.println(this.getName() + " 获取到任务，并执行___");

                //remove没用 要run才算结束 Runnable
                task.run();
                System.out.println(" 剩下的任务： " + tasks.size());
            }
        }
    }

    public static void main(String[] args) {

        MyThreadPool pool = new MyThreadPool();


        //每隔一秒创建一个任务
        /*while (true) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    //System.out.println("执行任务");
                    //任务可能是打印一句话
                    //可能是访问文件
                    //可能是做排序
                }
            };

           *//* for(int i =0; i < Math.random()*8+2; i++){
                pool.add(task);
            }*//*
            pool.add(task);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }*/

        //个任务执行的时间都是1秒
        //刚开始是间隔1秒钟向线程池中添加任务
        //然后间隔时间越来越短，执行任务的线程还没有来得及结束，新的任务又来了。
        //就会观察到线程池里的其他线程被唤醒来执行这些任务
        int sleep=1000;
        while(true){
            pool.add(new Runnable(){
                @Override
                public void run() {
                    //System.out.println("执行任务");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
            try {
                Thread.sleep(sleep);
                sleep = sleep>100?sleep-100:sleep;
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }


}
