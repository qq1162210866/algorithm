package leetcode.offer;

import java.util.Arrays;

/**
 * Offer03.java
 * Description: https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/?favorite=xb9nqhhg
 *
 * @author Peng Shiquan
 * @date 2022/10/17
 */
public class Offer03 {
    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            if (nums[i] == nums[i - 1]) return nums[i];
        }
        return -1;
    }

    public int findRepeatNumber2(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int tmp = nums[i];
            if (tmp < 0) tmp += length;
            if (nums[tmp] < 0) return tmp;
            nums[tmp] -= length;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
