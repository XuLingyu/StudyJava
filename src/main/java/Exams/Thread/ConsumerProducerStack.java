package Exams.Thread;

import java.util.LinkedList;
//生产者消费者问题是一个非常典型性的线程交互的问题。
//
//1. 使用栈来存放数据
//1.1 把栈改造为支持线程安全
//1.2 把栈的边界操作进行处理，当栈里的数据是0的时候，访问pull的线程就会等待。 当栈里的数据时200的时候，访问push的线程就会等待
//2. 提供一个生产者（Producer）线程类，生产随机大写字符压入到堆栈
//3. 提供一个消费者（Consumer）线程类，从堆栈中弹出字符并打印到控制台
//4. 提供一个测试类，使两个生产者和三个消费者线程同时运行，结果类似如下 ：

public class ConsumerProducerStack<T> {
    private LinkedList<T> list;
    private int count;

    public ConsumerProducerStack() {
        list=new LinkedList<>();
        count=0;
    }
    public synchronized int getSize() {
        return list.size();
    }
    public synchronized void push(T t) {
        while(count>=200) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.offerLast(t);
        //System.out.printf("Producer 压入:%s",t);
        count++;
        this.notifyAll();
    }
    public synchronized T pull() {
        while(count<=0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T t=list.pollLast();
        //  System.out.printf("Consumer 弹出:%s",t);
        count--;
        this.notifyAll();
        return t;
    }
    public synchronized String toString() {
        return list.toString();
    }
    public synchronized T peek() {
        return list.peekLast();
    }

    public static void main(String[] args) {
        int x=2;
        int y=3;
        ConsumerProducerStack<Character> stack=new ConsumerProducerStack<>();
        //Producer producer=new Producer(new Stack<Character>());
        //Consumer consumer=new Consumer(new Stack<Character>());
        for(int i=1;i<=y;i++) {
            new Thread(new Consumer(stack,"Consumer"+i)).start();
        }
        for(int i=1;i<=x;i++) {
            new Thread(new Producer(stack,"Producer"+i)).start();
        }
    }

}
