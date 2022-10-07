package leetcode.hot;

/**
 * LeetCode287.java
 * Description: https://leetcode.cn/problems/find-the-duplicate-number/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/10/7
 */
public class LeetCode287 {
    public static void main(String[] args) {
        System.err.println(new LeetCode287().findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }

    public int findDuplicate(int[] nums) {
        //因为重复数字不定长度，所以该方法不行
        int max = -1;
        int sum = 0;
        int length = nums.length;
        int min = length;
        for (int num : nums) {
            if (num > max) max = num;
            if (num < min) min = num;
            sum += num;
        }
        int numsSum = (max + min) * (max - min + 1) / 2;
        return (sum - numsSum) / (length - (max - min + 1));
    }

    public int findDuplicate2(int[] nums) {
        int length = nums.length;
        int l = 0, r = length - 1, result = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int count = 0;
            for (int i = 0; i < length; i++) {
                if (nums[i] <= mid) count++;
            }
            if (count <= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
                //答案也是 count比index大，所以要先赋值，最后循环结束就得到答案
                result = mid;
            }
        }
        return result;
    }
}
