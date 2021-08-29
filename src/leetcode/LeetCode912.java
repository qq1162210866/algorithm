package leetcode;

/**
 * LeetCode912.java
 * Description: 排序数组
 *
 * @author Peng Shiquan
 * @date 2021/8/29
 */
public class LeetCode912 {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 1, 1, 2, 0, 0};
        LeetCode912 leetCode912 = new LeetCode912();
        int[] result = leetCode912.sortArray(arr);
        for (int i : result)
            System.out.print(i + ",");
    }

    public int[] sortArray(int[] nums) {
        int length = nums.length;
        int minIndex, maxIndex;
        for (int i = 0; i < length; i++) {
            minIndex = maxIndex = i;
            for (int j = i + 1; j < length - i; j++) {
                if (nums[j] < nums[minIndex]) minIndex = j;
                if (nums[j] > nums[maxIndex]) maxIndex = j;
            }
            if (minIndex == maxIndex) break;
            swap(nums, i, minIndex);
            //防止最大值为i的情况。
            if (maxIndex == i) {
                swap(nums, length - 1 - i, minIndex);
            } else {
                swap(nums, length - 1 - i, maxIndex);
            }
        }
        return nums;
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
