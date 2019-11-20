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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    char a= 's';
    String str ;
    char[] chars = {'a', 'b', 'c'} ;
    public void exchange(String str, char[] chars){
        str = "sad";
        chars[0] = 'g';

    }

    static void regT(String str, String i) {
        String reg = "^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0," + i + "})?$";

        Pattern pattern=Pattern.compile(reg);
        Matcher match=pattern.matcher(str);
        System.out.print(match.matches());
    }

    public static void main(String[] args){

        /*regT("1.1112","3");*/
        Long a = null;
        String srt = String.valueOf(1L);
        String srt2 = String.valueOf(a);
                String srt3 = a.toString();
    }




}
