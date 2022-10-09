package leetcode.hot;

/**
 * LeetCode300.java
 * Description: https://leetcode.cn/problems/longest-increasing-subsequence/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/10/9
 */
public class LeetCode300 {
    public static void main(String[] args) {
        System.err.println(new LeetCode300().lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }

    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = 1;
        int result = 1;
        for (int i = 1; i < length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    max = Math.max(dp[j] + 1, max);
            }
            dp[i] = max;
            result = Math.max(dp[i], result);
        }
        //不是求最后一个长度，要求最大值
        return result;
    }
}
