package leetcode.hot;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode207.java
 * Description: https://leetcode.cn/problems/course-schedule/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/10/4
 */
public class LeetCode207 {
    public static void main(String[] args) {
        int[][] prerequisites = new int[1][2];
        // prerequisites[0] = new int[]{1, 0};
        prerequisites[0] = new int[]{0, 1};
        new LeetCode207().canFinish(2, prerequisites);
    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        int[] indeg = new int[numCourses];
        for (int[] a : prerequisites) {
            //放入被依赖的课程数组
            edges.get(a[1]).add(a[0]);
            //将当前课程依赖的课程数加1
            indeg[a[0]]++;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        //找到入度为0的课程
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) queue.add(i);
        }
        int result = 0;
        while (!queue.isEmpty()) {
            int a = queue.poll();
            result++;
            for (int i : edges.get(a)) {
                indeg[i]--;
                if (indeg[i] == 0) {
                    queue.offer(i);
                }
            }
        }
        return result == numCourses;
    }
}
