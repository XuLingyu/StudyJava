package Exams.Stack;


import javabasic.E_ExtendInterfaceAbstract.Garen;
import javabasic.E_ExtendInterfaceAbstract.Hero;

import java.util.LinkedList;

//注意要synchronized方法就全部一起用 不然一些对方法使用一些对对象使用会有错误
public class MyStackSynchronized implements Stack {
    //把LinkedList通过 Collections.synchronizedList转换成了一个线程安全的List
    //List<Hero> heros = (List<Hero>) Collections.synchronizedList(new LinkedList<Hero>());
    static LinkedList<Hero> ll = new LinkedList<>();

    @Override
    public void  push(Hero h) {
       synchronized(ll){
            ll.offer(h);
        }

    }

    @Override
    public Hero pull() {
        synchronized(ll) {
            return ll.pollLast();
        }
    }

    @Override
    public Hero peek() {
        synchronized(ll){
            return ll.getLast();
        }

    }

/*    @Override
    public synchronized void  push(Hero h) {
        ll.offer(h);
    }

    @Override
    public synchronized Hero pull() {
        return ll.pollLast();
    }

    @Override
    public synchronized Hero peek() {
        return ll.getLast();
    }*/

    public static void main(String[] args) {
        MyStackSynchronized heroStack = new MyStackSynchronized();
        for(int i=0;i<10;i++) {      //存入10个英雄到MyStack中
            Hero h = new Garen("Garen "+i);
            heroStack.push(h);
        }

        int n = 10000;

        Thread[] addThreads = new Thread[n];
        Thread[] reduceThreads = new Thread[n];
        for (int i = 0; i < n; i++) {
            Thread t = new Thread() {
                public void run() {
                    Hero h = new Garen("Garen ");
                    heroStack.push(h);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            addThreads[i] = t;

        }

        for (int i = 0; i < n; i++) {
            Thread t = new Thread() {
                public void run() {
                    heroStack.pull();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            reduceThreads[i] = t;
        }

        //等待所有增加线程结束
        for (Thread t : addThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        //等待所有减少线程结束
        for (Thread t : reduceThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        System.out.println(ll.size());

    }
}
