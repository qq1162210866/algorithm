package acm;

/**
 * MinCoin.java
 * Description: 最少硬币问题
 *
 * @author Peng Shiquan
 * @date 2021/6/4
 */
public class MinCoin {
    public static void main(String[] args) {
        int[] coins = {2, 5, 7};
        System.err.println(minCoin(coins, 27));
    }

    /**
     * Description: 输入需要的钱数和硬币情况，返回最小硬币数
     *
     * @param coins
     * @param money
     * @return int
     * @Author Peng Shiquan
     * @Date 2021-06-04
     */
    public static int minCoin(int[] coins, int money) {
        int[] a = new int[money + 1];
        int coinNum = coins.length;
        a[0] = 0;
        //循环填充数组
        for (int i = 1; i <= money; i++) {
            a[i] = Integer.MAX_VALUE;
            //循环遍历硬币
            for (int j = 0; j < coinNum; j++) {
                if (i >= coins[j] && a[i - coins[j]] != Integer.MAX_VALUE) {
                    //有可能之前的值要小于后来的值，所以取最小
                    a[i] = Math.min(a[i - coins[j]] + 1, a[i]);
                }
            }
        }
        if (a[money] == Integer.MAX_VALUE) {
            return -1;
        }
        return a[money];
    }
}
