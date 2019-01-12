package javabasic.C_ChracterAndString;

public class StringConversion {

    public static void main(String[] args){

        //String to int
        String str = "1";
        int i1 = Integer.parseInt(str);
        System.out.println(i1);

        //int to String
        String str2 = String.valueOf(i1);
        System.out.println(str2);


        //float
        float f = 1.00f;
        String str3 = String.valueOf(f);
        System.out.println(str3);
        float f2 = Float.parseFloat(str3);
        System.out.println(f2);

        //char
        char c = 'a';
        String s = String.valueOf(c);
        // String s2 = Character.toString(c);
        // Character.toString 实际调用String.valueof(char c);
        System.out.println(s);




    }

}
