package leetcode;

/**
 * LeetCode215.java
 * Description: 数组中的第K个最大元素
 *
 * @author Peng Shiquan
 * @date 2021/8/29
 */
public class LeetCode215 {
    public static void main(String[] args) {
        LeetCode215 leetCode215 = new LeetCode215();
        int[] arr = new int[]{3, 2, 1, 5, 6, 4};
        System.err.println(leetCode215.findKthLargest(arr, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        int maxIndex;
        for (int i = 0; i < length; i++) {
            maxIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (nums[j] > nums[maxIndex]) maxIndex = j;
            }
            if (i + 1 == k) return nums[maxIndex];
            int tmp = nums[maxIndex];
            nums[maxIndex] = nums[i];
            nums[i] = tmp;
        }
        return 0;
    }
}
