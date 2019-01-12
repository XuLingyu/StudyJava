package javamiddle.c_map;

import java.util.HashMap;
import java.util.Hashtable;

public class MyHashtable {

    public static void main(String[] args) {

        //HashMap和Hashtable都实现了Map接口，都是键值对保存数据的方式

        HashMap<String,String> hashMap = new HashMap<String,String>();

        //HashMap可以用null作key,作value
        hashMap.put(null, "123");
        hashMap.put("123", null);


        Hashtable<String,String> hashtable = new Hashtable<String,String>();
        //Hashtable不能用null作key，不能用null作value
        //hashtable.put(null, "123");
        //public synchronized V put(K key, V value)
        hashtable.put("123", null);
        hashtable.containsKey("1");
        hashtable.containsValue("1");
        hashtable.contains(new Object());
    }

}


