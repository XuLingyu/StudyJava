package javamiddle.f_multithread.ThreadPool;

import java.util.concurrent.*;

public class UseThreadPoolExecutor {
    public static void main(String[] args) throws InterruptedException {

        //第一个参数10 表示这个线程池初始化了10个线程在里面工作
        //第二个参数15 表示如果10个线程不够用了，就会自动增加到最多15个线程
        //第三个参数60 结合第四个参数TimeUnit.SECONDS，表示经过60秒，多出来的线程还没有接到活儿，就会回收，最后保持池子里就10个
        //第四个参数TimeUnit.SECONDS 如上
        //第五个参数 new LinkedBlockingQueue() 用来放任务的集合
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor
                (8, 16, 60,
                        TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        final CountDownLatch latch = new CountDownLatch(8);
        CyclicBarrier barrier = new CyclicBarrier(8);
        Long beginTime = System.currentTimeMillis();
        for (int i = 0; i < 8; i ++) {
            threadPool.execute(new Runnable() {

                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    System.out.println(Thread.currentThread().getName() + "begin");
                    String str = "aa";
                    for (int i = 0; i < 1000000; i ++) {
                        str = String.valueOf(Math.random());
                    }
                 /*   try {
                        barrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }*/
                    System.out.println(Thread.currentThread().getName() + "done");
                    latch.countDown();
                }
            });
        }

        latch.await();
        threadPool.shutdown();
        System.out.println((System.currentTimeMillis() - beginTime));
    }
}
