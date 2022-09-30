package leetcode.hot;

import java.util.Deque;
import java.util.LinkedList;

/**
 * LeetCode155.java
 * Description:
 *
 * @author Peng Shiquan
 * @date 2022/9/30
 */
public class LeetCode155 {
}

class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
        //放入一个值，做比较
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min(minStack.peek(), val));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}