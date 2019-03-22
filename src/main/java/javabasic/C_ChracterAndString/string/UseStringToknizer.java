package javabasic.C_ChracterAndString.string;

import java.util.Arrays;
import java.util.StringTokenizer;

//构造函数
//1. StringTokenizer(String str) ：构造一个用来解析str的StringTokenizer对象。
// java默认的分隔符是“空格”、“制表符(‘\t’)”、“换行符(‘\n’)”、“回车符(‘\r’)”。

//2. StringTokenizer(String str, String delim) ：
// 构造一个用来解析str的StringTokenizer对象，并提供一个指定的分隔符。

//3. StringTokenizer(String str, String delim, boolean returnDelims) ：
// 构造一个用来解析str的StringTokenizer对象，并提供一个指定的分隔符，同时，指定是否返回分隔符。


public class UseStringToknizer {


    //如果你把split和StringTokenizer作比较，区别的String.Split（）使用正则表达式，
    // 而StringTokenizer的只是使用逐字分裂的字符。
    public static void main(String[] args){

        String str = " wwlcome to the west world, enjoy yourself";
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        while(stringTokenizer.hasMoreElements()){
            System.out.println(stringTokenizer.nextElement());
        }

        while(stringTokenizer.hasMoreTokens()){
            System.out.println(stringTokenizer.nextToken());
        }


        StringTokenizer stringTokenizer2 = new StringTokenizer(str, ",", true);
        while(stringTokenizer2.hasMoreTokens()){
            System.out.println(stringTokenizer2.nextToken());
        }


        String[] strs = str.split(" ");
        Arrays.asList(strs).forEach(s -> System.out.println(s));
    }
}
