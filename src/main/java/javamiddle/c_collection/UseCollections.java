package javamiddle.c_collection;

import javabasic.E_ExtendInterfaceAbstract.Garen;
import javabasic.E_ExtendInterfaceAbstract.Hero;

import java.util.*;

public class UseCollections {
    public static void basicCpllectionsMethod() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }

        System.out.println("集合中的数据:");
        System.out.println(numbers);

        Collections.shuffle(numbers);
        System.out.println("混淆后集合中的数据:");
        System.out.println(numbers);

        Collections.sort(numbers);
        System.out.println("排序后集合中的数据:");
        System.out.println(numbers);

        Collections.reverse(numbers);
        System.out.println("翻转后集合中的数据:");
        System.out.println(numbers);

        Collections.swap(numbers, 0, 5);
        System.out.println("交换0和5下标的数据后，集合中的数据:");
        System.out.println(numbers);

        Collections.rotate(numbers, 2);
        System.out.println("把集合向右滚动2个单位，标的数据后，集合中的数据:");
        System.out.println(numbers);

        System.out.println("把非线程安全的List转换为线程安全的List");
        List<Integer> synchronizedNumbers = (List<Integer>) Collections.synchronizedList(numbers);
        System.out.println(synchronizedNumbers);

        int count = 0;
        for (int i = 0; i < 1000 * 1000; i++) {
            Collections.shuffle(numbers);
            if (numbers.get(0) == 3 && numbers.get(1) == 1 && numbers.get(2) == 4) {
                count++;
            }
        }
        System.out.println("shuffle list 1000,000 次找到前3位出现 3 1 4的次数：" + count);
    }


    public static void collectionsSort() {
        List<Hero> list = new LinkedList<>();

        for (int i = 0; i < 100; i++) {
            list.add(new Garen());
        }

        Collections.shuffle(list);
        System.out.println("初始化后shuffle()的集合：");
        System.out.println(list);

        //直接调用sort会出现编译错误，因为Hero有各种属性
        //到底按照哪种属性进行比较，Collections也不知道，不确定，所以没法排
        //Collections.sort(heros);
        //引入Comparator，指定比较的算法
        Comparator<Hero> comparator = new Comparator<Hero>() {
            @Override
            public int compare(Hero h1, Hero h2) {
                return h1.getHp() - h2.getHp();
            }
        };

        Comparator<Hero> comparator2 = new Comparator<Hero>() {
            @Override
            public int compare(Hero h1, Hero h2) {
                return h1.name.compareToIgnoreCase(h2.name);
            }
        };


        Collections.sort(list, comparator);
        System.out.println("Way one: Sort base Hp using Comparator后的集合：");
        list.forEach((hero)->System.out.println(hero));


        Collections.shuffle(list);
        Collections.sort(list, new Comparator<Hero>() {
            @Override
            public int compare(Hero o1, Hero o2) {
                if (o1.getHp()!=(o2.getHp())) {
                    return o1.getHp()-o2.getHp();
                }
                return o1.getName().compareToIgnoreCase(o2.getName());

            }
        });
        System.out.println("Way two: Sort base name using new anonymous Comparator class后的集合：");
        list.forEach((hero)->System.out.println(hero));

        Collections.shuffle(list);
        Collections.sort(list);
        System.out.println("Way three: Sort base name using Interface Comparable后的集合：");
        list.forEach((hero)->System.out.println(hero));


        Collections.shuffle(list);
        list.sort(new Comparator<Hero>() {
            @Override
            public int compare(Hero o1, Hero o2) {
                if (!o1.getName().equalsIgnoreCase(o2.getName())) {
                    return o1.getName().compareToIgnoreCase(o2.getName());
                }
                //
                return o1.getHp()-o2.getHp();
            }
        });
        System.out.println("Way four: Sort base on name then ob hp using Java8后的集合：");
        list.forEach((hero)->System.out.println(hero));

        Collections.shuffle(list);
        list.sort((o1,o2) -> o1.getHp()-o2.getHp());
        System.out.println("Way five: Sort base hp using JAVA 8 Lambda expression：");
        list.forEach((hero)->System.out.println(hero));


    }

    public static void main(String[] args) {
        collectionsSort();
    }

}
