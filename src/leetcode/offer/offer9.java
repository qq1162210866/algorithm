package leetcode.offer;

import java.util.Stack;

/**
 * offer9.java
 * Description: https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/?favorite=xb9nqhhg
 *
 * @author Peng Shiquan
 * @date 2022/10/16
 */
public class offer9 {
    public static void main(String[] args) {

    }

}

class CQueue {
    Stack<Integer> in;
    Stack<Integer> out;

    public CQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        if (out.isEmpty()) return -1;
        return out.pop();
    }
}