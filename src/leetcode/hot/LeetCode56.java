package leetcode.hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * LeetCode56.java
 * Description: https://leetcode.cn/problems/merge-intervals/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/9/20
 */
public class LeetCode56 {
    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals) {
        //需要先排序
        Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);

        int length = intervals.length;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            List<Integer> tmp = new ArrayList<>();
            if (i == 0) {
                //第一个直接添加
                tmp.add(intervals[i][0]);
                tmp.add(intervals[i][1]);
                result.add(tmp);
            } else {
                //当，前一个区间的结束大于当前区间的开始时，需要做判断，否则直接添加
                List<Integer> tmp2 = result.get(result.size() - 1);
                if (tmp2.get(1) >= intervals[i][0]) {
                    //需要再判断前一个数区间的结束是否大于当前区间的结束
                    if (intervals[i][1] > tmp2.get(1)) {
                        tmp2.remove(1);
                        tmp2.add(intervals[i][1]);
                    }
                } else {
                    tmp.add(intervals[i][0]);
                    tmp.add(intervals[i][1]);
                    result.add(tmp);
                }
            }
        }
        //将结果返回
        int[][] resArray = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            resArray[i][0] = result.get(i).get(0);
            resArray[i][1] = result.get(i).get(1);
        }
        return resArray;
    }

    public int[][] merge2(int[][] intervals) {
        //排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int length = intervals.length;
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int l = intervals[i][0], r = intervals[i][1];
            if (i == 0 || result.get(result.size() - 1)[1] < l) {
                result.add(new int[]{l, r});
            } else {
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], r);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }

}
