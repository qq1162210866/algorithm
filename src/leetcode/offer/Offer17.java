package leetcode.offer;

/**
 * Offer17.java
 * Description: https://leetcode.cn/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/?favorite=xb9nqhhg
 *
 * @author Peng Shiquan
 * @date 2022/10/23
 */
public class Offer17 {
    public static void main(String[] args) {
        System.err.println(new Offer17().printNumbers(3));
    }

    public int[] printNumbers(int n) {
        int tmp = 1;
        int times = 0;
        for (int i = 0; i < n; i++) {
            times = tmp * 9 + times;
            tmp *= 10;
        }
        System.err.println(times);
        int[] result = new int[times];
        for (int i = 0; i < times; i++) {
            result[i] = i + 1;
        }
        return result;

    }
}
