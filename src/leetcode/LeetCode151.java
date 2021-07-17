package leetcode;

import java.math.BigDecimal;

/**
 * LeetCode151.java
 * Description: 翻转字符串
 *
 * @author Peng Shiquan
 * @date 2021/7/14
 */
public class LeetCode151 {
    public static void main(String[] args) {
        System.err.println(reverseWords("a good   example"));
    }

    public static String reverseWords(String s) {
        String[] strings = s.trim().split(" ");
        int length = strings.length;
        if (length == 0) return "";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = length - 1; i >= 0; i--) {
            if (strings[i].equals("")) continue;
            stringBuilder.append(strings[i] + " ");
        }
        BigDecimal bigDecimal = new BigDecimal("11");
        bigDecimal.multiply(new BigDecimal("222"));

        return stringBuilder.toString().trim();
    }
}
