package leetcode.offer;

import java.util.Arrays;

/**
 * Offer21.java
 * Description:
 *
 * @author Peng Shiquan
 * @date 2022/10/24
 */
public class Offer21 {
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (nums[left] % 2 != 0 && left < right) left++;
            while (nums[right] % 2 == 0 && right > 0) right--;
            if (left < right) swap(nums, left, right);
        }
        return nums;
    }

    public void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {
        System.err.println(Arrays.toString(new Offer21().exchange(new int[]{2, 4, 6})));
    }
}
