package leetcode.hot;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode17.java
 * Description: https://leetcode.cn/problems/letter-combinations-of-a-phone-number/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/9/12
 */
public class LeetCode17 {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        List<List<String>> tmp = new ArrayList<>();
        tmp.add(new ArrayList<>());
        tmp.add(new ArrayList<>());
        tmp.add(new ArrayList<String>() {{
            add("a");
            add("b");
            add("c");
        }});
        tmp.add(new ArrayList<String>() {{
            add("d");
            add("e");
            add("f");
        }});
        tmp.add(new ArrayList<String>() {{
            add("g");
            add("h");
            add("i");
        }});
        tmp.add(new ArrayList<String>() {{
            add("j");
            add("k");
            add("l");
        }});
        tmp.add(new ArrayList<String>() {{
            add("m");
            add("n");
            add("o");
        }});
        tmp.add(new ArrayList<String>() {{
            add("p");
            add("q");
            add("r");
            add("s");
        }});
        tmp.add(new ArrayList<String>() {{
            add("t");
            add("u");
            add("v");
        }});
        tmp.add(new ArrayList<String>() {{
            add("w");
            add("x");
            add("y");
            add("z");
        }});
        char[] nums = digits.toCharArray();
        for (char c : nums) {
            if (result.isEmpty()) {
                result.addAll(tmp.get((int) c - 48));
            } else {
                List<String> tmp2 = new ArrayList<>();
                for (String s : result) {
                    for (String s1 : tmp.get((int) c - 48)) {
                        tmp2.add(s + s1);
                    }
                }
                result = tmp2;
            }
        }
        return result;
    }

    List<String> res = new ArrayList<>();

    String[] lettersArray = new String[]{
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    public List<String> letterCombinations2(String digits) {
        if (digits.length() == 0) return res;
        findCombination(digits, 0, "");
        return res;
    }

    public void findCombination(String digits, int index, String s) {
        //当递归到最后一位时，需要组装答案，添加到结果集中
        if (index == digits.length()) {
            res.add(s);
            return;
        }
        String letters = lettersArray[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombination(digits, index + 1, s + letters.charAt(i));
        }
    }


    public static void main(String[] args) {
        System.err.println(new LeetCode17().letterCombinations2("23"));

    }
}
