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
    char a= 's';
    String str ;
    char[] chars = {'a', 'b', 'c'} ;
    public void exchange(String str, char[] chars){
        str = "sad";
        chars[0] = 'g';

    }


    public static void main(String[] args){
        Test t = new Test();
        t.exchange("abc", new char[]{'a', 'b', 'c'});
        System.out.println(t.str);
        System.out.println(t.chars);
        System.out.println("asda" + 4);
    }




}
