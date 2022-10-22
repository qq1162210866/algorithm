package leetcode.offer;

/**
 * Offer14I.java
 * Description: https://leetcode.cn/problems/jian-sheng-zi-lcof/?favorite=xb9nqhhg
 *
 * @author Peng Shiquan
 * @date 2022/10/21
 */
public class Offer14I {
    public static void main(String[] args) {

    }

    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        //0 和 1 初始化为0
        for (int i = 2; i <= n; i++) {
            int max = 0;
            //再从1开始剪，剩下的可以剪，也可以不剪
            for (int j = 1; j < i; j++) {
                max = Math.max(max, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
