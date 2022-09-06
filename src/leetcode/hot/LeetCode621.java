package leetcode.hot;

/**
 * LeetCode621.java
 * Description: https://leetcode.cn/problems/task-scheduler/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/9/6
 */
public class LeetCode621 {

    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        int[] tmp = new int[26];
        int maxTask = 0;
        int countTask = 0;
        //拿到桶数
        for (char c : tasks) {
            tmp[c - 'A']++;
            maxTask = Math.max(tmp[c - 'A'], maxTask);
        }
        //求最后一个桶的数
        for (int i : tmp) {
            //如果有任务和桶数一样，就说明最后需要再执行当前数+1
            if (i == maxTask) countTask++;
        }
        //取max是因为有n等于0时，需要判断一下一些特殊的情况.
        //还有就是如果空闲时间没有的话，就是任务排满了，此时也是length大，且为正确答案
        //如果length小，肯定是有空闲时间，所以套用公式即可
        return Math.max(tasks.length, (maxTask - 1) * (n + 1) + countTask);
    }

    public static void main(String[] args) {
        System.err.println(new LeetCode621().leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }
}
