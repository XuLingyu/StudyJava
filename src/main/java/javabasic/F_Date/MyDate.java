package javabasic.F_Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class MyDate {

    public static void testDate(){
        // 当前时间
        Date d1 = new Date();
        System.out.println("当前时间:");
        System.out.println(d1);
        System.out.println();
        // 从1970年1月1日 早上8点0分0秒 开始经历的毫秒数
        Date d2 = new Date(5000);
        System.out.println("从1970年1月1日 早上8点0分0秒 开始经历了5秒的时间");
        System.out.println(d2.getTime());


        System.out.println("(new javabasic.F_Date()).getTime() == System.currentTimeMillis(): ");
        System.out.println((new Date()).getTime() == System.currentTimeMillis());
    }

    public static void testSimpleDateFormat(){
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy/MM/dd HH:mm:ss" );

        String str = "2016/1/5 12:12:12";

        try {
            Date d = sdf.parse(str);
            System.out.println(sdf.format(d));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /*
     *准备一个长度是9的日期数组
     *使用1970年-2000年之间的随机日期初始化该数组
     *按照这些日期的时间进行升序排序
     *比如 1988-1-21 12:33:22 就会排在 1978-4-21 19:07:23 前面，因为它的时间更小，虽然日期更大
     */
    public static void sortTimes() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        long oneDayTime = 24 * 3600 *1000;
        try {
            date = sdf.parse("2000-01-01 00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long millis = date.getTime();
        long[] time = new long[15];
        for (int i = 0; i < time.length; i++) {
            time[i] = (long)(Math.random()*millis);
        }
        System.out.println("得到的随机时间为：");
        for (int i = 0; i < time.length; i++) {
            String dateStringOver = sdf.format(time[i]);
            if (i != 0 && i % 3 == 0) {
                System.out.print('\n');
            }
            System.out.printf("%s\t", dateStringOver);
        }



      for(int i = 0; i < time.length -1; i++){

            for(int j = i + 1; j < time.length; j++){
                long temp = time[i];
                if(time[i]  > time[j]/* % oneDayTime*/){
                    time[i] = time[j];
                    time[j] = temp;
                }
            }
      }
        System.out.println();
        System.out.println("排序后的随机时间为：");
        for (int i = 0; i < time.length; i++) {
            String dateStringOver = sdf.format(time[i]);
            if (i != 0 && i % 3 == 0) {
                System.out.print('\n');
            }
            System.out.printf("%s\t", dateStringOver);
        }
    }

    public static void main(String[] args){
        testDate();
        testSimpleDateFormat();
        sortTimes();
    }
}
