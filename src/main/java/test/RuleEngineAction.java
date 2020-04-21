package test;


import javax.xml.soap.SOAPPart;

/**
 * @Author:xuly
 * @Date: 2020/4/2 17:54
 * @Description:
 */
public class RuleEngineAction {

     static java.lang.Boolean isDecimalInRange(java.lang.Object arg0, java.lang.Integer arg1){
        if(org.springframework.util.StringUtils.isEmpty(arg0) || arg1 == null){
            return true;
        }
        if(arg0 instanceof java.lang.Number){
            java.lang.String str = arg0.toString();
            java.lang.Integer decimalLen = str.length() - str.lastIndexOf(".") - 1;
            if (arg1.equals(decimalLen)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
         System.out.println(isDecimalInRange("606.3969", 4));
    }
}
