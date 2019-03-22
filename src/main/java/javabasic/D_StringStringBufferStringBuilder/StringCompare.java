package javabasic.D_StringStringBufferStringBuilder;

public class StringCompare {

    public static void efficiencyCompare(){
        StringBuffer str = new StringBuffer();
        String str2 = "";
        StringBuilder str3 = new StringBuilder();
        double time = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++){
            str.append("aaaaaa");
        }

        System.out.println(" 使用字符串StringBuffer的方式,链接1000000次,耗时" + str.length() + "  "+ (System.currentTimeMillis() - time));

        time = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++){
            str2= str2 + " aaaaaa";
        }
        System.out.println(" 使用+的append方式,链接10000次" + str.length() + "  "+ (System.currentTimeMillis() - time));

        time = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++){
            str3.append(" aaaaaa");
        }
        System.out.println(" 使用StringBuilder的append方式,链接1000000次" + str.length() + "  "+ (System.currentTimeMillis() - time));


    }

    public static void main(String[] args){
        efficiencyCompare();

        String a = new String("aaa");
        String b = new String("aaa");
        String c = "aaa";



        System.out.println(a.equals(b));
        System.out.println(a == b);
        System.out.println(a == c);

    }
}
