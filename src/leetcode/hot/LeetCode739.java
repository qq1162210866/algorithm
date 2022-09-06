package leetcode.hot;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * LeetCode739.java
 * Description: https://leetcode.cn/problems/daily-temperatures/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/9/6
 */
public class LeetCode739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            //只有当栈不为null时，并且当前温度大于栈顶温度时，才更新结果集，并且删除栈顶温度下标
            while (!deque.isEmpty() && temperature > temperatures[deque.peek()]) {
                int j = deque.pop();
                result[j] = i - j;
            }
            //无论是否计算结果集，都要将当前温度的下标放入栈中
            deque.push(i);
        }
        return result;
    }


    public static void main(String[] args) {
        System.err.println(Arrays.toString(new LeetCode739().dailyTemperatures2(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
