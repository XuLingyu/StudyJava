package javamiddle.a_exception;

/*
1.将可能抛出FileNotFoundException 文件不存在异常的代码放在try里
2.如果文件存在，就会顺序往下执行，并且不执行catch块中的代码
3. 如果文件不存在，try 里的代码会立即终止，程序流程会运行到对应的catch块中
4. e.printStackTrace(); 会打印出方法的调用痕迹，如此例，会打印出异常开始于TestException的第16行，这样就便于定位和分析到底哪里出了异常
*/


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaException {
    public static void outOfIndexExceptiuon() {
        int[] arr = new int[20];

        try {
            System.out.println(arr[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException");
            e.printStackTrace();
        } finally {
            System.out.println("it likes my love to you, no matter what happens ic can not be broken");
        }
    }


    public static void fileNotFoundException() {
        File f = new File("E:\\SSM\\StudyJava\\javabasic.iml");

        try {
            System.out.println("试图打开 E:\\SSM\\StudyJava\\javabasic.iml");
            new FileInputStream(f);
            System.out.println("成功打开");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date d = sdf.parse("2016-06-03");
        } catch (FileNotFoundException | ParseException e) {
            if (e instanceof FileNotFoundException)
                System.out.println("d:/LOL.exe不存在");
            if (e instanceof ParseException)
                System.out.println("日期格式解析错误");
            e.printStackTrace();
        } finally {
            System.out.println("it likes my love to you, no matter what happens ic can not be broken");
        }

    }

    private static void method1() {
        try {
            method2();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("open failed");
        }

    }

    /*
    throws与throw这两个关键字接近，不过意义不一样，有如下区别：
    1. throws 出现在方法声明上，而throw通常都出现在方法体内。
    2. throws 表示出现异常的一种可能性，并不一定会发生这些异常；throw则是抛出了异常，执行throw则一定抛出了某个异常对象。
     */
    private static void method2() throws FileNotFoundException {

        File f = new File("d:/LOL.exe");

        System.out.println("试图打开 d:/LOL.exe");
        new FileInputStream(f);
        System.out.println("成功打开");

    }

    public static void main(String[] args) {

        outOfIndexExceptiuon();
        fileNotFoundException();
        method1();

    }


}
