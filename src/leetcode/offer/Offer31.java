package leetcode.offer;

import java.util.Stack;

/**
 * Offer31.java
 * Description: https://leetcode.cn/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/?favorite=xb9nqhhg
 *
 * @author Peng Shiquan
 * @date 2022/10/31
 */
public class Offer31 {
    public static void main(String[] args) {
        System.err.println(new Offer31().validateStackSequences(new int[]{0, 1}, new int[]{0, 1}));
        System.err.println(new Offer31().validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
        System.err.println(new Offer31().validateStackSequences(new int[]{2, 1, 0}, new int[]{1, 2, 0}));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int left = 0;
        int right = 0;
        while (true) {
            if (left < pushed.length) {
                if (pushed[left] == popped[right]) {
                    left++;
                    right++;
                    //当出栈后，还有可能接着出栈。需要循环判断
                    while (!stack.isEmpty() && stack.peek() == popped[right]) {
                        stack.pop();
                        right++;
                    }
                } else {
                    stack.push(pushed[left]);
                    left++;
                }
            } else {
                if (right >= popped.length) return true;
                if (stack.pop().equals(popped[right])) {
                    right++;
                } else {
                    return false;
                }
            }
        }
    }
}
