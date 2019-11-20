/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package expressionparse;

/**
 *  字符串工具类
 *
 */
public class StringUtils {



    /**
     * 判断字符串是否为空
     *
     * @param s
     * @return
     */
    public static boolean isNull(String s) {
        return null == s || "null".equalsIgnoreCase(s) || "".equals(s) || "undefined".equals(s);
    }

    /**
     * 判断字符串不为空
     * @param s
     * @return
     */
    public static boolean isNotNull(String s) {
        return !isNull(s);
    }






    static final char CN_CHAR_START = '\u4e00';
    static final char CN_CHAR_END = '\u9fa5';

    /**
     * 是否包含中文字符
     *
     * @param str 要判断的字符串
     * @return 是否包含中文字符
     */
    public static boolean containsChineseChar(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= CN_CHAR_START && chars[i] <= CN_CHAR_END) return true;
        }
        return false;
    }

    /**
     * 判断一个对象是否为boolean类型,包括字符串中的true和false
     *
     * @param obj 要判断的对象
     * @return 是否是一个boolean类型
     */
    public static boolean isBoolean(Object obj) {
        if (obj instanceof Boolean) return true;
        String strVal = String.valueOf(obj);
        return "true".equalsIgnoreCase(strVal) || "false".equalsIgnoreCase(strVal);
    }


    private static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }



    /**
     * 字符串满足一定长度，不够长度左边边补齐0
     *
     * @param str
     * @param strLength
     * @return
     */
    public static String addZeroForNumLeft(String str, int strLength) {
        int strLen = str.length();
        StringBuffer sb = null;
        while (strLen < strLength) {
            sb = new StringBuffer();
            sb.append("0").append(str);// 左补0
            str = sb.toString();
            strLen = str.length();
        }
        return str;
    }

    /**
     * 字符串满足一定长度，不够长度右边边补齐0
     *
     * @param str
     * @param strLength
     * @return
     */
    public static String addZeroForNumRight(String str, int strLength) {
        int strLen = str.length();
        StringBuffer sb = null;
        while (strLen < strLength) {
            sb = new StringBuffer();
            sb.append(str).append("0");//右补0
            str = sb.toString();
            strLen = str.length();
        }
        return str;
    }


    public static String isNullToStr(String str, String rep) {
        return StringUtils.isNull(str) ? rep : str;
    }

    public static String isNullToStr(String str) {
        return "";
    }

    public static boolean isNullOrEmpty(Object obj) {
        return obj == null || "".equals(obj.toString());
    }
}
