package Exams.string;

/**
 * @author xuly
 * @date 2021/2/21 15:20
 * @description 输入一个字符串，输出该字符串中对称的子字符串的最大长度
 * 比如输入字符串“12213”，由于该字符串里最长的对称子字符串是“1221”，因此输出为4.
 */
public class SymmetricString {

    public static int symmetryLength(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        int symLen = 1;
        char[] letter = str.toCharArray();
        int strLen = str.length();
        int curIndex = 1;
        while (curIndex > 0 && curIndex < strLen - 1) {
            int i = curIndex - 1;
            int j = curIndex + 1;
            while (i >= 0 && j <= (strLen - 1) && letter[i] == letter[j]) {
                i--;
                j++;
            }
            int newLen = j - i - 1;
            if (newLen > symLen) {
                symLen = newLen;
            }
            i = curIndex;
            j = curIndex + 1;
            while (i >= 0 && j <= (strLen - 1) && letter[i] == letter[j]) {
                i--;
                j++;
            }
            newLen = j - i - 1;
            if (newLen > symLen) {
                symLen = newLen;
            }
            curIndex++;
        }
        return symLen;
    }

    public static void main(String[] args) {
        System.out.println(symmetryLength("12213"));
    }
}
