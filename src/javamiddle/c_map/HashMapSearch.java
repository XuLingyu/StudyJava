package javamiddle.c_map;

import javabasic.E_ExtendInterfaceAbstract.Garen;
import javabasic.E_ExtendInterfaceAbstract.Hero;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * 准备一个ArrayList其中存放3000000(三百万个)Hero对象，其名称是随机的,格式是hero-[4位随机数]
 * hero-3229
 * hero-6232
 * hero-9365
 * @author Administrator
 *
 * 意思是用压入hero值到List中,
 */

public class HashMapSearch {

    public static void main(String[] args) {
        List<Hero> list = new ArrayList<>();
        HashMapSearch search = new HashMapSearch();
        for (int i = 0; i < 3000000; i++) {
            int random = (int) (Math.random()*10000);
            list.add(new Garen("hero-" + random ));
        }
        long start1 = System.currentTimeMillis();
        search.forEch(list);
        long end1 = System.currentTimeMillis();
        System.out.println("ArrayList used time: " + (end1 - start1));


        //名字作为key
        //名字相同的hero，放在一个List中，作为value
        HashMap<String,List<Hero>> heroMap =new HashMap();
        for (Hero h : list) {
            List<Hero> resultList = heroMap.get(h.getName());
            if(resultList == null){
                resultList = new ArrayList<>();
                heroMap.put(h.getName(), resultList);
            }
            resultList.add(h);
        }
        long start2 = System.currentTimeMillis();
        search.mapGetList(heroMap);
        long end2 = System.currentTimeMillis();
        System.out.println("Hashmap used time: " + (end2 - start2) );
    }

    //用for循环找出来
    public void forEch(List<Hero> list) {
        // TODO Auto-generated method stub
        List<Hero> heroList = new ArrayList<>();
        for (Hero hero : list) {
            if ("hero-5555".equals(hero.getName())) {
                heroList.add(hero);
            }
        }
        System.out.println(heroList.size());
    }

    //直接使用hashMap进行分
    public List<Hero> mapGetList(HashMap<String,List<Hero>> heroMap) {

        List<Hero> result = heroMap.get("hero-5555");
        System.out.println(result.size());
        return result;
    }

}
