package leetcode.hot;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * LeetCode78.java
 * Description: https://leetcode.cn/problems/subsets/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/9/22
 */
public class LeetCode78 {
    public static void main(String[] args) {
        System.err.println(new LeetCode78().subsets(new int[]{1, 2, 3}));
    }

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        Deque<Integer> queue = new ArrayDeque<>();
        dfs(nums, 0, nums.length, queue);
        return result;
    }

    public void dfs(int[] nums, int begin, int length, Deque<Integer> queue) {
        result.add(new ArrayList<>(queue));
        for (int i = begin; i < length; i++) {
            queue.add(nums[i]);
            dfs(nums, i + 1, length, queue);
            queue.removeLast();
        }
    }

}
