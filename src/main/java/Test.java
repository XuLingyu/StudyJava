import javabasic.E_ExtendInterfaceAbstract.Garen;
import javabasic.E_ExtendInterfaceAbstract.Hero;

import java.io.Externalizable;
import java.io.Serializable;
import java.io.SerializablePermission;
import java.math.BigDecimal;
import java.nio.channels.Channel;
import java.nio.channels.Selector;
import java.sql.CallableStatement;
import java.util.*;

public class Test {

    public static void aaa(int total){
        total++;
    }

    public static void main(String[] args){
        Integer a = 1;
        aaa(a);
        System.out.println(a);

        int[] ints = {1,2,3,4,5};

        //源码是内部类 不提供list接口方法这是 ArrayList 的源码,
        // 从这里我们可以看出,此 ArrayList 不是 java.util.ArrayList，他是 Arrays 的内部类。
        // 该内部类提供了 size、toArray、get、set、indexOf、contains 方法，而像 add、remove
        // 等改变 list 结果的方法从 AbstractList 父类继承过来，同时这些方法也比较奇葩，
        // 它直接抛出 UnsupportedOperationException 异常：
        List list = Arrays.asList(ints);
        System.out.println("list'size：" + list.size());
        System.out.println("list 的类型:" + list.get(0).getClass());
        System.out.println("list.get(0) == ints：" + list.get(0).equals(ints));
        // UnsupportedOperationException
        // list.add(6);


        Float aaa = 123000.8f;
        Float b = 123000.5f;

        BigDecimal b1 = new BigDecimal(Float.toString(aaa));
        BigDecimal b2 = new BigDecimal(Float.toString(b));
        float ss = b1.subtract(b2).floatValue();
        System.out.println(ss);

        System.out.println(testfinally());

    }

    private static boolean testfinally() {
        try{
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return false;
        }
    }


}
