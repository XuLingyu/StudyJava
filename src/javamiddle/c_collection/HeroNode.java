package javamiddle.c_collection;

import javabasic.E_ExtendInterfaceAbstract.Garen;
import javabasic.E_ExtendInterfaceAbstract.Hero;

import java.util.ArrayList;
import java.util.List;

public class HeroNode {
    public HeroNode leftHero;

    public HeroNode rightHero;

    // 声明为Hero类型
    public Hero value;

    public void add(Hero v) {

        if (null == value)
            value = v;

        else {

            // 如果新英雄血量，比本节点大，就放在左边
            if (v.hp > value.hp) {
                if (null == leftHero)
                    leftHero = new HeroNode();
                leftHero.add(v);
            } else {
                if (null == rightHero)
                    rightHero = new HeroNode();
                rightHero.add(v);
            }

        }

    }

    public List<Object> inoder() {
        List<Object> values = new ArrayList<>();

        if (null != leftHero)
            values.addAll(leftHero.inoder());

        values.add(value);

        if (null != rightHero)

            values.addAll(rightHero.inoder());

        return values;
    }

    public static void main(String[] args) {

        List<Hero> hs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Hero h = new Garen();
            h.name = "hero " + i;
            h.hp = (int) (Math.random() * 900 + 100); // 100-1000的随机血量
            hs.add(h);
        }
        System.out.println("初始化10个Hero");
        System.out.println(hs);

        HeroNode heroTree = new HeroNode();
        for (Hero hero : hs) {
            heroTree.add(hero);
        }
        System.out.println("根据血量倒排序后的Hero");
        List<Object> treeSortedHeros = heroTree.inoder();
        System.out.println(treeSortedHeros);

    }

}
