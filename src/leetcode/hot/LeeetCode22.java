package leetcode.hot;

import java.util.ArrayList;
import java.util.List;

/**
 * LeeetCode22.java
 * Description: https://leetcode.cn/problems/generate-parentheses/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/9/14
 */
public class LeeetCode22 {
    public static void main(String[] args) {
        System.err.println(new LeeetCode22().generateParenthesis(3));
    }

    List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        getParenthesis("", n, n);
        return result;
    }

    public void getParenthesis(String s, int left, int right) {
        //当左右括号都遍历完毕，将本次结果添加到结果集中
        if (left == 0 && right == 0) {
            result.add(s);
            return;
        }
        if (left == right) {
            //只能添加左括号
            getParenthesis(s + "(", left - 1, right);
        } else if (left < right) {
            //可以添加左括号，也可以添加右括号
            if (left > 0) {
                getParenthesis(s + "(", left - 1, right);
            }
            //因为要回溯，所以这里不能添加逻辑判断
            getParenthesis(s + ")", left, right - 1);
        }
    }
}
