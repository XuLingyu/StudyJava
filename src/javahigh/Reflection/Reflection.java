package javahigh.Reflection;

import javamiddle.g_JDBC.Hero;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//类对象概念： 所有的类，都存在一个类对象，这个类对象用于提供类本身的信息，比如有几种构造方法， 有多少属性，有哪些普通方法。
//在理解类对象之前，先说我们熟悉的对象之间的区别：
//garen和teemo都是Hero对象，他们的区别在于，各自有不同的名称，血量，伤害值。

//然后说说类之间的区别
//Hero和Item都是类，他们的区别在于有不同的方法，不同的属性。
//类对象，就是用于描述这种类，都有什么属性，什么方法的


//注： 准确的讲是一个ClassLoader下，一种类，只会有一个类对象存在。
//     通常一个JVM下，只会有一个!!!ClassLoader!!!???。因为还没有引入ClassLoader概念， 所以暂时不展开了。
public class Reflection {



    public static void method1() {

        synchronized (Reflection.class) {
            // 对于method1而言，同步对象是TestReflection.class，只有占用TestReflection.class才可以执行到这里
            System.out.println(Thread.currentThread().getName() + " 进入了method1方法");
            try {
                System.out.println("运行2秒");
                Thread.sleep(2000);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
    }

    public static synchronized void method2() {
        // 对于mehotd2而言，必然有个同步对象，通过观察发现，当某个线程在method1中，占用了TestReflection.class之后
        // 就无法进入method2，推断出，method2的同步对象，就是TestReflection.class
        System.out.println(Thread.currentThread().getName() + " 进入了method2方法");
        try {
            System.out.println("运行2秒");
            Thread.sleep(2000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

    }

    public static void getClassObject() {
        //获取类对象有3种方式
        //1. Class.forName
        //2. Hero.class
        //3. new Hero().getClass()
        //在一个JVM中，一种类，只会有一个类对象存在。所以以上三种方式取出来的类对象，都是一样的。

        //获取类对象，都会导致静态属性被初始化，而且只会执行！！！一次！！！
        //（除了直接使用 Class c = Hero.class 这种方式，这种方式不会导致静态属性被初始化）
        String className = "javamiddle.g_JDBC.Hero";
        try {
            Class pClass1 = Class.forName(className);
            Class pClass2 = Hero.class;
            Class pClass3 = new Hero().getClass();
            System.out.println(pClass1 == pClass2);
            System.out.println(pClass1 == pClass3);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void testSynchronizedClassMethod() {
        //在之前有一个练习，练习-在类前面加修饰符synchronized
        //在对象方法前，加上修饰符synchronized ，同步对象是当前实例。
        //那么如果在类方法前，加上修饰符 synchronized，同步对象是类对象
        Thread thread = new Thread("t1") {
            public void run() {
                System.out.println(new Date(System.currentTimeMillis()));
                method1();
                System.out.println(new Date(System.currentTimeMillis()));
            }
        };
        thread.start();
        //线程二不能访问类对象，当类对象被线程1占用的时候 证明了synchronized修饰类方法 同步对象是类对象
        new Thread("te") {
            @Override
            public void run() {
                System.out.println(new Date(System.currentTimeMillis()));
                method2();
                System.out.println(new Date(System.currentTimeMillis()));
            }
        }.start();
    }

    public static void createObjectUsingClassObject() {
        //传统的使用new的方式创建对象
        Hero h1 = new Hero();
        h1.setName("temmo");
        System.out.println(h1);

        //使用反射的方式创建对象
        try {

            String className = "javamiddle.g_JDBC.Hero";
            //类对象
            Class pClass = Class.forName(className);
           /* //构造器
            Constructor c= pClass.getConstructor();
            //通过构造器实例化
            Hero h2= (Hero) c.newInstance();*/

            // Class.newInstance() 里面其实也是调用的Constructor.newInstance()
            Hero h2 = (Hero) pClass.newInstance();
            h2.setName("gareen");
            System.out.println(h2);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void createObjectUsingConfig() {
        try {

            File f = new File("E:\\SSM\\StudyJava\\src\\javahigh\\Reflection\\hero.config");
            BufferedReader br = new BufferedReader(new FileReader(f));

            String str = br.readLine();
            Class pClass = Class.forName(str);
            Constructor c = pClass.getConstructor();
            Hero hero = (Hero) c.newInstance();
            hero.setName("jax");
            System.out.println(hero);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void changeAttributeValue() {
        //getField和getDeclaredField的区别
        //这两个方法都是用于获取字段
        //getField 只能获取public的，包括从父类继承来的字段。
        //getDeclaredField 可以获取本类所有的字段，包括private的，但是不能获取继承来的字段。
        // (注： 这里只能获取到private的字段，但并不能访问该private字段的值,除非加上setAccessible(true))
        try {
            Hero h = new Hero();
            //获取类Hero的名字叫做name的声明字段
            Field f1 = h.getClass().getDeclaredField("name");
            Field f2 = h.getClass().getDeclaredField("hp");

            //修改这个字段的值
            f1.set(h, "teemo");
            f2.set(h, 100);
            //设置字段可访问，即暴力反射 private也可以访问（我觉得不需要 因为有public getName方法）
            //field.setAccessible(true);
            System.out.println(f1.get(h));
            System.out.println(f2.get(h));

            System.out.println(h);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void invokeMethod() {
        Hero hero = new Hero();
        try {
            // 获取这个名字叫做setName，参数类型是String的方法(必填)
            Method m = hero.getClass().getDeclaredMethod("setName", String.class);
            // 对h对象，调用这个方法
            m.invoke(hero,"Jonas");
            Method m2 = hero.getClass().getDeclaredMethod("getName");
            System.out.println(m2.invoke(hero));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void reflectionExam(File file){
        List<String> className = new ArrayList<>();
        List<String> heroName = new ArrayList<>();
        List<Hero> heros = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))){

            //读取config内容存入classname 和 heroname
            String line;
            while (true) {
                // 一次读一行
                line = br.readLine();
                if(null == line){
                    break;
                }
                if(line.endsWith("Hero")){
                    className.add(line);
                }else{
                    heroName.add(line);
                }
            }
            //使用反射实例化出英雄 给英雄设置名称 存入heros
            for (int i = 0; i < className.size(); i++) {
                Class c = Class.forName(className.get(i));

                Hero h = (Hero) c.newInstance();
                //反射访问父类属性
               /* Field hero1NameField = h.getClass().getField("name");
                hero1NameField.set(h, heroName.get(i));*/

                //反射调用方法
                // getDeclaredMethod getMethod
                //这里调用父类继承的public setName方法 所以只能用getMethod来获取方法
                //getDeclaredMethod 获取本类所有方法 也包括private 但是不能获取继承的方法
                //这个和  “getField和getDeclaredField的区别” 相同
                Method m = h.getClass().getMethod("setName", String.class);
                //通过反射
                m.invoke(h, heroName.get(i));
                System.out.println(h);
                heros.add(h);
            }

            //通过反射，通过反射，调用第一个英雄的attackHero方法，攻击第二个英雄
            Method method = heros.get(0).getClass().getMethod("attackHero", Hero.class);
            method.invoke(heros.get(0), heros.get(1));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
       /* System.out.println("获得类对象三种方式");
        getClassObject();

        System.out.println("synchronized在类方法使用其实就是同步类对象");
        testSynchronizedClassMethod();

        System.out.println("用类对象创建对象（通过反射机制创建一个对象）");
        createObjectUsingClassObject();

        System.out.println("通过Config文件配置创建对象 Spring 中的 class配置应该就是用这种反射机制实例化对象");
        createObjectUsingConfig();

        System.out.println("通过反射修改属性的值");
        changeAttributeValue();

        System.out.println("通过反射机制调用Hero的setName（注意方法String.class ，参数类型是String的方法(必填)）");
        invokeMethod();*/

        System.out.println("根据这个配置文件，使用反射实例化出两个英雄出来。\n" +
                "然后通过反射给这两个英雄设置名称，接着再通过反射，调用第一个英雄的attackHero方法，攻击第二个英雄" +
        "注意Class.getMethod（）和 getDeclaredMethod区别");
        reflectionExam(new File("E:\\SSM\\StudyJava\\src\\javahigh\\Reflection\\hero2.config"));
    }


}
