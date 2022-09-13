package leetcode.hot;

import java.util.Arrays;

/**
 * LeetCode581.java
 * Description: https://leetcode.cn/problems/shortest-unsorted-continuous-subarray/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/9/13
 */
public class LeetCode581 {
    public int findUnsortedSubarray(int[] nums) {
        int[] sortNums = new int[nums.length];
        System.arraycopy(nums, 0, sortNums, 0, nums.length);
        Arrays.sort(sortNums);
        int left = 0, right = 0;
        for (int i = 0; i < sortNums.length; i++) {
            if (nums[i] != sortNums[i]) {
                left = i;
                break;
            }
        }
        for (int i = sortNums.length - 1; i >= 0; i--) {
            if (nums[i] != sortNums[i]) {
                right = i;
                break;
            }
        }
        return right == left ? 0 : right - left + 1;
    }

    public int findUnsortedSubarray2(int[] nums) {
        int max = Integer.MIN_VALUE, right = -1;
        int min = Integer.MAX_VALUE, left = -1;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            //找到右边界
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                right = i;
            }
            //找到左边界
            if (nums[length - i - 1] <= min) {
                min = nums[length - i - 1];
            } else {
                left = length - i - 1;
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }


    public static void main(String[] args) {
        System.err.println(new LeetCode581().findUnsortedSubarray2(new int[]{1, 2, 3, 3, 3}));
    }
}
