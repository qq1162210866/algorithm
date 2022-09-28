package leetcode.hot;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LeetCode139.java
 * Description: https://leetcode.cn/problems/word-break/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/9/28
 */
public class LeetCode139 {
    public static void main(String[] args) {

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        //外层遍历字符串
        for (int i = 1; i <= length; i++) {
            //内层由0遍历到i，看是否可以组成字符串
            for (int j = 0; j < i; j++) {
                if (dp[j] && words.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length];
    }
}
