package leetcode.hot;

/**
 * LeetCode461.java
 * Description: https://leetcode.cn/problems/hamming-distance/
 *
 * @author Peng Shiquan
 * @date 2022/8/18
 */
public class LeetCode461 {
    public static void main(String[] args) {
        System.err.println(new LeetCode461().hammingDistance2(1, 4));
    }

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public int hammingDistance2(int x, int y) {
        int s = x ^ y, result = 0;
        while (s != 0) {
            s &= s - 1;
            result++;

        }
        return result;
    }
}
