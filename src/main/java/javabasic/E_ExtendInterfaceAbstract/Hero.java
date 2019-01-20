package javabasic.E_ExtendInterfaceAbstract;

import java.io.Serializable;
import java.util.Objects;

public class

Hero implements Serializable, Comparable<Hero> {
    public String name;
    //volatile关键保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的
    //或者或者用AtomicInteger

    //区别
    /*基本来说， volatile 只解决可见性， 不保证同步。
    atomic 则是保证了可见性 和 同步性。
   */
    public volatile int hp;


    public int damage;

  /*  public static final String copyright;

    static {
        copyright = "my copyright";
        System.out.println(Hero.copyright);
    }*/
    public Hero(){

    }

    public Hero(String name) {
        this(0,name);
        //System.out.println("one hero created");
    }

    public Hero(int hp, String name) {
        this(name, hp, 0);
        //System.out.println("construct method running");
    }

    public Hero(String name, int hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }


    public void attackHero(Hero h) {
        try {
            //为了表示攻击需要时间，每次攻击暂停1000毫秒
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        h.hp-=damage;
        if(h.isDead()){
            h.hp=0;
            System.out.println(h.name +"死了！");
        }


        System.out.format("%s 正在攻击 %s, %s的血变成了 %d%n",name,h.name,h.name,h.hp);


    }

    public boolean isDead() {
        return 0>=hp?true:false;
    }


    /*public void finalize(){
        System.out.println("这个英雄正在被回收");
    }*/

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public synchronized void  recover() {

        if (hp == 1000) {
            try {
                // 让占用了这个同步对象的线程，临时释放当前的占用，并且等待。
                // 所以调用wait是有前提条件的，一定是在synchronized块里，否则就会出错。
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        ++this.hp;
        System.out.printf("%s 回血1点,增加血后，%s的血量是%d%n", name, name, hp);
        // 通知那些等待在this对象上的线程，可以醒过来了，等待着的减血线程，苏醒过来
        /*this.notify();*/

    }
/*
    hurt，直接加上synchronized ，其所对应的同步对象，就是this
            和hurt方法达到的效果是一样
    外部线程访问gareen的方法，就不需要额外使用synchronized 了*/
    public synchronized void  hurt() {
       /* synchronized (this) {
            --this.hp;
        }*/
        /*--this.hp;*/
        /*if (hp == 1) {
            try {
                // 让占用了这个同步对象的线程，临时释放当前的占用，并且等待。
                // 所以调用wait是有前提条件的，一定是在synchronized块里，否则就会出错。
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        hp--;*/


        hp--;
        this.notify();
        System.out.printf("%s 减血1点,减少血后，%s的血量是%d%n", name, name, hp);
    }

    // 非静态内部类，只有一个外部类对象存在的时候，才有意义
    // 战斗成绩只有在一个英雄对象存在的时候才有意义
    public class BattleScore {
        public int kill;
        int die;
        int assit;

        public void legendary() {
            if (kill >= 8)
                System.out.println(name + "超神！");
            else
                System.out.println(name + "尚未超神！");
        }
    }

    //静态内部类
    //敌方的水晶
    public static class EnemyCrystal {

        //宣布胜利
        public void checkIfVictory() {
            System.out.println(" win this game");
            //静态内部类不能直接访问外部类的对象属性
            //System.out.println(name + " win this game");
        }
    }

    @Override
    public int compareTo(Hero other) {

        return this.name.compareToIgnoreCase(other.name);

    }

    public boolean matched(){
        return this.hp>100 && this.damage<50;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return hp == hero.hp &&
                Objects.equals(name, hero.name);
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", damage=" + damage +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(hp, name);
    }

    public static void main(String[] args) {
        Hero garen = new Garen();
        garen.name = "盖伦";
        // 实例化内部类
        // BattleScore对象只有在一个英雄对象存在的时候才有意义
        // 所以其实例化必须建立在一个外部类对象的基础之上
        BattleScore score = garen.new BattleScore();
        score.kill = 9;
        score.legendary();
    }
}
