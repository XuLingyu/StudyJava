package javamiddle.c_map;

import java.util.LinkedList;

public class MyHashMap implements IHashMap {

    LinkedList<Entry>[] values = new LinkedList[2000];

    @Override
    public void put(String key, Object object) {
        // 拿到hashcode
        int hashcode = MyHashCode.hashcodeGenerator(key);
        // 找到对应的LinkedList
        LinkedList<Entry> list = values[hashcode];
        // 如果LinkedList是null，则创建一个LinkedList

        if (null == list) {
            list = new LinkedList<>();
        }

        // 判断该key是否已经有对应的键值对
        boolean found = false;
        for (Entry entry : list) {
            // 如果已经有了，则替换掉
            if (key.equals(entry.key)) {
                entry.value = object;
                found = true;
                break;
            }
        }

        // 如果没有已经存在的键值对，则创建新的键值对
        if (!found) {
            Entry entry = new Entry(key, object);
            list.add(entry);
        }

        values[hashcode] = list;
    }

    @Override
    public Object get(String key) {
        int hashcode = MyHashCode.hashcodeGenerator(key);

        // 找到hashcode对应的LinkedList
        LinkedList<Entry> list = values[hashcode];

        if (null == list)
            return null;

        Object result = null;
        // 挨个比较每个键值对的key，找到匹配的，返回其value
        for (Entry entry : list) {
            if (entry.key.equals(key)) {
                result = entry.value;
                break;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put("t", "坦克");
        map.put("adc", "物理");
        map.put("apc", "魔法");
        map.put("t", "坦克2");

        System.out.println(map.get("t"));

        // System.out.println(map);
    }

}
