package leetcode.offer;

/**
 * Offer25.java
 * Description: https://leetcode.cn/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/?favorite=xb9nqhhg
 *
 * @author Peng Shiquan
 * @date 2022/10/26
 */
public class Offer25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode result = null;
        if (l1.val <= l2.val) {
            result = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            result = new ListNode(l2.val);
            l2 = l2.next;
        }
        ListNode cur = result;
        ListNode left = l1;
        ListNode right = l2;
        while (left != null || right != null) {
            if (left == null) {
                cur.next = right;
                break;
            }
            if (right == null) {
                cur.next = left;
                break;
            }
            if (left.val <= right.val) {
                cur.next = new ListNode(left.val);
                cur = cur.next;
                left = left.next;
            } else {
                cur.next = new ListNode(right.val);
                cur = cur.next;
                right = right.next;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
