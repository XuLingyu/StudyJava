package a_interview.datastructure.Sort;

import java.util.Arrays;

/*
冒泡法排序的思路：
第一步：从第一位开始，把相邻两位进行比较
如果发现前面的比后面的大，就把大的数据交换在后面，循环比较完毕后，最后一位就是最大的
第二步： 再来一次，只不过不用比较最后一位
以此类推

 */
public class

BubbleSort {

    private static int[] createRandomIntArray(int randomIntArrayLength){
        int a[] = new int[randomIntArrayLength];
        for (int i = 0; i< randomIntArrayLength ;i++){
            a[i] = (int) (Math.random() * 1000);
            System.out.println(a[i]);
        }
        return  a;
    }



    private static void sort(int [] intArray){
        //一共比较n-1轮
        for(int i = 0; i < intArray.length - 1; i++ ){
            //第一轮换N-1次（下标01换/12换/23换/n-1和n-2换）
            // 第二轮换N-2次（01换/12换/23换/n-2和n-3换）
            // 最后一轮换一次（01换）
            for(int j = 0; j < intArray.length - i - 1; j++){
                if(intArray[j] < intArray[j + 1]){
                    int temp = intArray[j+1];
                    intArray[j+1] = intArray[j];
                    intArray[j] =temp;
                }
            }
        }

        /*for(int i = 0; i < intArray.length; i++ ){
            System.out.println("intArray[" + i + "]" + intArray[i]);
        }
        for(int i: intArray ){
            System.out.println("intArray[" + i + "]" + intArray[i]);
        }*/
        System.out.println(Arrays.toString(intArray));

    }
    public static void main(String[] args) {
        int[] aaa = BubbleSort.createRandomIntArray(1000);
        BubbleSort.sort(aaa);

    }
}
