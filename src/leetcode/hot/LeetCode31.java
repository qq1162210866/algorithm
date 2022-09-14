package leetcode.hot;

/**
 * LeetCode31.java
 * Description: https://leetcode.cn/problems/next-permutation/
 *
 * @author Peng Shiquan
 * @date 2022/9/14
 */
public class LeetCode31 {
    public void nextPermutation(int[] nums) {
        //先找到较小值
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            //再找较大值
            int j = nums.length - 1;
            while (j > i && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        //后面到数组是降序的，所以直接交换即可
        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        new LeetCode31().nextPermutation(new int[]{1,5,1});
    }
}
