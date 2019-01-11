package javamiddle.c_collection;

import java.util.Arrays;
import java.util.List;

public class BinaryTreeEfficiency {


    public static void selectSort(int[] value){
        //一共比较n-1轮
        for (int i = 0; i < value.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < value.length; j++) {
                if (value[j] < value[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = value[minIndex];
            value[minIndex] = value[i];
            value[i] = temp;
        }
        System.out.println(Arrays.toString(value));
    }

    private static void bubbleSort(int [] intArray){
        //一共比较n-1轮
        for(int i = 0; i < intArray.length - 1; i++ ){
            //第一轮换N-1次（下标01换/12换/23换/n-1和n-2换）
            // 第二轮换N-2次（01换/12换/23换/n-2和n-3换）
            // 最后一轮换一次（01换）
            for(int j = 0; j < intArray.length - i - 1; j++){
                if(intArray[j] > intArray[j + 1]){
                    int temp = intArray[j+1];
                    intArray[j+1] = intArray[j];
                    intArray[j] =temp;
                }
            }
        }
        System.out.println(Arrays.toString(intArray));
    }

    public static int[] binaryTreeSort(int[] values) {
        Node root = new Node();
        for (int i = 0; i < values.length; i++) {
            root.add(values[i]);
        }
        List values1 = root.inOrderTraversal();
        for (int i = 0; i < values1.size(); i++) {
            values[i] = (int) values1.get(i);
        }
        System.out.println(Arrays.toString(values));
        return values;
    }

    public static void main(String[] args) {
        int[] values = new int[40000];
        for (int i = 0; i < values.length; i++) {
            values[i] = (int) (Math.random() * 100000);
        }
        int[] values1 = values.clone();
        int[] values2 = values.clone();
        int[] values3 = values.clone();
        Long t1 = System.currentTimeMillis();
        System.out.println("selectsort");
        selectSort(values1);
        Long t2 = System.currentTimeMillis();
        System.out.println("bubbleseort");
        bubbleSort(values2);
        Long t3 = System.currentTimeMillis();
        System.out.println("binarytree");
        binaryTreeSort(values3);
        Long t4 = System.currentTimeMillis();
        System.out.println("Arrys.sort");
        Arrays.sort(values);
        Long t5 = System.currentTimeMillis();
        System.out.println(Arrays.toString(values));
        System.out.println("比较结果是否相同:");
        System.out.println("选择排序用时:" + (t2 - t1) + "毫秒");
        System.out.println("冒泡排序用时:" + (t3 - t2) + "毫秒");
        System.out.println("二叉树排序用时:" + (t4 - t3) + "毫秒");
        System.out.println("快速排序用时:" + (t5 - t4) + "毫秒");
    }


}
