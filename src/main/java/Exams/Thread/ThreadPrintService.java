package Exams.Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xuly
 * @date 2021/2/21 13:57
 * @description 有3个线程A/B/C，其中A、B个线程轮流打印1-100 中间如果是10的倍数，则由C线程打印
 */
public class ThreadPrintService implements Runnable {

    /**
     * count 共享
     */
    private static int count = 1;
    private static final int MAX_VALUE = 100;
    private Integer id;
    private ReentrantLock lock;
    private Condition[] conditions;
    private String name;

    private ThreadPrintService(String name, Integer id, ReentrantLock lock, Condition[] conditions) {
        this.id = id;
        this.lock = lock;
        this.conditions = conditions;
        this.name = name;
    }

    @Override
    public void run() {
        while (count >= 0 && count <= MAX_VALUE) {
            lock.lock();
            try {
                //对序号取模,如果不等于当前线程的id,则先唤醒其他线程,然后当前线程进入等待状态
                while (count % 2 != id) {
                    if (count % 10 == 0) {
                        break;
                    }
                    conditions[(id + 1) % conditions.length].signal();
                    conditions[(id + 2) % conditions.length].signal();
                    conditions[id].await();
                }
                System.out.println(name + " : " + count);
                //序号加1
                count++;
                //唤醒当前线程的下一个线程
                conditions[(id + 1) % conditions.length].signal();
                //当前线程进入等待状态
                conditions[id].await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //将释放锁的操作放到finally代码块中,保证锁一定会释放
                lock.unlock();
            }
        }
        //数字打印完毕,线程结束前唤醒其余的线程,让其他线程也可以结束
        end();
    }

    private void end() {
        lock.lock();
        conditions[(id + 1) % conditions.length].signal();
        conditions[(id + 2) % conditions.length].signal();
        lock.unlock();
    }

    public static void main(String[] args) {
        int threadCount = 3;
        String name = "";
        ReentrantLock lock = new ReentrantLock();
        Condition[] conditions = new Condition[threadCount];
        for (int i = 0; i < threadCount; i++) {
            conditions[i] = lock.newCondition();
        }
        ThreadPrintService[] printNumbers = new ThreadPrintService[threadCount];
        for (int i = 0; i < threadCount; i++) {
            switch (i) {
                case 0:
                    name = "线程B";
                    break;
                case 1:
                    name = "线程A";
                    break;
                case 2:
                    name = "线程C";
                    break;
            }
            ThreadPrintService p = new ThreadPrintService(name, i, lock, conditions);
            printNumbers[i] = p;
        }
        for (ThreadPrintService printNumber : printNumbers) {
            new Thread(printNumber).start();
        }
    }
}
