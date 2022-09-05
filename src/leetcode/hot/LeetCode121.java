package leetcode.hot;

/**
 * LeetCode121.java
 * Description: https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 *
 * @author Peng Shiquan
 * @date 2022/8/19
 */
public class LeetCode121 {

    public static void main(String[] args) {
        System.err.println(new LeetCode121().maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i : prices) {
            if (i < minPrice) {
                minPrice = i;
            } else {
                if (i - minPrice > maxProfit) maxProfit = i - minPrice;
            }

        }
        return maxProfit;
    }
}
