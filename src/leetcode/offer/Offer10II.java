package leetcode.offer;

/**
 * Offer10II.java
 * Description: https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/?favorite=xb9nqhhg
 *
 * @author Peng Shiquan
 * @date 2022/10/20
 */
public class Offer10II {
    public int numWays(int n) {
        if (n == 0 || n == 1) return 1;
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            result[i] = (result[i - 1] + result[i - 2]) % 1000000007;
        }
        return result[n];
    }

    public static void main(String[] args) {

    }
}
