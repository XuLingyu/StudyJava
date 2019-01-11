package javamiddle.e_lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

import javabasic.E_ExtendInterfaceAbstract.Garen;
import javabasic.E_ExtendInterfaceAbstract.Hero;

/*
 * 与匿名类 概念相比较，
 * Lambda 其实就是匿名方法，这是一种把方法作为参数进行传递的编程思想。
 * Java会在背后，悄悄的，把这些都还原成匿名类方式。
 * 引入Lambda表达式，会使得代码更加紧凑，而不是各种接口和匿名类到处飞。
 * Lambda比较适合用在简短的业务代码中，并不适合用在复杂的系统中，会加大维护成本。
 *
 * disadvantages：low readable，version JDK8 needed，not good for debugging
 *
 */
public class TestLambda {
    public static List getList(Supplier<List> s) {
        return s.get();
    }

    private static void filter(List<Hero> heros, HeroChecker checker) {
        for (Hero hero : heros) {
            if (checker.test(hero))
                System.out.println(hero);
        }
    }

    public static boolean testHero(Hero h) {
        return h.hp > 100 && h.damage < 50;
    }

    public static void normalListFilter(List<Hero> heroes) {
        System.out.println("normalListFilter：");
        for (Hero hero : heroes) {
            if (hero.hp > 100 && hero.damage < 50)
                System.out.println(hero);
        }
    }

    public static void anonymousClassFilter(List<Hero> heroes) {
        System.out.println("anonymousClassFilter：");
        HeroChecker checker = new HeroChecker() {
            @Override
            public boolean test(Hero h) {
                return (h.hp > 100 && h.damage < 50);
            }
        };
        filter(heroes, checker);
    }

    public static void lambdaFilter(List<Hero> heroes) {
        System.out.println("lammbdaFilter：");

      /* Step one anonymous class
        HeroChecker checker = new HeroChecker() {
            @Override
            public boolean test(Hero h) {
                return (h.hp > 100 && h.damage < 50);
            }
        };*/

        /* Step two
        HeroChecker checker = (Hero h) ->{
            return h.hp>100 && h.damage<50;
        };*/

        //Step three
        HeroChecker checker = hero -> hero.hp > 100 && hero.damage < 50;
        filter(heroes, checker);
    }

    public static void lambdaWithStaticalMethod(List<Hero> heroes) {
        System.out.println("在Lambda表达式中使用静态方法：");
        filter(heroes, h -> TestLambda.testHero(h));
        System.out.println("直接引用静态方法");
        filter(heroes, TestLambda::testHero);
    }

    public static void lambdaWithObjectMethod(List<Hero> heroes) {
        System.out.println("Lambda表达式中调用容器中的对象的matched方法：");
        //filter(heroes,h-> h.matched() );
        filter(heroes, Hero::matched);
    }

    public static void lambdaWithConstructor() {
        Supplier<List> s = new Supplier<List>() {
            public List get() {
                return new ArrayList();
            }
        };

        //匿名类
        List list1 = getList(s);

        //Lambda表达式
        List list2 = getList(() -> new ArrayList());

        //引用构造器
        List list3 = getList(ArrayList::new);
    }

    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heroes = new ArrayList<Hero>();
        for (int i = 0; i < 10; i++) {
            heroes.add(new Garen("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        heroes.forEach((Hero hero) -> System.out.println(hero));
        System.out.println("筛选出 hp>100 && damange<50的英雄");

        normalListFilter(heroes);
        anonymousClassFilter(heroes);
        lambdaFilter(heroes);
        lambdaWithStaticalMethod(heroes);
        lambdaWithObjectMethod(heroes);
        lambdaWithConstructor();

    }
}


