package HuaweiInterview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//2019.8.1华为校招海外留学专场 题目一
//找出输入字符串中的重复字符，再根据ascii把重复的字符从小到大排序
//输入：一个长度不超过100的字符串，如：ABCABCdd
//输出：排序后的字符串，如：ABCd
public class Question1 {

    public static String afterSort(){
        Scanner scanner = new Scanner(System.in);
        String orignalString = scanner.nextLine();
        char[] orignalCharArray =  orignalString.toCharArray();
        char[] afterSortCharArray;
        Map<Character, Integer> map = new HashMap<>();
        StringBuffer stringBuffer = new StringBuffer();

        System.out.println("Orignal Input String: " + orignalString);
        System.out.println("orignal char array: " + Arrays.toString(orignalCharArray));

        //遍历char[]，计数到key对应的value
        for (char c : orignalCharArray){
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else{
                map.put(c,1);
            }
        }

        //重复的字符串储存到StringBuffer
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            if(entry.getValue() > 1){
                stringBuffer.append(entry.getKey());
            }
        }
        System.out.println("Stringbuffer: " + stringBuffer);
        //用Array.sort排序
        //afterSortCharArray = (stringBuffer.toString()).toCharArray();
        afterSortCharArray = (new String(stringBuffer)).toCharArray();
        Arrays.sort(afterSortCharArray);
        System.out.println(afterSortCharArray);
        return  new String(afterSortCharArray);
    }


}
