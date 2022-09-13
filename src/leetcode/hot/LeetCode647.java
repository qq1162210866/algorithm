package leetcode.hot;

/**
 * LeetCode647.java
 * Description:
 *
 * @author Peng Shiquan
 * @date 2022/9/13
 */
public class LeetCode647 {
    public int countSubstrings(String s) {
        int length = s.length();
        int result = 0;
        //奇数中心点有length个，偶数有length-1个，所以总共2 * length - 1个
        for (int i = 0; i < 2 * length - 1; i++) {
            //分别求左指针和右指针
            //这两个指针不好理解
            int left = i / 2;
            int right = left + i % 2;
            //left和right要到边界
            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.err.println(new LeetCode647().countSubstrings("abc"));
    }
}
