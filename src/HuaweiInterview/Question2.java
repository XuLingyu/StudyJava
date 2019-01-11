package HuaweiInterview;

import java.util.Arrays;
import java.util.Scanner;


//2019.8.1华为校招海外留学专场 题目二 ( 35.7%AC)
//给定一串字符，里面有些字符有连续出现的特点，请寻找这些连续出现字符中最长的串，
//如果最长字串有多个，请输出字符ASCII码最小的那一串
//输入：用cin输入一串字符， 如：aaabbbbbccccccccczzzzzzzzz
//输出：用cout输出其中最长的字串。如：ccccccccc
//说明：c和z都可以选，但是c比z的ASCII码小
public class Question2 {

    public static void afterSort(){
        Scanner scanner = new Scanner(System.in);
        String orignalString = scanner.nextLine();
        char[] orignalCharArray = orignalString.toCharArray();


        /*c_map<Character, Integer> map = new HashMap<>();
        Arrays.sort(orignalCharArray);
        System.out.println(orignalCharArray);*/

        char temp = orignalCharArray[0];
        char maxLengthChar = orignalCharArray[0];
        int maxLength = 0;
        int currentLength = 0;
        for(char c : orignalCharArray){
            if(temp == c ) {
                currentLength++;
            }else{
                currentLength = 1;
            }
            if(currentLength > maxLength){
                maxLength = currentLength;
                maxLengthChar = c;
            }else if(currentLength == maxLength && maxLengthChar > c){
                maxLengthChar = c;
            }
            temp = c;
        }
        
        System.out.println("maxLength:" + maxLength);
        System.out.println("maxLengthChar:" + maxLengthChar);
        char[] result = new char[maxLength];

        Arrays.fill(result, maxLengthChar);

        System.out.println("result" + Arrays.toString(result));

    }

}
