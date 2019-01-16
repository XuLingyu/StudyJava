import javabasic.E_ExtendInterfaceAbstract.Garen;
import javabasic.E_ExtendInterfaceAbstract.Hero;

import java.util.ArrayList;
import java.util.List;

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

        String c = "aaa";
        String a = new String("aaa");
        String b = new String("aaa");

        System.out.println(a.equals(b));
        System.out.println(a == c);
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());
    }

}
