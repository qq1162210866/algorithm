package leetcode.hot;

/**
 * LeetCode416.java
 * Description: https://leetcode.cn/problems/partition-equal-subset-sum/
 *
 * @author Peng Shiquan
 * @date 2022/10/13
 */
public class LeetCode416 {
    public static void main(String[] args) {

    }

    public boolean canPartition(int[] nums) {
        int length = nums.length;
        if (length == 1) return false;
        int sum = 0;
        int max = -1;
        for (int num : nums) {
            sum += num;
            max = Math.max(num, max);
        }
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        //此处添加判断，要不然后续会数组越界
        if (max > target) return false;
        boolean[][] result = new boolean[length][target + 1];
        for (int i = 0; i < length; i++)
            result[i][0] = true;
        result[0][nums[0]] = true;
        for (int i = 1; i < length; i++) {
            for (int j = 1; j < target + 1; j++) {
                int num = nums[i];
                if (j >= num) {
                    //值为j-num和上一行的或
                    result[i][j] = result[i - 1][j - num] | result[i - 1][j];
                } else {
                    //值直接为上一行的值
                    result[i][j] = result[i - 1][j];
                }
            }
        }
        return result[length - 1][target];
    }
}
