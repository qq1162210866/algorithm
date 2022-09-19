package leetcode.hot;

/**
 * LeetCode55.java
 * Description: https://leetcode.cn/problems/jump-game/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/9/19
 */
public class LeetCode55 {
    public boolean canJump(int[] nums) {
        int length = nums.length;
        boolean[] res = new boolean[length];
        res[0] = true;

        for (int i = 0; i < length; i++) {
            if (res[i] && nums[i] > 0) {
                for (int j = 0; j < nums[i]; j++) {
                    int index = i + 1 + j;
                    if (index == length - 1) return true;
                    if (index < length) {
                        res[i + 1 + j] = true;
                    }
                }
            }
        }
        return res[length - 1];
    }

    public static void main(String[] args) {
        System.err.println(new LeetCode55().canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
