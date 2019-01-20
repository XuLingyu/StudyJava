package javamiddle.c_map;

import static javabasic.C_ChracterAndString.string.StringQuestion.randomString;

public class MyHashCode {

    public static int hashcodeGenerator(String str){
        int hashcode =0;

        for(int i = 0; i < str.length(); i++){
            hashcode = ((int)str.charAt(i)) ^ (str.length()- i -1) + hashcode;
        }
        hashcode *= 23;
        hashcode = hashcode > 1999? hashcode%2000: hashcode;
        return hashcode;
    }
    public static void main(String[] args) {
        for(int i =0; i < 20; i++){
            System.out.println(hashcodeGenerator(randomString(5)));
        }
    }

}
