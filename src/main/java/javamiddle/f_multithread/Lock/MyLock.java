package javamiddle.f_multithread.Lock;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


//Summary:
// 1. Lock是一个接口，而synchronized是Java中的关键字，synchronized是内置的语言实现，Lock是代码层面的实现。
// 2. Lock可以选择性的获取锁，如果一段时间获取不到，可以放弃。synchronized不行，会一根筋一直获取下去。
//    借助Lock的这个特性，就能够规避死锁，synchronized必须通过谨慎和良好的设计，才能减少死锁的发生。
// 3. synchronized在发生异常和同步块结束的时候，会自动释放锁。而Lock必须手动释放， 所以如果忘记了释放锁，一样会造成死锁。


public class MyLock {

    public static String now() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    public static void log(String msg) {
        System.out.printf("%s %s %s %n", now() , Thread.currentThread().getName() , msg);
    }

    //Lock是一个接口，为了使用一个Lock对象，需要用到 Lock lock = new ReentrantLock();
    //与 synchronized (someObject) 类似的，lock()方法，
    // 表示当前线程占用lock对象，一旦占用，其他线程就不能占用了。
    //与 synchronized 不同的是，一旦synchronized 块结束，就会自动释放对someObject的占用。
    // lock却必须调用unlock方法进行手动释放，为了保证释放的执行，往往会把unlock() 放在finally中进行。
    public static void lockLock(){
        Lock lock = new ReentrantLock();

        Thread t1 = new Thread() {
            public void run() {
                try {
                    log(" 线程启动");
                    log("试图占有对象：lock");

                    lock.lock();

                    log("占 有对象：lock");
                    log("进行5秒的业务操作");
                    Thread.sleep(5000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    log("释放 对象：lock");
                    lock.unlock();
                }
                log("线程结束");
            }
        };
        t1.setName("t1");
        t1.start();
        try {
            //先让t1飞2秒
            log("先让t1飞2秒");
            Thread.sleep(2000);

        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        Thread t2 = new Thread() {

            public void run() {
                try {
                    log("线程启动");
                    log("试图占有对象：lock");

                    lock.lock();

                    log("占有对象：lock");
                    log("进行5秒的业务操作");
                    Thread.sleep(5000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    log("释放对象：lock");
                    lock.unlock();
                }
                log("线程结束");
            }
        };
        t2.setName("t2");
        t2.start();
    }

    //synchronized 是不占用到手不罢休的，会一直试图占用下去。
    //与 synchronized 的钻牛角尖不一样，Lock接口还提供了一个trylock方法。
    //trylock会在指定时间范围内试图占用，占成功了，就啪啪啪。 如果时间到了，还占用不成功，扭头就走~
    //
    //注意： 因为使用trylock有可能成功，有可能失败，所以后面unlock释放锁的时候，需要判断是否占用成功了，如果没占用成功也unlock,就会抛出异常
    public static void tryLock(){
        Lock lock = new ReentrantLock();

        Thread t1 = new Thread() {
            public void run() {
                boolean locked = false;
                try {
                    log("线程启动");
                    log("试图占有对象：lock");

                    locked = lock.tryLock(1,TimeUnit.SECONDS);

                    //判断有没有占有成功
                    if(locked){
                        log("占有对象：lock");
                        log("进行5秒的业务操作");
                        Thread.sleep(5000);
                    }
                    else{
                        log("经过1秒钟的努力，还没有占有对象，放弃占有");
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {

                    if(locked){
                        log("释放对象：lock");
                        lock.unlock();
                    }
                }
                log("线程结束");
            }
        };
        t1.setName("t1");
        t1.start();
        try {
            //先让t1飞2秒
            Thread.sleep(2000);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        Thread t2 = new Thread() {

            public void run() {
                boolean locked = false;
                try {
                    log("线程启动.");
                    log("试图占有对象：lock");

                    locked = lock.tryLock(1,TimeUnit.SECONDS);
                    if(locked){
                        log("占有 对象：lock");
                        log("进行 5秒的业务操作");
                        Thread.sleep(5000);
                    }
                    else{
                        log("经过1秒钟的努力，还没有占有对象，放弃占有");
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {

                    if(locked){
                        log("释放对象：lock");
                        lock.unlock();
                    }
                }
                log("线程结束");
            }
        };
        t2.setName("t2");
        t2.start();
    }

    //使用synchronized方式进行线程交互，用到的是同步对象的wait,notify和notifyAll方法
    //
    //Lock也提供了类似的解决办法，首先通过lock对象得到一个Condition对象，然后分别调用这个Condition对象的：await, signal,signalAll 方法
    public static void lockInteraction(){
        Lock lock = new ReentrantLock();

        //通过Lock获得Condition对象
        Condition condition = lock.newCondition();

        Thread t1 = new Thread() {
            public void run() {
                try {
                    log("线程启动");
                    log("试图占有对象：lock");

                    lock.lock();

                    log("占有对象：lock");
                    log("进行5秒的业务操作");
                    Thread.sleep(5000);
                    log("临时释放对象 lock， 并等待");
                    condition.await();
                    log("重新占有对象 lock，并进行5秒的业务操作");
                    Thread.sleep(5000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    log("释放对象：lock");
                    lock.unlock();
                }
                log("线程结束");
            }
        };
        t1.setName("t1");
        t1.start();
        try {
            //先让t1飞2秒
            Thread.sleep(2000);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        Thread t2 = new Thread() {

            public void run() {
                try {
                    log("线程启动");
                    log("试图占有对象：lock");

                    lock.lock();

                    log("占有对象：lock");
                    log("进行5秒的业务操作");
                    Thread.sleep(5000);
                    log("唤醒等待中的线程");
                    condition.signal();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    log("释放对象：lock");
                    lock.unlock();
                }
                log("线程结束");
            }
        };
        t2.setName("t2");
        t2.start();
    }

    public static void main(String[] args) {
        /*lockLock();*/
        /*tryLock();*/

        lockInteraction();
    }
}
