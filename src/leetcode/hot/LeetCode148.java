package leetcode.hot;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * LeetCode148.java
 * Description: https://leetcode.cn/problems/sort-list/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/9/29
 */
public class LeetCode148 {
    public static void main(String[] args) {

    }

    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        ListNode tmp = head;
        List<Integer> nums = new ArrayList<>();
        while (tmp != null) {
            nums.add(tmp.val);
            tmp = tmp.next;
        }
        nums.sort(Comparator.comparingInt(o -> o));
        ListNode result = null;
        for (Integer num : nums) {
            if (result == null) {
                result = new ListNode(num);
                tmp = result;
            } else {
                tmp.next = new ListNode(num);
                tmp = tmp.next;
            }
        }
        return result;
    }

}

