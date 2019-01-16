package javabasic.D_StringStringBufferStringBuilder;

public class StringCompare {
    public static void main(String[] args){

        String a = new String("aaa");
        String b = new String("aaa");
        String c = "aaa";

        c += "bbb";
        c = "ccc";
        System.out.println(a.equals(b));
        System.out.println(a == c);
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());
    }
}
