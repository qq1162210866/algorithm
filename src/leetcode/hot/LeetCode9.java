package leetcode.hot;

/**
 * LeetCode9.java
 * Description: https://leetcode.cn/problems/palindrome-number/
 *
 * @author Peng Shiquan
 * @date 2022/8/8
 */
public class LeetCode9 {
    public static void main(String[] args) {
        System.err.println(new LeetCode9().isPalindrome(232));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        String tmp = x + "";
        char[] chars = tmp.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            if (chars[i] != chars[j])
                return false;
        }
        return true;
    }

}
