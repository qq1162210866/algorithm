package leetcode.offer;

/**
 * Offer05.java
 * Description: https://leetcode.cn/problems/ti-huan-kong-ge-lcof/?favorite=xb9nqhhg
 *
 * @author Peng Shiquan
 * @date 2022/10/18
 */
public class Offer05 {
    public static void main(String[] args) {

    }

    public String replaceSpace(String s) {
        StringBuilder result = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ') result.append("%20");
            else result.append(s.charAt(i));
        }
        return result.toString();

    }
}
