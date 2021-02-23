package Exams.Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xuly
 * @date 2021/2/21 10:53
 * @description
 */
public class ThreadPrint {
    //synchronized关键字实现
    public static class TestDemo implements Runnable {

        private static Object lock = new Object();

        private static int count = 0;

        int no;

        public TestDemo(int no) {
            this.no = no;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (count > 100) {
                        break;
                    }
                    if (count % 3 == this.no) {
                        System.out.println(this.no + "--->" + count);
                        count++;
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    lock.notifyAll();
                }
            }
        }
    }

    //ReentrantLock实现
    public static class TestDemo2 implements Runnable {
        private int no;
        private static ReentrantLock lock = new ReentrantLock();
        private static Condition condition = lock.newCondition();
        private static int count;

        public TestDemo2(int no) {
            this.no = no;
        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    if (count > 100) {
                        break;
                    } else {
                        if (count % 3 == this.no) {
                            String name = "";
                            switch (no) {
                                case 0:
                                    name = "线程A";
                                    break;
                                case 1:
                                    name = "线程B";
                                    break;
                                case 2:
                                    name = "线程C";
                                    break;
                            }
                            System.out.println(name + ": " + count);
                            count++;
                        } else {
                            try {
                                condition.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    condition.signalAll();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new TestDemo2(0));
        Thread t2 = new Thread(new TestDemo2(1));
        Thread t3 = new Thread(new TestDemo2(2));
        t1.start();
        t2.start();
        t3.start();
    }
}
