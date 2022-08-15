package leetcode.hot;

import java.util.Arrays;

/**
 * LeetCode338.java
 * Description: https://leetcode.cn/problems/counting-bits/
 *
 * @author Peng Shiquan
 * @date 2022/8/15
 */
public class LeetCode338 {
    public static void main(String[] args) {
        //[0,1,1,2,1,2]
        System.err.println(Arrays.toString(new LeetCode338().countBits(5)));
    }

    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
            //最高有效位即是当前值减一再&当前值，如果是0就代表当前值是最高位为1，其余是0的数
            if ((i & (i - 1)) == 0) {
                //重复更新最高有效位
                highBit = i;
            }
            result[i] = result[i - highBit] + 1;
        }
        return result;
    }
}
