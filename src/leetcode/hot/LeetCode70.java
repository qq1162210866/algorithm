package leetcode.hot;

/**
 * LeetCode70.java
 * Description: https://leetcode.cn/problems/climbing-stairs/
 *
 * @author Peng Shiquan
 * @date 2022/8/12
 */
public class LeetCode70 {
    public static void main(String[] args) {
        System.err.println(new LeetCode70().climbStairs(3));
    }

    public int climbStairs(int n) {
        //p 为x-2 q为x-1
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
