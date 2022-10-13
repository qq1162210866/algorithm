package leetcode.hot;

/**
 * LeetCode494.java
 * Description: https://leetcode.cn/problems/target-sum/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/10/13
 */
public class LeetCode494 {
    public static void main(String[] args) {
        System.err.println(new LeetCode494().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    int result = 0;

    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, target, 0, 0, nums.length);
        return result;
    }

    public void dfs(int[] nums, int target, int sum, int index, int length) {
        if (index >= length) {
            if (target == sum) result++;
            return;
        }
        dfs(nums, target, sum + nums[index], index + 1, length);
        dfs(nums, target, sum - nums[index], index + 1, length);
    }

}
