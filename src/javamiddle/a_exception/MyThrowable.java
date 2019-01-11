package javamiddle.a_exception;


import java.io.File;
import java.io.FileInputStream;

//Throwable是类，Exception和Error都继承了该类
//所以在捕捉的时候，也可以使用Throwable进行捕捉
//如图： 异常分Error和Exception
//Exception里又分RuntimeException和C和乘客Exception。
public class MyThrowable {

    public static void method1() throws Throwable{
        File f=new File("f:/LOL.exe");
        new FileInputStream(f);
    }


    public static void main(String[] args){
        try{
            method1();
            //使用throwable进行异常
        }catch(Throwable t){
            System.out.println("看看这个异常是什么情况");
            t.printStackTrace();
        }
    }
}
