package leetcode.hot;

import java.util.*;

/**
 * LeetCode347.java
 * Description: https://leetcode.cn/problems/top-k-frequent-elements/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/10/10
 */
public class LeetCode347 {
    public static void main(String[] args) {
        System.err.println(Arrays.toString(
                new LeetCode347().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(Comparator.comparingInt(o -> o[1]));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int time = entry.getValue();
            if (queue.size() == k) {
                int min = queue.peek()[1];
                if (min < time) {
                    queue.poll();
                    queue.offer(new int[]{num, time});
                }
            } else {
                queue.offer(new int[]{num, time});
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll()[0];
        }
        return result;
    }
}
