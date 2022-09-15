package leetcode.hot;

/**
 * LeetCode33.java
 * Description: https://leetcode.cn/problems/search-in-rotated-sorted-array/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/9/15
 */
public class LeetCode33 {
    public int search(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == target) return i;
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        int length = nums.length;
        //不方便分割的做单独处理
        if (length == 0) return -1;
        if (length == 1) return nums[0] == target ? 0 : -1;

        int left = 0;
        int right = length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            //不存在相等情况
            if (nums[0] <= nums[mid]) {
                //左边有序
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                //右边有序
                if (nums[mid + 1] < target && target <= nums[length - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;

                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {

    }
}
