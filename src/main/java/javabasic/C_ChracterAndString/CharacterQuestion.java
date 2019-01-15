package javabasic.C_ChracterAndString;

import java.util.Scanner;

public class CharacterQuestion {


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] cs = str.toCharArray();
        for (int i = 0;i < cs.length;i++) {
            if ((Character.isLetter(cs[i]) && Character.isUpperCase(cs[i])) || Character.isDigit(cs[i])) {
                System.out.print(cs[i]);
            }
        }

        System.out.println(PrimeNumber.a);


    }


    }



