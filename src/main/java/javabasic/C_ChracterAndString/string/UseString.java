package javabasic.C_ChracterAndString.string;

public class UseString {

    public static void  main(String [] args){
        String sentence = "盖伦,在进行了连续8次击杀后,获得了超神 的称号";
        System.out.println("original sentence: " + sentence);
        System.out.println();

        char c = sentence.charAt(0);
        System.out.println("charAt(0): " + c);
        System.out.println();

        char[] cs = sentence.toCharArray(); //获取对应的字符数组
        System.out.println("toCharArray(): " + new String(cs));
        System.out.println();

        String subString = sentence.substring(0, 10);
        System.out.println("substring(0,10): " + subString);
        System.out.println();

        String subSentences[] = sentence.split(",");
        System.out.println("split(\",\"): " + subString);
        for (String sub : subSentences) {
            System.out.print(sub + "/");
        }
        System.out.println();

        System.out.println();
        System.out.println("字符串第一次出现的位置(sentence.indexOf(\"超神\")): " + sentence.indexOf("超神"));
        System.out.println();
        System.out.println("字符串/字符串最后出现的位置sentence.lastIndexOf(\"了\"): " + sentence.lastIndexOf("了"));
        System.out.println();
        System.out.println("从位置5开始，出现的第一次,的位置 sentence.indexOf(',',5): " + sentence.indexOf(',', 5));
        System.out.println();
        System.out.println("是否包含字符串\"击杀\"(sentence.contains(\"击杀\")): " + sentence.contains("击杀"));
        System.out.println();

        String temp = sentence.replaceAll(",", " one comma ");
        System.out.println("sentence.replaceAll(\",\", \" one comma \"): " + temp);
        System.out.println();

        temp = sentence.replaceFirst(",", "");//只替换第一个
        System.out.println("replaceFirst(\",\",\"\"): " + temp);
        System.out.println();
    }
}
