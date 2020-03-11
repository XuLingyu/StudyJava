package a_interview.datastructure.Sort;

/*
选择排序法：O(n^2)
把第一位和其他所有的进行比较，只要比第一位小的，就换到第一个位置来
比较完后，第一位就是最小的
然后再从第二位和剩余的其他所有进行比较，只要比第二位小，就换到第二个位置来
比较完后，第二位就是第二小的
以此类推
 */
public class SelectionSort {



    public static void sort(int[] intArray){
        //一共比较n-1轮
        for(int i = 0; i < intArray.length - 1; i++ ){
            //第一轮len-1，第二轮len -2，最后一轮 1
            for(int j = i + 1; j < intArray.length; j++){
                int temp;
                if(intArray[i] > intArray[j]) {
                    temp = intArray[i];
                    intArray[i] = intArray[j];
                    intArray[j] = temp;
                }
            }
        }
        for(int i = 0; i < intArray.length; i++ ){
            System.out.println("intArray[" + i + "]" + intArray[i]);
        }

    }
    public static void main(String[] args) {
        int[] a = {6, 5, 4, 1, 2, 3,6,6,5,1521,465,54,5,56,56,89};
        SelectionSort.sort(a);


    }
}
