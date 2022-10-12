package leetcode.hot;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode406.java
 * Description: https://leetcode.cn/problems/queue-reconstruction-by-height/
 *
 * @author Peng Shiquan
 * @date 2022/10/12
 */
public class LeetCode406 {
    public static void main(String[] args) {

    }

    public int[][] reconstructQueue(int[][] people) {
        //主要的思路就是先按照身高降序排序，在按照k值升序
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o2[0] - o1[0];
            }
        });
        int length = people.length;
        List<int[]> list = new LinkedList<>();
        int size = 0;
        for (int i = 0; i < length; i++) {
            int k = people[i][1];
            //如果size<=k，就直接放尾部
            //大于，就直接放i处。因为高的人看不到低的人
            if (size <= k) {
                list.add(size, people[i]);
            } else {
                list.add(k, people[i]);
            }
            size++;
        }
        return list.toArray(new int[list.size()][]);
    }

}
