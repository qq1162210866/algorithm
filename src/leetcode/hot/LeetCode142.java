package leetcode.hot;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode142.java
 * Description: https://leetcode.cn/problems/linked-list-cycle-ii/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/9/28
 */
public class LeetCode142 {
    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        Map<ListNode, Integer> tmp = new HashMap<>();
        ListNode cur = head;
        while (cur != null) {
            if (tmp.containsKey(cur)) {
                return cur;
            }
            tmp.put(cur, 0);
            cur = cur.next;
        }
        return null;
    }
}
