package leetcode.hot;

/**
 * LeetCode198.java
 * Description: https://leetcode.cn/problems/house-robber/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/10/3
 */
public class LeetCode198 {
    public static void main(String[] args) {
        System.err.println(new LeetCode198().rob(new int[]{1, 1}));
    }

    public int rob(int[] nums) {
        int length = nums.length;
        int[][] result = new int[length][2];
        result[0][0] = 0;
        result[0][1] = nums[0];
        for (int i = 1; i < length; i++) {
            result[i][0] = Math.max(result[i - 1][0], result[i - 1][1]);
            result[i][1] = result[i - 1][0] + nums[i];
        }
        return Math.max(result[length - 1][0], result[length - 1][1]);
    }
}
