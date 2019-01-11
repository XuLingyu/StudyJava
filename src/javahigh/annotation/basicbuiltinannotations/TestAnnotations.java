package javahigh.annotation.basicbuiltinannotations;

import java.util.ArrayList;
import java.util.List;

//@SuppressWarnings 有常见的值，分别对应如下意思
//1.deprecation：使用了不赞成使用的类或方法时的警告(使用@Deprecated使得编译器产生的警告)；
//2.unchecked：执行了未检查的转换时的警告，例如当使用集合时没有用泛型 (Generics) 来指定集合保存的类型; 关闭编译器警告
//3.fallthrough：当 Switch 程序块直接通往下一种情况而没有 Break 时的警告;
//4.path：在类路径、源文件路径等中有不存在的路径时的警告;
//5.serial：当在可序列化的类上缺少 serialVersionUID 定义时的警告;
//6.finally：任何 finally 子句不能正常完成时的警告;
//7.rawtypes 泛型类型未指明
//8.unused 引用定义了，但是没有被使用
//9.all：关于以上所有情况的警告。



public class TestAnnotations {


    @Override
    public String toString(){
        return "";
    }

    //过期
    @Deprecated
    public void hackMap(){

    }

    //忽略警告
    @SuppressWarnings("unused")
    public void test(){
        //@SuppressWarnings 有常见的值，分别对应如下意思
        //1.deprecation：使用了不赞成使用的类或方法时的警告(使用@Deprecated使得编译器产生的警告)；
        //2.unchecked：执行了未检查的转换时的警告，例如当使用集合时没有用泛型 (Generics) 来指定集合保存的类型; 关闭编译器警告
        //3.fallthrough：当 Switch 程序块直接通往下一种情况而没有 Break 时的警告;
        //4.path：在类路径、源文件路径等中有不存在的路径时的警告;
        //5.serial：当在可序列化的类上缺少 serialVersionUID 定义时的警告;
        //6.finally：任何 finally 子句不能正常完成时的警告;
        //7.rawtypes 泛型类型未指明
        //8.unused 引用定义了，但是没有被使用
        //9.all：关于以上所有情况的警告。
        List heros = new ArrayList();
    }

    //安全的可变参数
    @SafeVarargs
    public static <T> T getFirstOne(T... elements) {
        //@SafeVarargs 这是1.7 之后新加入的基本注解.当使用可变数量的参数的时候，
        // 而参数的类型又是泛型T的话，就会出现警告。 这个时候，就使用@SafeVarargs来去掉这个警告
        //
        //@SafeVarargs注解只能用在参数长度可变的方法或构造方法上，且方法必须声明为static或final，
        // 否则会出现编译错误。一个方法使用@SafeVarargs注解的前提是，
        // 开发人员必须确保这个方法的实现中对泛型类型参数的处理不会引发类型安全问题。
        return elements.length > 0 ? elements[0] : null;
    }

    public static void main(String[] args) {
        //开地图这个方法hackMap，被注解为过期，在调用的时候，就会受到提示
        new TestAnnotations().hackMap();


    }
}
