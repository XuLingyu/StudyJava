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

        fields.put("zddm", "宗地代码");
        fields.put("bdcdyh", "不动产单元号");
        fields.put("zdtzm", "宗地特征码");
        fields.put("zl", "坐落");
        fields.put("zdmj", "宗地面积");
        fields.put("yt", "用途");
        fields.put("dj", "等级");
        fields.put("jg", "价格");
        fields.put("qllx", "权利类型");
        fields.put("qlxz", "权利性质");
        fields.put("qlsdfs", "权利设定方式");
        fields.put("rjl", "容积率");
        fields.put("jzmd", "建筑密度");
        fields.put("jzxg", "建筑限高");
        fields.put("zdszd", "宗地四至-东");
        fields.put("zdszn", "宗地四至-南");
        fields.put("zdszx", "宗地四至-西");
        fields.put("zdszb", "宗地四至-北");
        fields.put("tfh", "图幅号");
        fields.put("tdsyqr", "土地所有权人");
        fields.put("jzmj", "建筑面积");
        fields.put("jzwzdmj", "建筑物占地面积");
        fields.put("qxdm", "区县代码");
        fields.put("zdxz", "宗地性质");
        fields.put("lhl", "绿化率");
        fields.put("sjyt", "实际用途");
        fields.put("syqqssj", "使用权起始时间");
        fields.put("syqjssj", "使用权结束时间");

        //printRuleNotBlankInfo(fields);
        printRuleNotBlankInfo(fields);
        printRuleTagInfo(fields);
    }
}
