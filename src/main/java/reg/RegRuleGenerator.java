package reg;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author:xuly
 * @Date: 2019/11/6 15:24
 * @Description:
 */
public class RegRuleGenerator {

    public static void printRuleNotBlankInfo(Map<String, String> fields) {
        fields.forEach((key, value) -> {
            System.out.println("case \"" + key + "\":");
            System.out.println("\t" + "checkDatas.forEach(xxx -> {");
            System.out.println("\t\t" + "list.add(CheckDataInfo.builder()");
            System.out.println("\t\t\t\t" + ".keyValue(xxx.getYwh())");
            System.out.println("\t\t\t\t" + ".keyName(keyName)");
            System.out.println("\t\t\t\t" + ".value(xxx.get" + key.toUpperCase().charAt(0) + key.substring(1, key.length()) + "())");
            System.out.println("\t\t\t\t" + ".name(\"" + value + "\")");
            System.out.println("\t\t\t\t" + ".valueId(rule.getTagCode())");
            System.out.println("\t\t\t\t" + ".build());");
            System.out.println("\t" + "});");
            System.out.println("\t" + "break;");
        }
        );
    }

    public static void printRuleRangeInfo(Map<String, String> fields) {
        fields.forEach((key, value) -> {
                    System.out.println("case \"" + key + "\":");
                    System.out.println("\t" + "checkDatas.forEach(xxx -> {");
                    System.out.println("\t\t" + "list.add(CheckDataInfo.builder()");
                    System.out.println("\t\t\t\t" + ".keyValue(xxx.getYwh())");
                    System.out.println("\t\t\t\t" + ".keyName(keyName)");
                    System.out.println("\t\t\t\t" + ".value(xxx.get" + key.toUpperCase().charAt(0) + key.substring(1, key.length()) + "())");
                    System.out.println("\t\t\t\t" + ".name(\"" + value + "\")");
                    System.out.println("\t\t\t\t" + ".rightValue(\"" + key.toUpperCase() + "\")");
                    System.out.println("\t\t\t\t" + ".valueId(rule.getTagCode())");
                    System.out.println("\t\t\t\t" + ".build());");
                    System.out.println("\t" + "});");
                    System.out.println("\t" + "break;");
                }
        );
    }

    public static void printRuleTagInfo(Map<String, String> fields) {
        fields.forEach((key, value) -> {
                    System.out.println("\"" + key + "【" + value + "】&\" + ");
                }
        );
    }
    
    public static void main(String[] args) {
        Map<String, String> fields = new LinkedHashMap<>();
        fields = new HashMap<>();

        fields.put("ygdjzl", "预告登记种类");
        fields.put("qszt", "权属状态");
        fields.put("djlx", "登记类型");
        fields.put("fkfs", "付款方式");

        //printRuleNotBlankInfo(fields);
        printRuleRangeInfo(fields);
        printRuleTagInfo(fields);
    }
}
