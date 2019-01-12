package Exams.Stack;


import javabasic.E_ExtendInterfaceAbstract.Garen;
import javabasic.E_ExtendInterfaceAbstract.Hero;

import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyStackWithLock implements Stack {
    //把LinkedList通过 Collections.synchronizedList转换成了一个线程安全的List
    //List<Hero> heros = (List<Hero>) Collections.synchronizedList(new LinkedList<Hero>());
    static LinkedList<Hero> ll = new LinkedList<>();
    final Lock lock = new ReentrantLock();

    @Override
    public void push(Hero h) {
       /*synchronized(ll){
            ll.offer(h);
        }*/
        lock.lock();
        ll.offer(h);
        lock.unlock();
    }

    @Override
    public Hero pull() {
        /*synchronized(ll) {
            return ll.pollLast();
        }*/
        lock.lock();
        Hero h = ll.pollLast();
        lock.unlock();
        return h;
    }

    @Override
    public Hero peek() {
       /* synchronized (ll) {
            return ll.getLast();
        }*/
        lock.lock();
        Hero h = ll.getLast();
        lock.unlock();
        return h;
    }


    public static void main(String[] args) {
        MyStackWithLock heroStack = new MyStackWithLock();
        for (int i = 0; i < 10; i++) {      //存入10个英雄到MyStack中
            Hero h = new Garen("Garen " + i);
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

        //n个线程减少盖伦的hp
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
