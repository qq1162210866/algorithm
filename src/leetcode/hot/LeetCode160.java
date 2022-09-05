package leetcode.hot;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode160.java
 * Description: https://leetcode.cn/problems/intersection-of-two-linked-lists/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/9/5
 */
public class LeetCode160 {

    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        while (a != null) {
            ListNode b = headB;
            while (b != null) {
                if (a == b) return a;
                b = b.next;
            }
            a = a.next;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode a = headA;
        while (a != null) {
            map.put(a, 0);
            a = a.next;
        }
        a = headB;
        while (a != null) {
            if (map.containsKey(a)) return a;
            a = a.next;
        }
        return null;
    }

    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        if (a == null && b == null) return null;
        //为null有两种情况，都需要处理，这里不能把是否都为null当作跳出条件
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

}
