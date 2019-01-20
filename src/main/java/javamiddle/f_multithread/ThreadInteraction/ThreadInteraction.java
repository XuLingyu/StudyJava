package javamiddle.f_multithread.ThreadInteraction;

import javabasic.E_ExtendInterfaceAbstract.Hero;
/*
线程之间有交互通知的需求，考虑如下情况：
有两个线程，处理同一个英雄。
一个加血，一个减血。
减血的线程，发现血量=1，就停止减血，直到加血的线程为英雄加了血，才可以继续减血*/

public class ThreadInteraction {
    static class HurtThread extends Thread{
        private Hero hero;
        public HurtThread(Hero hero){
            this.hero = hero;
        }

        public void run(){
            while(true){
                hero.hurt();
                System.out.println();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }
    static class RecoverThread extends Thread{
        private Hero hero;

        public RecoverThread(Hero hero){
            this.hero = hero;
        }

        public void run(){
            while(true){
                hero.recover();
                System.out.println();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }
    public static void badSolution() {
        //故意设计减血线程频率更高，盖伦的血量迟早会到达1
        //减血线程中使用while循环判断是否是1，如果是1就不停的循环,直到加血线程回复了血量
        //这是不好的解决方式，因为会大量占用CPU,拖慢性能
        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;


        Thread t1 = new Thread() {
            public void run() {
                while (true) {

                    //因为减血更快，所以盖伦的血量迟早会到达1
                    //使用while循环判断是否是1，如果是1就不停的循环
                    //直到加血线程回复了血量

                    //volatile hp; 不然的话hp到一之后 线程读取hp只会在缓存里读取 while不出去 血量一直加加加
                    while (gareen.hp == 1) {
                        continue;
                    }

                    gareen.hurt();
                    System.out.printf("t1 为%s 减血1点,减少血后，%s的血量是%d%n", gareen.name, gareen.name, gareen.hp);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            }
        };
        t1.start();

        Thread t2 = new Thread() {
            public void run() {
                while (true) {
                    gareen.recover();
                    System.out.printf("t2 为%s 回血1点,增加血后，%s的血量是%d%n", gareen.name, gareen.name, gareen.hp);

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            }
        };
        t2.start();
    }

    public static void waitAndNotify(){
        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;

        Thread t1 = new Thread(){
            public void run(){
                while(true){

                    //无需循环判断
//                    while(gareen.hp==1){
//                        continue;
//                    }

                    gareen.hurt();

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            }
        };
        t1.start();

        Thread t2 = new Thread(){
            public void run(){
                while(true){
                    gareen.recover();

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            }
        };
        t2.start();


    }

    public static void exam(){
        //假设加血线程运行得更加频繁，英雄的最大血量是1000
        //设计加血线程和减血线程的交互，让回血回满之后，加血线程等待，直到有减血线程减血
        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 100;

        Thread t1 = new Thread(){
            public void run(){
                while(true){

                    //无需循环判断
//                    while(gareen.hp==1){
//                        continue;
//                    }

                    gareen.hurt();

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            }
        };
        t1.start();

        Thread t2 = new Thread(){
            public void run(){
                while(true){
                    gareen.recover();

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            }
        };
        t2.start();


    }



    public static void main(String[] args) {
        //badSolution();
        //waitAndNotify();
        exam();
    }

    }
