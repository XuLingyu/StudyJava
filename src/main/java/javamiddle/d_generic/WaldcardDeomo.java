package javamiddle.d_generic;

import javabasic.E_ExtendInterfaceAbstract.*;

import java.util.ArrayList;

/*通配符的使用可以对泛型参数做出某些限制，使代码更安全，对于上边界和下边界限定的通配符总结如下：
使用 List<? extends C> list 这种形式，表示 list 可以引用一个 ArrayList
( 或者其它 List 的 子类 ) 的对象，这个对象包含的元素类型是 C 的子类型 ( 包含 C 本身）的一种。
使用 List<? super C> list 这种形式，表示 list 可以引用一个 ArrayList
( 或者其它 List 的 子类 ) 的对象，这个对象包含的元素就类型是 C 的超类型 ( 包含 C 本身 ) 的一种。*/

/*
 **如果希望只取出，不插入，就使用? extends Hero
 **如果希望只插入，不取出，就使用? super Hero
 **如果希望，又能插入，又能取出，就不要用通配符？
 */
public class WaldcardDeomo {





    public static void extendsBala() {
        ArrayList<APHero> apHeroList = new ArrayList<>();
        ArrayList<ADHero> adHeroList = new ArrayList<>();
        ArrayList<Hero> heroList = new ArrayList<>();
        apHeroList.add(new APHero());
        adHeroList.add(new ADHero());
        heroList.add(new Hero() {
        });

        ArrayList<? extends Hero> list = apHeroList;
        list = adHeroList;
        list = heroList;

        //? extends Hero 表示这是一个Hero泛型的子类泛型
        //heroList 的泛型可以是Hero
        //heroList 的泛型可以使APHero
        //heroList 的泛型可以使ADHero

        //!!!从heroList取出来的对象，一定是可以转型成Hero的!!!

        Hero h = heroList.get(0);

        //!!!但是，不能往里面放东西!!!
        //heroList.add(new ADHero()); //编译错误，因为heroList的泛型 有可能是APHero

    }
    public static void extendsExample(ArrayList<? extends Hero> list){
        for (Hero o : list) {
            System.out.println(o.name);
        }
    }

    public static void superBala() {
        ArrayList<? super Hero> heroList = new ArrayList<Object>();

        //? super Hero 表示 heroList的泛型是Hero或者其父类泛型

        //heroList 的泛型可以是Hero
        //heroList 的泛型可以是Object

        //所以就可以插入Hero
        heroList.add(new Garen());
        //也可以插入Hero的子类
        heroList.add(new APHero());
        heroList.add(new ADHero());

        //但是，不能从里面取数据出来,因为其泛型可能是Object,而Object是强转Hero会失败
        //Hero h= heroList.get(0);
    }

    public static void genericSuper() {
        ArrayList<APHero> apHeroList = new ArrayList<APHero>();

        //?泛型通配符，表示任意泛型
        ArrayList<?> generalList = apHeroList;

        //?的缺陷1： 既然?代表任意泛型，那么换句话说，你就不知道这个容器里面是什么类型
        //所以只能以Object的形式取出来
        Object o = generalList.get(0);

        //?的缺陷2： 既然?代表任意泛型，那么既有可能是Hero,也有可能是Item
        //所以，放哪种对象进去，都有风险，结果就什么什么类型的对象，都不能放进去
        //generalList.add(new Item());
        //generalList.add(new Hero());
        //generalList.add(new APHero());
    }

    public static void main(String[] args) {
        ArrayList<Hero> hs = new ArrayList<>();
        hs.add(new Garen("a"));
        ArrayList<APHero> aphs = new ArrayList<>();
        aphs.add(new APHero("b"));
        ArrayList<ADHero> adhs = new ArrayList<>();
        adhs.add(new ADHero("c"));
        extendsExample(hs);
        extendsExample(aphs);
        extendsExample(adhs);




    }
}
