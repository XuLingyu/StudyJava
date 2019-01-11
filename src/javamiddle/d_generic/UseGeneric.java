package javamiddle.d_generic;

import javabasic.E_ExtendInterfaceAbstract.ADHero;
import javabasic.E_ExtendInterfaceAbstract.APHero;
import javabasic.E_ExtendInterfaceAbstract.Hero;

//d_generic 分三类：
//1. 泛型集合 List<Hero> list = new ArrayList<>(); 指定存放类型（包括子类）
//2. 泛型类 see GenericStack<T> or Node<T> 支持任何类型
//3. 通配符Wildcards 上边界限定通配符 <? extends Hero> 下边界限定通配符 <? super ADHero> see WildcardDemo


public class UseGeneric {

    public static void main(String[] args) {
        /*对于编译器来说，这是可以通过编译的，
        但是在运行时期，JVM 能够知道数组的实际类型是 ADHero[]，
        所以当其它对象加入数组的时候就会抛出异常*/
        //泛型设计的目的之一是要使这种运行时期的错误在编译期就能发现
        //之二不需要确定容器大小
        Hero[] heroes = new ADHero[10];
        heroes[0] = new ADHero();
        //RUNTIME ERROR
        heroes[1]= new APHero();
    }

}
