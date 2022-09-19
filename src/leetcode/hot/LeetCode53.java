package leetcode.hot;

/**
 * LeetCode53.java
 * Description: https://leetcode.cn/problems/maximum-subarray/
 *
 * @author Peng Shiquan
 * @date 2022/9/19
 */
public class LeetCode53 {
    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        int length = nums.length;
        //动态规划给出的答案数组是以当前i为结尾的最大和的值
        int[] sums = new int[length];
        sums[0] = nums[0];
        for (int i = 1; i < length; i++) {
            //判断前一个结果是否大于0
            sums[i] = sums[i - 1] > 0 ? sums[i - 1] + nums[i] : nums[i];
        }
        int result = nums[0];
        for (int i : sums) {
            if (i > result) result = i;
        }
        return result;
    }

    public int maxSubArray2(int[] nums) {
        //动态规划的另外一种写法
        int result = nums[0], pre = 0;
        for (int i : nums) {
            pre = Math.max(i, pre + i);
            result = Math.max(pre, result);
        }
        return result;
    }


}
