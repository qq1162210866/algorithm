package leetcode;

/**
 * LeetCode283.java
 * Description: 移动零
 *
 * @author Peng Shiquan
 * @date 2021/8/17
 */
public class LeetCode283 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        new LeetCode283().moveZeroes(nums);
        for (int num : nums) {
            System.err.print(num + ",");
        }
    }

    public void moveZeroes(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (nums[j] == 0) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
    }
}
