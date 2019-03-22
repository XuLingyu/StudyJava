package javabasic.D_StringStringBufferStringBuilder;

public class StringBufferQuestion {
    public static void strBufferMethod(){
        String str1 = "1234567890JQK";
        StringBuffer sb = new StringBuffer(str1); //根据str1创建一个StringBuffer对象
        System.out.println("sb.length(): " + sb.length()); //内容长度

        System.out.println("sb.capacity(): " + sb.capacity());//总空间


        sb.append("be light"); //在最后追加

        System.out.println(sb);

        sb.delete(4, 10);//删除4-10之间的字符

        System.out.println(sb);

        sb.insert(4, "insert");//在4这个位置插入 there

        System.out.println(sb);

        sb.reverse(); //反转

        System.out.println(sb);
    }

    public static void efficiencyCompare(){
        StringBuffer str = new StringBuffer();
        String str2 = "";
        double time = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++){
            str.append("aaaaaa");
        }

        System.out.println("使用字符串+的方式,链接10000次,耗时" + (System.currentTimeMillis() - time));

        time = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++){
            str2= str2 + "aaaaaa";
        }
        System.out.println("使用StringBuffer的append方式,链接10000次" + (System.currentTimeMillis() - time));
        System.out.println(str);
        System.out.println();
        System.out.println(str2);

    }



    public static void main(String[] args){
        strBufferMethod();
        efficiencyCompare();

    }
}
