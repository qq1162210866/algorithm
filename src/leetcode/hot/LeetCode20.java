package leetcode.hot;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * LeetCode20.java
 * Description: https://leetcode.cn/problems/valid-parentheses/
 *
 * @author Peng Shiquan
 * @date 2022/8/9
 */
public class LeetCode20 {
    public static void main(String[] args) {
        System.err.println(new LeetCode20().isValid("()[]{"));
    }

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        if (chars.length % 2 == 1) return false;
        Deque<Character> st = new LinkedList<>();
        for (char b : chars) {
            switch (b) {
                case '(':
                case '[':
                case '{':
                    st.push(b);
                    break;
                case ')':
                    if (st.isEmpty() || !st.peek().equals('(')) return false;
                    st.pop();
                    break;
                case ']':
                    if (st.isEmpty() || !st.peek().equals('[')) return false;
                    st.pop();
                    break;
                case '}':
                    if (st.isEmpty() || !st.peek().equals('{')) return false;
                    st.pop();
                    break;
                default:
                    return false;
            }
        }
        return st.isEmpty();
    }


}