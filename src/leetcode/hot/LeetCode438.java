package leetcode.hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode438.java
 * Description: https://leetcode.cn/problems/find-all-anagrams-in-a-string/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/10/11
 */
public class LeetCode438 {
    public static void main(String[] args) {
        System.err.println(new LeetCode438().findAnagrams2("aa", "bb"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < sLength - pLength; i++) {
            if (isHeterotopia(s.substring(i, i + pLength), p)) {
                result.add(i);
            }
        }
        return result;
    }

    public boolean isHeterotopia(String s, String p) {
        if (s.length() != p.length()) return false;
        char[] sChars = s.toCharArray();
        Arrays.sort(sChars);
        char[] pChars = p.toCharArray();
        Arrays.sort(pChars);
        return Arrays.equals(sChars, pChars);
    }

    public List<Integer> findAnagrams2(String s, String p) {
        if (s.length() < p.length()) return new ArrayList<>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        int pLength = p.length();
        for (int i = 0; i < pLength; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        List<Integer> result = new ArrayList<>();
        if (Arrays.equals(sCount, pCount)) result.add(0);
        for (int i = 0; i < s.length() - pLength; i++) {
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i + pLength) - 'a']++;
            if (Arrays.equals(sCount, pCount)) result.add(i + 1);
        }
        return result;
    }

}
