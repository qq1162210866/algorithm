package leetcode.offer;

/**
 * Offer18.java
 * Description: https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/?favorite=xb9nqhhg
 *
 * @author Peng Shiquan
 * @date 2022/10/23
 */
public class Offer18 {
    public static void main(String[] args) {

    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) return head.next;
        ListNode cur = head.next;
        ListNode pre = head;
        while (cur != null) {
            if (cur.val == val) pre.next = cur.next;
            pre = cur;
            cur = cur.next;
        }
        return head;
    }
}
