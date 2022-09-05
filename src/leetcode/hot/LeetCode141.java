package leetcode.hot;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode141.java
 * Description: https://leetcode.cn/problems/linked-list-cycle/
 *
 * @author Peng Shiquan
 * @date 2022/8/22
 */
public class LeetCode141 {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode now = head;
        while (now != null) {
            if (map.containsKey(now)) {
                return true;
            }
            map.put(now, null);
            now = now.next;
        }
        return false;
    }
}
