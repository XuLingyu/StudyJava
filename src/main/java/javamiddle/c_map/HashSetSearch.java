package javamiddle.c_map;

import javabasic.C_ChracterAndString.string.StringQuestion;

import java.util.*;

public class HashSetSearch {


    public static void useHashSet(){
        HashSet<Integer> numbers = new HashSet<Integer>();

        for (int i = 0; i < 20; i++) {
            System.out.println(numbers.add(i));
        }

        for (int i = 0; i < 20; i++) {
            System.out.println(numbers.add(i));
        }


        //Set不提供get方法来获取指定位置的元素
        //numbers.get(0)

        //遍历Set可以采用迭代器iterator
        for (Iterator<Integer> iterator = numbers.iterator(); iterator.hasNext();) {
            Integer i = (Integer) iterator.next();
            System.out.print(i);
        }

        //或者采用增强型for循环
        for (Integer i : numbers) {
            System.out.print(i);
        }

    }

    public static void hashSetAddAlreadyExistElement(){
        String[] str = new String[1000];
        for (int i = 0; i < str.length; i++) {
            str[i] = StringQuestion.randomString(2);//这个是调用之前的方法
        }

        //显示字符串数组
        System.out.println(Arrays.toString(str));

        //用来进行判断是否重复的HashSet
        HashSet<String> stringHashSet = new HashSet<>();
        //保存重复的字符串
        List<String> list = new ArrayList<>();
        // 判断标志
        boolean flag  = true;
        for (int i = 0; i < str.length; i++) {
            //当set里面已存在元素的时候，会返回false
            flag = stringHashSet.add(str[i]);
            if (!flag){
                list.add(str[i]);
            }
        }


        Collections.sort(list);
        Collections.reverse(list);
        System.out.printf("总共有%d种重复字符串%n分别是：",list.size());
        System.out.println(list.toString());
    }

    public static void main(String[] args) {

        //useHashSet();
        hashSetAddAlreadyExistElement();

    }

}
