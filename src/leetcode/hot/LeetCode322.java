package leetcode.hot;

import java.util.Arrays;

/**
 * LeetCode322.java
 * Description: https://leetcode.cn/problems/coin-change/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/10/1
 */
public class LeetCode322 {
    public static void main(String[] args) {
        System.err.println(new LeetCode322().coinChange2(new int[]{186, 419, 83, 408}, 6249));
    }

    public int coinChange(int[] coins, int amount) {
        //不行，没有考虑不使用最后一个硬币的情况
        Arrays.sort(coins);
        if (amount == 0) return 0;
        int amountTmp = amount;
        int index = coins.length - 1;
        int result = 0;
        while (index >= 0) {
            int tmp = amountTmp - coins[index];
            if (tmp > 0) {
                result++;
                amountTmp = tmp;
            } else if (tmp == 0) {
                result++;
                return result;
            } else {
                index--;
            }
        }
        return -1;
    }

    public int coinChange2(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        int length = coins.length;
        //外部循环遍历金额
        for (int i = 1; i < amount + 1; i++) {
            //内部循环遍历硬币
            for (int j = 0; j < length; j++) {
                if (coins[j] <= i)
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        //如果大于amount，就说明没有找到
        return dp[amount] > amount ? -1 : dp[amount];
    }


}
