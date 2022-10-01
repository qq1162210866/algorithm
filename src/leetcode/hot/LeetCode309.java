package leetcode.hot;

/**
 * LeetCode309.java
 * Description: https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/10/1
 */
public class LeetCode309 {
    public static void main(String[] args) {
        System.err.println(new LeetCode309().maxProfit(new int[]{1, 2, 3, 0, 2}));
    }

    public int maxProfit(int[] prices) {
        int length = prices.length;
        // f[i][0]: 手上持有股票的最大收益
        // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
        int[][] dp = new int[length][3];
        //初始化，其他都是0，只有买入为负
        dp[0][0] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[length - 1][1], dp[length - 1][2]);
    }
}
