import javabasic.E_ExtendInterfaceAbstract.Garen;
import javabasic.E_ExtendInterfaceAbstract.Hero;

import java.io.Externalizable;
import java.io.Serializable;
import java.io.SerializablePermission;
import java.nio.channels.Channel;
import java.nio.channels.Selector;
import java.sql.CallableStatement;
import java.util.*;

public class Test {

    static short s1 = 1;
    static int i1 = 1;

    static {
        System.out.println("static");
    }

    {
        System.out.println("notiong");
    }

    public Test() {
        System.out.println("construct");
    }

    static int aaa() {
        try {
            return 1;
        } catch (Exception e) {

        } finally {
            return 2;
        }

    }

    static {
        System.out.println(s1);
    }

    public static void stackOverFlowMethod() {
        stackOverFlowMethod();
    }

    private static int x = 100;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize run");
    }

    final public static void main(String[] args) {
        int[] ints = new int[10];
        System.out.println(s1 == i1);

      /* OutOfMemory

      List<UUID> list = new ArrayList<UUID>();
        while(true){
            list.add(UUID.randomUUID());
        }

        List<byte[]> byteList = new ArrayList<byte[]>();
        byteList.add(new byte[1000 * 1024 * 1024 *1024]);
        stackOverFlowMethod();*/

        List<Hero> heroes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            heroes.add(new Hero("Hero " + i));
        }
        heroes.forEach(h -> System.out.println(h));
        Hero hero = heroes.get(0);
        hero.setHp(100);
        heroes.forEach(h -> System.out.println(h));


       /* for(Iterator<Hero> it =  heroes.iterator();it.hasNext();){
            System.out.println(it.next());
            heroes.remove(8);
        }*/

       System.out.println(new Hero("aaa").hashCode());
       System.out.println(new Hero("aa").hashCode());



    }

}
