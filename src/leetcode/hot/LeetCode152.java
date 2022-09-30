package leetcode.hot;

/**
 * LeetCode152.java
 * Description: https://leetcode.cn/problems/maximum-product-subarray/
 *
 * @author Peng Shiquan
 * @date 2022/9/30
 */
public class LeetCode152 {
    public static void main(String[] args) {

    }

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        //初始化前置最大值和最小值
        int maxPre = 1;
        int minPre = 1;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int tmp = maxPre;
            //dp[i]=max(dp[i-1]*nums[i],nums[i],min*nums[i])
            maxPre = Math.max(Math.max(maxPre * nums[i], nums[i]), minPre * nums[i]);
            minPre = Math.min(Math.min(tmp * nums[i], nums[i]), minPre * nums[i]);
            max = Math.max(maxPre, max);
        }
        return max;
    }
}
