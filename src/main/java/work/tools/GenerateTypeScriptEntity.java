package work.tools;

import java.util.ArrayList;
import java.util.List;

public class GenerateTypeScriptEntity {
    static void generate(String str){
        String[] lines = str.split(",");
        List<String[]> list = new ArrayList<>();
        //取头尾
        for (String line: lines) {
            String[] lineNotrim = line.trim().split(" ");
            String[] temp = {lineNotrim[0].replaceAll("`","").toLowerCase() + "? : string",
                    "// " + lineNotrim[lineNotrim.length -1].replaceAll("'","")};
            list.add(temp);
            System.out.println(temp[0] + temp[1] );
        }

    }

    public static void main(String[] args){
        generate("  `BSM` bigint(20) NOT NULL COMMENT '申诉信息',\n" +
                "  `BSMCODE` varchar(32) NOT NULL COMMENT '标识码CODE',\n" +
                "  `TSBSMCODE` varchar(32) NOT NULL COMMENT '投诉标识码CODE',\n" +
                "  `SSLY` varchar(50) DEFAULT NULL COMMENT '申诉来源',\n" +
                "  `SSSJ` datetime DEFAULT NULL COMMENT '申诉时间',\n" +
                "  `SSRY` varchar(50) DEFAULT NULL COMMENT '申诉人员',\n" +
                "  `FJBSMCODE` varchar(32) DEFAULT NULL COMMENT '附件标识码CODE',\n" +
                "  `GXSJ` date DEFAULT NULL,\n" +
                "  `SLQK` int(4) DEFAULT NULL COMMENT '受理情况 0新建 1提交 2已受理 3申诉成功 4已退回',\n" +
                "  `SLYJ` varchar(500) DEFAULT NULL COMMENT '受理意见',\n" +
                "  `SLSJ` datetime DEFAULT NULL COMMENT '受理时间',\n" +
                "  `WCSJ` datetime DEFAULT NULL COMMENT '完成时间',");
    }

}
