package leetcode.hot;

import java.util.Arrays;

/**
 * LeetCode75.java
 * Description: https://leetcode.cn/problems/sort-colors/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/9/21
 */
public class LeetCode75 {
    public static void main(String[] args) {
        new LeetCode75().sortColors(new int[]{2, 0, 1});
    }

    public void sortColors(int[] nums) {

        int p0 = 0, p2 = nums.length - 1, i = 0;
        while (i <= p2) {
            if (nums[i] == 0) {
                swap(nums, i, p0);
                p0++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, p2);
                p2--;
            }
        }
        System.err.println(Arrays.toString(nums));
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
