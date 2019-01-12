package javamiddle.e_lambda;

import javabasic.E_ExtendInterfaceAbstract.Garen;
import javabasic.E_ExtendInterfaceAbstract.Hero;

import java.util.*;

/*要了解聚合操作，首先要建立Stream和管道的概念
Stream 和Collection结构化的数据不一样，Stream是一系列的元素，就像是生产线上的罐头一样，一串串的出来。
管道指的是一系列的聚合操作。*/

//管道又分3个部分
//管道源：在这个例子里，源是一个List heros

//中间操作： 每个中间操作，又会返回一个Stream，比如.filter()又返回一个Stream,

// 中间操作是“懒”操作，并不会真正进行遍历。
//结束操作：当这个操作执行后，流就被使用“光”了，无法再被操作。所以这必定是流的最后一个操作。
// 结束操作不会返回Stream，但是会返回int、float、String、 Collection或者像forEach，什么都不返回,
// 结束操作才进行真正的遍历行为，在遍历的时候，才会去进行中间操作的相关判断

public class Aggregate {

    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 10; i++) {
            heros.add(new Garen("hero " + i, r.nextInt(200), r.nextInt(100)));
        }
        heros.add(heros.get(0));
        System.out.println("初始化集合后的数据 (最后一个数据重复)：");
        heros.forEach((hero) -> System.out.println(hero));

        //传统方式
        System.out.println("查询条件：hp>100 && damage<50");
        System.out.println("通过传统操作方式找出满足条件的数据：");
        for (Hero h : heros) {
            if (h.hp > 100 && h.damage < 50)
                System.out.print(h.name + " ");
        }


        //聚合方式
        System.out.println();
        System.out.println("通过聚合操作方式找出满足条件的数据：");

        //管道源是集合
        heros
                .stream()
                .filter(h -> h.hp > 100 && h.damage < 50)
                .forEach(h -> System.out.print(h.name + " "));
        System.out.println();
        //管道源是数组
       /*
        Hero hs[] = heros.toArray(new Hero[heros.size()]);
        Arrays.stream(hs)
            .forEach(h -> System.out.print(h.name));*/

        //每个中间操作，又会返回一个Stream
        //对元素进行筛选：
        //filter 匹配
        //distinct 去除重复(根据equals判断)
        //sorted 自然排序
        //sorted(Comparator<T>) 指定排序
        //limit 保留
        //skip 忽略
        //转换为其他形式的流:
        //mapToDouble 转换为double的流
        //map 转换为任意类型的流

        System.out.println("去除重复的数据，去除标准是看equals");
        heros
                .stream()
                .distinct()
                .forEach(h -> System.out.print(h.name + " "));

        System.out.println();
        System.out.println("按照血量排序");
        heros
                .stream()
                .sorted((h1, h2) -> h1.hp - h2.hp)
                .forEach(h -> System.out.print(h.name + " "));

        System.out.println();
        System.out.println("保留3个");
        heros
                .stream()
                .limit(3)
                .forEach(h -> System.out.print(h + " "));

        System.out.println();
        System.out.println("忽略前3个");
        heros
                .stream()
                .skip(3)
                .forEach(h -> System.out.print(h + " "));

        System.out.println();
        System.out.println("转换为double的Stream");
        heros
                .stream()
                .mapToDouble(Hero::getHp)
                .forEach(h -> System.out.print(h + " "
                ));

        System.out.println();
        System.out.println("转换任意类型的Stream");
        heros
                .stream()
                .map((h) -> h.name + " - " + h.hp + " - " + h.damage)
                .forEach(h -> System.out.println(h));



 /*     常见结束操作如下：
        forEach() 遍历每个元素
        toArray() 转换为数组
        min(Comparator<T>) 取最小的元素
        max(Comparator<T>) 取最大的元素
        count() 总数
        findFirst() 第一个元素*/

        System.out.println("返回一个数组");
        Object[] hs = heros
                .stream()
                .toArray();
        System.out.println(Arrays.toString(hs));
        System.out.println("返回伤害最低的那个英雄");
        Hero minDamageHero = heros
                .stream()
                .min((h1, h2) -> h1.damage - h2.damage)
                .get();
        System.out.println(minDamageHero);
        System.out.println("返回伤害最高的那个英雄");

        Hero mxnDamageHero =
                heros
                        .stream()
                        .max((h1, h2) -> h1.damage - h2.damage)
                        .get();
        System.out.println(mxnDamageHero);

        System.out.println("流中数据的总数");
        long count = heros
                .stream()
                .count();
        System.out.println(count);

        System.out.println("第一个英雄");
        Hero firstHero =
                heros
                        .stream()
                        .findFirst()
                        .get();

        System.out.println(firstHero);

        //传统
        Collections.sort(heros, new Comparator<Hero>() {
            @Override
            public int compare(Hero o1, Hero o2) {
                return o2.hp - o1.hp;
            }
        });
        System.out.print("通过传统方式找出来的hp第三高的英雄名称是: ");
        System.out.println(heros.get(2).name);
        Collections.shuffle(heros);

        //Lambda
        System.out.print("通过Lambda方式找出来的hp第三高的英雄名称是: ");
        heros.sort((h1,h2) -> h2.hp - h1.hp);
        System.out.println(heros.get(2).name);
        Collections.shuffle(heros);

        //Aggregate
        System.out.print("通过聚合方式找出来的hp第三高的英雄名称是: ");
        /*Hero name =heros
                .stream()
                .sorted((h1,h2)->h2.hp-h1.hp)
                .skip(2)
                .findFirst()
                .get();*/

        String heroName = heros
                .stream()
                .sorted((h1,h2) -> h2.hp - h1.hp)
                .skip(2)
                .map(h -> h.name)
                .findFirst()
                .get();
        System.out.print(heroName);




    }
}
