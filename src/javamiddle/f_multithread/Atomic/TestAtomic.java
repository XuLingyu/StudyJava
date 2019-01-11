package javamiddle.f_multithread.Atomic;
import java.util.concurrent.atomic.AtomicInteger;

//概念： 所谓的原子性操作即不可中断的操作，比如赋值操作
// 不是原子操作，就不是线程安全的

//volatile关键保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的
//区别： 基本来说， volatile 只解决可见性， 不保证同步。 atomic 则是保证了可见性 和 同步性。


//分别使用基本变量的非原子性的++运算符和 原子性的AtomicInteger对象的 incrementAndGet 来进行多线程测试。
public class TestAtomic {
    private static int value = 0;
    private static AtomicInteger atomicValue =new AtomicInteger();
    public static void main(String[] args) {

        int number = 100000;
        Thread[] ts1 = new Thread[number];
        for (int i = 0; i < number; i++) {
            Thread t =new Thread(){
                public void run(){
                    value++;
                }
            };
            t.start();
            ts1[i] = t;
        }
        //等待这些线程全部结束
        for (Thread t : ts1) {
            try {
                t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.printf("%d个线程进行value++后，value的值变成:%d%n", number,value);


        Thread[] ts2 = new Thread[number];
        for (int i = 0; i < number; i++) {
            Thread t =new Thread(){
                public void run(){
                    atomicValue.incrementAndGet();
                }
            };
            t.start();
            ts2[i] = t;
        }

        //等待这些线程全部结束
        for (Thread t : ts2) {
            try {
                t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.printf("%d个线程进行atomicValue.incrementAndGet()后，atomicValue的值变成:%d%n", number,atomicValue.intValue());
    }

}
