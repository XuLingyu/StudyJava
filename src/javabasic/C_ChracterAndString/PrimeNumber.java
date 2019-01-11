package javabasic.C_ChracterAndString;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {
    private static boolean isPrime(int i) {
        //在一般领域，对正整数n，如果用2到根号n之间的所有整数去除，均无法整除，则n为质数。
        for (int j = 2; j <= Math.sqrt(i); j++) {
            //余数为0 代表被整除
            if( 0==i % j)
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        List<Integer> primeList = new ArrayList<>();
        for(int i = 1; i < 10000; i++){

            if(isPrime(i))
                primeList.add(i);

        }

        for(Integer integer: primeList)
            System.out.println(integer);
    }
}
