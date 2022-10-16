package leetcode.offer;

/**
 * offer10.java
 * Description: https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/?favorite=xb9nqhhg
 *
 * @author Peng Shiquan
 * @date 2022/10/16
 */
public class offer10 {
    public static void main(String[] args) {
        System.err.println(new offer10().fib(100));
    }

    public int fib(int n) {
        if (n == 0) return 0;
        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            result[i] = (result[i - 1] + result[i - 2]) % 1000000007;
        }
        return result[n];
    }
}
