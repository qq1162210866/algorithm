package leetcode.hot;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * LeetCode136.java
 * Description: https://leetcode.cn/problems/single-number/
 *
 * @author Peng Shiquan
 * @date 2022/8/22
 */
public class LeetCode136 {
    public static void main(String[] args) {
        System.err.println(new LeetCode136().singleNumber2(new int[]{2, 2, 1}));
    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> integers = new HashMap<>(nums.length / 2 + 1);
        for (int i : nums) {
            if (integers.containsKey(i)) {
                integers.put(i, 2);
            } else {
                integers.put(i, 1);
            }
        }
        AtomicInteger result = new AtomicInteger();
        integers.forEach((integer, integer2) -> {
            if (integer2 == 1) result.set(integer);
        });
        return result.get();
    }

    public int singleNumber2(int[] nums) {
        //任何数和0异或结果都是原来的数
        //任何数和自己异或都是0
        //异或运算满足交换律和结合律
        int result = 0;
        for (int i : nums) {
            result ^= i;
        }
        return result;
    }
}
