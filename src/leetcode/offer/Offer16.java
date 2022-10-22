package leetcode.offer;

/**
 * Offer16.java
 * Description: https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/?favorite=xb9nqhhg
 *
 * @author Peng Shiquan
 * @date 2022/10/22
 */
public class Offer16 {
    public double myPow(double x, int n) {
        long N = n;
        return n < 0 ? 1 / quickMul(x, N) : quickMul(x, N);
    }

    public double quickMul(double x, long n) {
        if (n == 0) return 1f;
        //递归求下一个值
        double y = quickMul(x, n / 2);
        //判断n是否能被2整除
        return n % 2 == 0 ? y * y : y * y * x;
    }

    public static void main(String[] args) {
        System.err.println(new Offer16().myPow(2.0, 10));
    }
}
