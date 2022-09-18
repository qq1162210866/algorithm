package leetcode.hot;

import java.util.*;

/**
 * LeetCode49.java
 * Description: https://leetcode.cn/problems/group-anagrams/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/9/18
 */
public class LeetCode49 {
    public static void main(String[] args) {

        System.err.println(new LeetCode49().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String tmp = new String(chars);
            if (map.containsKey(tmp)) {
                map.get(tmp).add(s);
            } else {
                map.put(tmp, new ArrayList<String>() {{
                    add(s);
                }});
            }
        }
        return new ArrayList<>(map.values());
    }
}
