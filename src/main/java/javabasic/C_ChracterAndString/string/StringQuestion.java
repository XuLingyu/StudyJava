package javabasic.C_ChracterAndString.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StringQuestion {

    public static void basicStringMethodsExsamples() {

    }

    /***
     * 字符串首字母大写转换
     */
    public static void stringTest1() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("字符串首字母大写转换");
        String[] strArr = str.split(" ");
        for (int i = 0; i < strArr.length; i++)
            if (Character.isLowerCase(strArr[i].charAt(0)))
                strArr[i] = Character.toUpperCase(strArr[i].charAt(0)) + strArr[i].substring(1);

        for (String s : strArr)
            System.out.print(s + " ");
    }

    public static int generateRandomNumber() {
        int i = (int) (Math.random() * 75 + 48);
        while ((i > 57 && i < 65) || (i > 90 && i < 97)) {
            i = (int) (Math.random() * 75 + 48);
        }
        return i;
    }

    public static void stringIsImmutable() {
        /* String 是 immutable
        str str2 指向同一个对象
        不能增加长度
        不能减少长度
        不能插入字符
        不能删除字符
        不能修改字符*/

        String str = "asdasd";
        String str2 = "asdasd";
        System.out.println(str == str2);

        String a = "ABCabc";
        System.out.println("a = " + a);
        // a只是一个引用， 不是真正的字符串对象，在调用a.replace('A', 'a')时，
        // 方法内部创建了一个新的String对象，并把这个心的对象重新赋给了引用a。
        a = a.replace('A', 'a');
        System.out.println("a = " + a);

        String ss = "123456";
        System.out.println("ss = " + ss);
        ss.replace('1', '0');
        System.out.println("ss = " + ss);
    }

    //创建一个长度是5的随机字符串，随机字符有可能是数字，大写字母或者小写字母
    public static String randomString(int length) {
        char[] c = new char[length];
        for (int i = 0; i < c.length; i++) {
            c[i] = (char) generateRandomNumber();
        }
        String str = new String(c);
        return str;
    }


    /*创建一个长度是8的字符串数组

      使用8个长度是5的随机字符串初始化这个数组

      对这个数组进行排序，按照每个字符串的首字母排序(无视大小写)*/
    public static void sortRandomArrayString() {
        String[] arrayStr = new String[20];
        for (int i = 0; i < arrayStr.length; i++) {
            arrayStr[i] = randomString(5);
        }

        System.out.println(Arrays.asList(arrayStr));

        char[] charArray = new char[20];
        for (int i = 0; i < charArray.length; i++) {
            char firstChar = arrayStr[i].charAt(0);
            if (Character.isUpperCase(firstChar)) {
                charArray[i] = Character.toLowerCase(firstChar);
            } else {
                charArray[i] = arrayStr[i].charAt(0);
            }
        }

        System.out.println(new String(charArray));

        //selection
        String tempString;
        char tempChar;
        for (int i = 0; i < arrayStr.length - 1; i++) {
            //第一轮len-1，第二轮len -2，最后一轮 1
            for (int j = i + 1; j < arrayStr.length; j++) {

                if (charArray[i] > charArray[j]) {

                    //首字符数组换位置
                    tempChar = charArray[i];
                    charArray[i] = charArray[j];
                    charArray[j] = tempChar;

                    //字符串换位置
                    tempString = arrayStr[i];
                    arrayStr[i] = arrayStr[j];
                    arrayStr[j] = tempString;
                }
            }
        }
        System.out.println(Arrays.asList(arrayStr));
    }

    /*1. 生成一个长度是3的随机字符串，把这个字符串作为当做密码

      2. 使用穷举法生成长度是3个字符串，匹配上述生成的密码

      要求： 分别使用多层for循环 和 递归解决上述问题*/

    public static void bruteForceExhaust() {
        String password = randomString(3);
        System.out.println("The Password is " + password);

        char[] guess = new char[password.length()];
        outloop:
        for (int i = '0'; i < 'z'; i++) {
            for (int j = '0'; j < 'z'; j++) {
                for (int k = '0'; k < 'z'; k++) {
                    guess[0] = (char) i;
                    guess[1] = (char) j;
                    guess[2] = (char) k;
                    String guessWord = new String(guess);
                    if (guessWord.equals(password)) {
                        System.out.println("找到了，密码是：" + guessWord);
                        break outloop;
                    }
                }
            }
        }
    }

    public static void bruteForceRecursion() {
        String password = randomString(3);
        System.out.println("The Password is " + password);
    }

    public static void countStringArray() {
        String[] strArr = new String[1000];
        Set<String> container = new HashSet<>();


        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = randomString(2).toUpperCase();
            if(!container.contains(strArr[i])){
                container.add(strArr[i]);
            }

        }

        System.out.print(container.size());



    }

    public static void main(String args[]) {
    /*    System.out.println("First letter of string[] to uppercase");
        stringTest1();

        System.out.println("String is Immutable:");
        stringIsImmutable();

        System.out.println("Geneate a string that contains only Uppercase and lowercase letters, number ");
        System.out.println(randomString(5));

        System.out.println("a_interview.datastructure.Sort one array string depends on first char of String");
        sortRandomArrayString();

        System.out.println("Use Brute force for decryption");
        bruteForceExhaust();
        bruteForceRecursion();*/

        countStringArray();

    }


}
