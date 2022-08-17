package leetcode.hot;

import java.util.Arrays;

/**
 * LeetCode169.java
 * Description: https://leetcode.cn/problems/majority-element/
 *
 * @author Peng Shiquan
 * @date 2022/8/17
 */
public class LeetCode169 {
    public static void main(String[] args) {
        System.err.println(new LeetCode169().majorityElement(new int[]{1, 2, 3, 3, 3}));
    }

    public int majorityElement(int[] nums) {
        //排序再返回n/2
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
