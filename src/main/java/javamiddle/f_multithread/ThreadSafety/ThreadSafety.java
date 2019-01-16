package javamiddle.f_multithread.ThreadSafety;

import java.util.*;


public class ThreadSafety {

    public static void hashmapVSHashtable(){
        //HashMap和Hashtable都实现了Map接口，都是键值对保存数据的方式
        //区别1：
        //HashMap可以存放 null
        //Hashtable不能存放null
        //区别2：
        //HashMap不是线程安全的类
        //Hashtable是线程安全的类

        HashMap<String,String> hashMap = new HashMap<String,String>();
        hashMap.put(null, "123");
        hashMap.put("123", null);
        //c_map Collections.synchronizedMap(c_map m)
        Map<String, String> map = Collections.synchronizedMap(hashMap);

        Hashtable<String,String> hashtable = new Hashtable<String,String>();
        hashtable.put("123", null);
        hashtable.containsKey("1");
        hashtable.containsValue("1");
    }

    public static void stringBufferVSStringBuilder(){
        //D_StringStringBufferStringBuilder 是线程安全的
        //StringBuilder 是非线程安全的
        //
        //所以当进行大量字符串拼接操作的时候，如果是单线程就用StringBuilder会更快些，
        // 如果是多线程，就需要用StringBuffer 保证数据的安全性

        //非线程安全的为什么会比线程安全的 快？ 因为不需要同步嘛，省略了些时间
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("s");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("a");

    }

    public static void arrayListVSVector(){
        //他们的区别也在于，Vector是线程安全的类，而ArrayList是非线程安全的。

        //public class Vector<E> extends AbstractList<E>
        //    implements List<E>, RandomAccess, Cloneable, java.io.Serializable
        Vector<String> vector = new Vector<>();
        vector.add("Asd");

        //public class ArrayList<E> extends AbstractList<E>
        //        implements List<E>, RandomAccess, Cloneable, java.io.Serializable
        ArrayList<String> arrayList = new ArrayList<>();
        vector.add("Asd");
        Collections.synchronizedList(arrayList);
        //Collections.synchronizedCollection(arrayList);
        //Collections.synchronizedCollection(vector);
    }


    public static void main(String[] args){

    }
}
