package train;

/**
 * Test1.java
 * Description: 求两个字符串的最长公共子串
 *
 * @author Peng Shiquan
 * @date 2021/7/22
 */
public class Test1 {
    public static void main(String[] args) {
        String str1 = "abcdefg";
        String str2 = "adefgwgeweg";
        System.err.println(test(str1, str2));

    }


    /**
     * Description: 求两个字符串的最长公共子串
     *
     * @param str1
     * @param str2
     * @return java.lang.String
     * @Author Peng Shiquan
     * @Date 2021-07-22
     */
    public static String test(String str1, String str2) {
        if (str1 == null || str2 == null) return "";
        int lengthStr1 = str1.length();
        int lengthStr2 = str2.length();
        String tmp1 = lengthStr1 > lengthStr2 ? str2 : str1;
        String tmp2 = lengthStr1 >= lengthStr2 ? str1 : str2;
        int length = tmp1.length();
        for (int i = length - 1; i > 0; i--) {
            for (int j = 0; j + i < length; j++) {
                String result = tmp1.substring(j, j + i);
                if (tmp2.contains(result)) return result;
            }
        }
        return "";
    }
}
