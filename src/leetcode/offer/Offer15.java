package leetcode.offer;

/**
 * Offer15.java
 * Description: https://leetcode.cn/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/?favorite=xb9nqhhg
 *
 * @author Peng Shiquan
 * @date 2022/10/22
 */
public class Offer15 {
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            n &= n - 1;
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.err.println(new Offer15().hammingWeight(11));
    }
}
