package leetcode.hot;

import java.util.*;

/**
 * LeetCode39.java
 * Description: https://leetcode.cn/problems/combination-sum/
 *
 * @author Peng Shiquan
 * @date 2022/9/15
 */
public class LeetCode39 {
    public static void main(String[] args) {
        System.err.println(new LeetCode39().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        int length = candidates.length;
        if (length == 0) return result;
        //排序方便剪枝
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, target, length, result, path);
        return result;
    }

    public void dfs(int[] nums, int begin, int target, int length, List<List<Integer>> result, Deque<Integer> path) {
        //找到结果集了
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < length; i++) {
            if (target - nums[i] < 0) {
                //说明后续的数没有合适的了，直接结束即可
                break;
            }
            path.add(nums[i]);
            //要从当前i开始
            dfs(nums, i, target - nums[i], length, result, path);
            //重置当前回溯
            path.removeLast();
        }

    }
}
