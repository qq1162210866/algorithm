package leetcode.hot;

import java.util.Arrays;

/**
 * LeetCode238.java
 * Description: https://leetcode.cn/problems/product-of-array-except-self/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/10/6
 */
public class LeetCode238 {
    public static void main(String[] args) {
        System.err.println(Arrays.toString(new LeetCode238().productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
    }

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] leftNums = new int[length];
        leftNums[0] = 1;
        int[] rightNums = new int[length];
        rightNums[length - 1] = 1;
        int[] result = new int[length];
        int left = 1, right = length - 2;
        for (int i = 1; i < length; i++) {
            leftNums[left] = leftNums[left - 1] * nums[left - 1];
            rightNums[right] = rightNums[right + 1] * nums[right + 1];
            if (left >= right) {
                result[left] = leftNums[left] * rightNums[left];
                result[right] = leftNums[right] * rightNums[right];
            }
            left++;
            right--;
        }
        return result;
    }
}
