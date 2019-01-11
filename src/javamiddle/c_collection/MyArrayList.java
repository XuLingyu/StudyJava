package javamiddle.c_collection;

import javabasic.E_ExtendInterfaceAbstract.Garen;
import javabasic.E_ExtendInterfaceAbstract.Hero;

import java.util.ArrayList;

public class MyArrayList {

    public static void main(String args[]) {
        ArrayList heroes = new ArrayList<>();

        // 把5个对象加入到ArrayList中 add(E e)
        for (int i = 0; i < 5; i++) {
            heroes.add(new Garen( "hero " + i));
        }
        System.out.println(heroes);

        // 在指定位置增加对象add(int index, E element)
        Garen specialHero = new Garen("special hero");
        heroes.add(3, specialHero);

        // 判断一个对象是否在容器中 contains(Object o)
        // 判断标准： 是否是同一个对象，而不是name是否相同
        System.out.print("虽然一个新的对象名字也叫specialHero，contains的返回是:");
        System.out.println(heroes.contains(new Garen( "special hero")));
        System.out.print("而对specialHero的判断，contains的返回是:");
        System.out.println(heroes.contains(specialHero));
        System.out.println(heroes.toString());

        //获取指定位置的对象get(int index)
        System.out.println(heroes.get(3));
        //如果超出了范围，依然会报错
        //System.out.println(garens.get(6));

        //移除制定位置的对象remove(int index)
        heroes.remove(2);
        System.out.println("删除下标是2的对象");
        System.out.println(heroes);

        //获取指定对象的索引indexOf(Object o)
        System.out.println("specialHero所处的位置:" + heroes.indexOf(specialHero));
        System.out.println("新的英雄，但是名字是\"hero 1\"所处的位置:" + heroes.indexOf(new Garen( "special hero")));

        //替换指定位置对象set(int index, E element)
        System.out.println("把下标是0的元素，替换为specialHero");
        heroes.set(0, specialHero);
        System.out.println(heroes);

        //获取ArrayList大小
        System.out.println("获取ArrayList的大小：" + heroes.size());


        //如果就是要判断集合里是否存在一个 name等于 "special hero"的对象
        //heroes.get(i) 返回的是Object
        for(Object o: heroes){
            if(((Hero)o).getName().equals("special hero")){
                System.out.print("i am finding");
                System.out.println("yes we cat a hero named special hero");
                break;
            }
        }

        //转换为数组
        /*这个代码的用处是把一个集合ArrayList转换为对应类型的数组。toArray方法返回一个数组。
        同时toArray方法又需要一个数组类型作为参数，这样它才知道应该转换为什么样类型的数组。
        默认情况下toArray返回的类型是Object[]数组，而这里我们需要的是一个Garen[]数组，
        所以需要把Object[]数组强制转换为一个Garen[]数组 所以在方法前会有(Garen[])进行强转。*/
        //Garen[] param= new Garen[]{};
        //Garen garens[];
        //garens = (Garen[]) heroes.toArray(param);
        Garen[] garens = (Garen[]) heroes.toArray(new Garen[]{});
        for(Garen garen: garens)
            System.out.println(garen);

        //clear 清空一个ArrayList
        System.out.println("使用clear清空");
        heroes.clear();
        System.out.println("ArrayList heros:\t" + heroes);
    }
}
