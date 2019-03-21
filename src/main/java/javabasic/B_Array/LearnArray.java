package javabasic.B_Array;

import java.util.Arrays;

public class LearnArray {
    public LearnArray() {
        System.out.println("construct method used");
    }

    private static int[] createRandomIntArray(int randomIntArrayLength){
        int a[] = new int[randomIntArrayLength];
        for (int i = 0; i< randomIntArrayLength ;i++){
            a[i] = (int) (Math.random() * 1000);
            System.out.println(a[i]);
        }
        return  a;
    }

    private static void arraySort(int[] a){
        System.out.println("排序之前 :");
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println("排序之后:");
        System.out.println(Arrays.toString(a));
    }

    private static void binarySearch(int[] a){
        System.out.println("数字 62出现的位置:"+Arrays.binarySearch(a, 62));
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] arg) {
        int[] a = LearnArray.createRandomIntArray(1000);
        LearnArray.arraySort(a);
        LearnArray.binarySearch(a);

    }
}
