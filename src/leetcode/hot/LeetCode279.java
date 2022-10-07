package leetcode.hot;

/**
 * LeetCode279.java
 * Description: https://leetcode.cn/problems/perfect-squares/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/10/7
 */
public class LeetCode279 {
    public static void main(String[] args) {

    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            //最坏的情况就是1+1+1。。。
            dp[i] = i;
            //从1开始遍历，一直到边界为止
            for (int j = 1; i - j * j >= 0; j++) {
                //动态转移方程
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

}
