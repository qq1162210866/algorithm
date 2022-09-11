package leetcode.hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode15.java
 * Description: https://leetcode.cn/problems/3sum/
 *
 * @author Peng Shiquan
 * @date 2022/9/11
 */
public class LeetCode15 {
    public static void main(String[] args) {
        System.err.println(new LeetCode15().threeSum(new int[]{-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //先排序，可以减少重复元素
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            //去除第一次循环中重复的元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0) return result;
            //找第二和第三个元素
            int second = i + 1;
            int third = length - 1;
            //当两个指针相遇时，结束循环
            while (second < third) {
                if (nums[i] + nums[second] + nums[third] == 0) {
                    //如果相等，就添加到结果集中
                    result.add(Arrays.asList(nums[i], nums[second], nums[third]));
                    //因为中间重复元素会漏掉，所以需要放到里面来
                    //找到一个解后，再去排除其他重复位置，要不然会有遗漏
                    //先找到左指针第一个不等的元素
                    while (second < third && nums[second] == nums[second + 1]) {
                        second++;
                    }
                    //找到右指针第一个不等的元素
                    while (second < third && nums[third] == nums[third - 1]) {
                        third--;
                    }
                    third--;
                    second++;
                } else if (nums[i] + nums[second] + nums[third] > 0) {
                    //如果大于0，说明右指针太大，需要右指针左移
                    third--;
                } else {
                    //如果小于0，说明左指针太小，需要左指针右移
                    second++;
                }
            }
        }
        return result;
    }
}
