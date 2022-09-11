package leetcode.hot;

/**
 * LeetCode5.java
 * Description: https://leetcode.cn/problems/longest-palindromic-substring/
 *
 * @author Peng Shiquan
 * @date 2022/9/9
 */
public class LeetCode5 {
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        if (s.length() == 2) return s.charAt(0) == s.charAt(1) ? s : s.charAt(0) + "";
        int maxLength = 0;
        int start = 0;
        int end = 0;
        int length = s.length();
        for (int i = 1; i < length - 1; i++) {
            int left = i - 1;
            int right = i + 1;
            //先判断左边是不是一致
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                left--;
            }
            //再判断右边是不是一致
            while (right < length && s.charAt(right) == s.charAt(i)) {
                right++;
            }
            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            //求最大值即可
            //left和right是多了一步，需要各减一加一
            if (right - left - 1 > maxLength) {
                maxLength = right - left - 1;
                start = left + 1;
                //最好截取结果，右边下标不取，所以不需要减1
                end = right;
            }
        }
        return s.substring(start, end);
    }

    public static void main(String[] args) {
        System.err.println(new LeetCode5().longestPalindrome("ccc"));
    }
}
