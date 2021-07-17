package leetcode;

/**
 * LeetCode34.java
 * Description: 查找元素出现的位置
 *
 * @author Peng Shiquan
 * @date 2021/7/16
 */
public class LeetCode34 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2};
        LeetCode34 leetCode34 = new LeetCode34();
        System.err.println(leetCode34.binarySearch(nums, 3, false));
    }

    public int search(int[] nums, int target) {
        int left = leftSearch(nums, target);
        int right = rightSearch(nums, target);
        return right - left + 1;
    }

    public int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, true) - 1;
        if (left <= right && right < nums.length && nums[left] == target && nums[right] == target) {
            return new int[]{left, right};
        }
        return new int[]{-1, -1};
    }

    public int leftSearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            //不能证明此时的mid就是最左边
            if (nums[mid] >= target) {
                right = mid - 1;
                index = mid;
            } else left = mid + 1;
        }
        return index;
    }

    public int rightSearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            //不能证明此时的mid就是最右边
            if (nums[mid] <= target) {
                left = mid + 1;

            } else {
                right = mid - 1;
                index = mid;
            }
        }
        return index;
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            //条件的判断都是大于等于，但是因为找左边需要等于，找右边不需要等于。
            if (nums[mid] > target || (lower && nums[mid] == target)) {
                right = mid - 1;
                //不清楚为什么放在这里
                index = mid;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }

}
