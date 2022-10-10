package leetcode.hot;

import java.util.LinkedList;

/**
 * LeetCode394.java
 * Description:
 *
 * @author Peng Shiquan
 * @date 2022/10/10
 */
public class LeetCode394 {
    public static void main(String[] args) {

    }

    public String decodeString(String s) {
        int time = 0;
        StringBuilder res = new StringBuilder();
        LinkedList<Integer> times = new LinkedList<>();
        LinkedList<String> chars = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '[') {
                times.addLast(time);
                chars.addLast(res.toString());
                //
                time = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                //执行拼接操作
                int tmp = times.removeLast();
                StringBuilder stringTmp = new StringBuilder();
                for (int i = 0; i < tmp; i++) stringTmp.append(res);
                res = new StringBuilder().append(chars.removeLast()).append(stringTmp);

            } else if (c >= '0' && c <= '9') {
                time = time * 10 + Integer.parseInt(String.valueOf(c));
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
