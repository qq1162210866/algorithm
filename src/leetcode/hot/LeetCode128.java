package leetcode.hot;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode128.java
 * Description: https://leetcode.cn/problems/longest-consecutive-sequence/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/9/27
 */
public class LeetCode128 {
    public static void main(String[] args) {
        System.err.println(new LeetCode128().longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

    public int longestConsecutive(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        Arrays.sort(nums);
        int start = 0, max = 1;
        for (int i = 1; i < length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                max = Math.max(max, i - start + 1);
            } else if (nums[i] - nums[i - 1] == 0) {
                start = start + 1;
            } else {
                start = i;
            }
        }
        return max;
    }

    public int longestConsecutive2(int[] nums) {
        Set<Integer> integers = new HashSet<>();
        for (int num : nums)
            integers.add(num);

        int max = 0;
        for (int num : integers) {
            if (!integers.contains(num - 1)) {
                int tmp = 1;
                int cur = num;
                while (integers.contains(cur + 1)) {
                    cur++;
                    tmp++;
                }
                max = Math.max(max, tmp);
            }
        }
        return max;
    }

}
