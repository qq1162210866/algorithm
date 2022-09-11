package leetcode.hot;

/**
 * LeetCode11.java
 * Description: https://leetcode.cn/problems/container-with-most-water/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/9/11
 */
public class LeetCode11 {
    public static void main(String[] args) {
        System.err.println(new LeetCode11().maxArea2(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public int maxArea(int[] height) {
        //能解决但是耗时
        int result = 0;
        int length = height.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int tmp = (j - i) * Math.min(height[i], height[j]);
                if (tmp > result) result = tmp;
            }
        }
        return result;
    }

    public int maxArea2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        while (left < right) {
            //容积的计算公式
            int tmp = (right - left) * Math.min(height[left], height[right]);
            if (tmp > result) result = tmp;
            //当移动最大的边界时，容积只会变小或者不变，当移动最小的边界时，容积才有变大的可能性
            if (height[left] >= height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }

}
