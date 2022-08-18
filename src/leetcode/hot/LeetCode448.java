package leetcode.hot;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode448.java
 * Description: https://leetcode.cn/problems/find-all-numbers-disappea`re`d-in-an-array/
 *
 * @author Peng Shiquan
 * @date 2022/8/18
 */
public class LeetCode448 {
    public static void main(String[] args) {
        System.err.println(new LeetCode448().findDisappearedNumbers2(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] ints = new int[nums.length];
        for (int i : nums) {
            ints[i - 1]++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (ints[i] == 0) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int n = nums.length;
        for (int i : nums) {
            //循环遍历数组，将i对应的位置加N
            //nums中是1到n，所以要减一，当前数可能已经加n了，所以需要还原原本值
            int x = (i - 1) % n;
            nums[x] += n;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            //如果当前值小于n，就代表上次循环该位置没有加N，即没有这个数
            if (nums[i] <= n) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
