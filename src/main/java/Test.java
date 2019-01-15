import javabasic.E_ExtendInterfaceAbstract.Hero;
import javamiddle.a_exception.IndexIsOutofRangeException;

import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Vector;

public class Test  {

    static short s1 = 1;
    static int i1 =1;


    public Test() {

    }

    static int aaa (){
        try {
            return 1;
        }catch(Exception e) {

        }finally {
            return 2;
        }

    }

    static {
        System.out.println(s1);
    }
    public static void stackOverFlowMethod(){
        stackOverFlowMethod();
    }

    private static int x=100;
    public static void main(String[] args) {
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
      for(int i = 0; i < 10; i ++){
          heroes.add(new Hero("Hero " + i));
      }
      heroes.forEach(h-> System.out.println(h));
      Hero hero = heroes.get(0);
      hero.setHp(100);
      heroes.forEach(h-> System.out.println(h));
    }

}
