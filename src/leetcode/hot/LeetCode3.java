package leetcode.hot;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LeetCode3.java
 * Description: https://leetcode.cn/problems/longest-substring-without-repeating-characters/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/9/9
 */
public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        char[] sChars = s.toCharArray();
        int length = sChars.length;
        for (int i = 0; i < length; i++) {
            int tmp = 1;
            Set<Character> tmp2 = new HashSet<>();
            tmp2.add(sChars[i]);
            for (int j = i + 1; j < length; j++) {
                if (tmp2.contains(sChars[j])) {
                    break;
                }
                tmp++;
                tmp2.add(sChars[j]);
            }
            result = Math.max(tmp, result);
        }
        return result;
    }

    public int lengthOfLongestSubstring2(String s) {
        int result = 0;
        int left = 0;
        //更新每个字符出现当最新下标
        Map<Character, Integer> map = new HashMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(s.charAt(i))) {
                //如果发现重复字符，需要更新左指针节点
                //当字符串为abba，因为left会变小，所以要加上限定，限制left只能左移
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            //计算字串长度.i-left+1   i相当于右指针，left为左指针
            result = Math.max(result, i - left + 1);
        }
        return result;
    }


    public static void main(String[] args) {
        System.err.println(new LeetCode3().lengthOfLongestSubstring2("abba"));
    }
}
