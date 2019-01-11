package javamiddle.a_exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/*
个人对 a_exception 的理解：
CheckedException：编译器在编译阶段检查出来可能出现的异常。
比如 Eclipse 编译器会提示：未处理的 a_exception。如果不处理，编译器，就不让你通过。
这体现了 Java 的设计哲学：没有完善错误处理的代码根本没有机会被执行。
RuntimeException：编译器事先不可预见的异常。
无论 CheckedException 还是 RuntimeException 都可以被 try...catch 捕获和处理。
异常一旦抛出，而不去捕获会导致异常向外抛出，导致该线程退出。
如果是单线程，即 main 主线程退出，导致程序结束。
 */
public class ExceptionType {

    /*
    可查异常： CheckedException 必须处理 要么try catch住,要么往外抛，谁调用，谁处理，如果不处理，编译器，就不让你通过
    比如 FileNotFoundException

    运行时异常RuntimeException指： 不是必须进行try catch的异常,但是它可以被捕捉。

    错误，是系统级别的异常。无法通过程序代码预先try catch住。所以错误无法被捕捉。
     */
    public static void checkedException(){
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

    public static void runtimeException(){
        //算术异常:ArithmeticException
        int k = 5/0;

        //下标越界异常：ArrayIndexOutOfBoundsException
        int j[] = new int[5];
        j[10] = 10;

        //空指针异常：NullPointerException
        String str = null;
        str.length();
    }

    public static void error(){
        StringBuffer sb =new StringBuffer();

        try{
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                sb.append('a');
            }
        }catch (OutOfMemoryError e){
            System.out.println("Out Of Memory Error");
            e.printStackTrace();
        }finally {
            System.out.println("The happiness of ITer");
        }

    }


    public static void main(String[] args){
        //checkedException();
        //runtimeException();
        error();
    }


}
