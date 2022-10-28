package leetcode.offer;

import java.util.Stack;

/**
 * Offer30.java
 * Description: https://leetcode.cn/problems/bao-han-minhan-shu-de-zhan-lcof/?favorite=xb9nqhhg
 *
 * @author Peng Shiquan
 * @date 2022/10/28
 */
public class Offer30 {
    public static void main(String[] args) {

    }

}

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    //放入顶端一个元素
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            minStack.push(Math.min(minStack.peek(), x));
        }

    }

    //移除顶端元素
    public void pop() {
        stack.pop();
        minStack.pop();
    }

    //查看顶端元素
    public int top() {
        return stack.peek();
    }

    //返回最小元素
    public int min() {
        return minStack.peek();
    }
}
