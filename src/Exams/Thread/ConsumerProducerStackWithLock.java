package Exams.Thread;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ConsumerProducerStackWithLock<T> {
    LinkedList<T> values = new LinkedList<T>();

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void push(T t) {
        /*public synchronized void push(T t)
        while(values.size()>=200) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.offerLast(t);
        //System.out.printf("Producer 压入:%s",t);
        count++;
        this.notifyAll();*/
        try {
            lock.lock();
            while (values.size() >= 200) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            condition.signalAll();
            values.offerLast(t);
            System.out.printf("Producer 压入:%s", t);
            System.out.print(values.size());
        } finally {
            lock.unlock();
        }

    }

    public T pull() {
        T t = null;
        try {
            lock.lock();
            while (values.isEmpty()) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            condition.signalAll();
            t = values.removeLast();
        } finally {
            lock.unlock();
        }
        return t;
    }

    public T peek() {
        return values.getLast();
    }

    public static void main(String[] args) {
        int x = 2;
        int y = 3;
        ConsumerProducerStack<Character> stack = new ConsumerProducerStack<>();
        //Producer producer=new Producer(new Stack<Character>());
        //Consumer consumer=new Consumer(new Stack<Character>());
        for (int i = 1; i <= y; i++) {
            new Thread(new Consumer(stack, "Consumer " + i)).start();
        }
        for (int i = 1; i <= x; i++) {
            new Thread(new Producer(stack, "Producer " + i)).start();
        }
    }
}
