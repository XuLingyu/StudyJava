package javamiddle.c_map;

import javabasic.E_ExtendInterfaceAbstract.Garen;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTraversalWays {
    public static void main(String[] args){
        HashMap<Integer, Garen> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            int random = (int) (Math.random()*10000);
            map.put(random , new Garen( "hero-" + random ));
        }

        //第一种：普遍使用，二次取值
        System.out.println("通过Map.keySet遍历key和value：");
        for (Integer key : map.keySet()) {
            System.out.print("key= "+ key + " and value= " + map.get(key));
        }
        System.out.println();
        //第二种
        System.out.println("通过Map.entrySet使用iterator遍历key和value：");
        Iterator<Map.Entry<Integer, Garen>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Garen> entry = it.next();
            System.out.print("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
        System.out.println();

        //第三种：推荐，尤其是容量大时
        System.out.println("通过Map.entrySet遍历key和value");
        for (Map.Entry<Integer, Garen> entry : map.entrySet()) {
            System.out.print("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
        System.out.println();

        //第四种
        System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
        for (Garen v : map.values()) {
            System.out.print("value= " + v);
        }


    }

}
