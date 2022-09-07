package leetcode.hot;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode560.java
 * Description: https://leetcode.cn/problems/subarray-sum-equals-k/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/9/7
 */
public class LeetCode560 {
    public static void main(String[] args) {

    }

    public int subarraySum(int[] nums, int k) {
        //需要注意连续子数组的概念
        //所以从后往前即可，然后枚举
        int count = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        int pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        //map初始化
        map.put(0, 1);
        for (int i : nums) {
            pre += i;
            if (map.containsKey(pre - k)) {
                //应该加前缀和的次数*1，即+=map.get(pre - k)
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

}
