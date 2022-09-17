package leetcode.hot;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * LeetCode46.java
 * Description: https://leetcode.cn/problems/permutations/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/9/16
 */
public class LeetCode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, nums.length, used, 0, result, path);
        return result;
    }

    public void dfs(int[] nums, int length, boolean[] used, int dLength, List<List<Integer>> result, Deque<Integer> path) {
        if (dLength == length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (!used[i]) {
                //标记当前位为已使用
                used[i] = true;
                path.add(nums[i]);
                dfs(nums, length, used, dLength + 1, result, path);
                //回滚之前操作
                path.removeLast();
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.err.println(new LeetCode46().permute(new int[]{1, 2, 3}));
    }
}
