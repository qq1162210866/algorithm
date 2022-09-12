package leetcode.hot;

/**
 * LeetCode19.java
 * Description: https://leetcode.cn/problems/remove-nth-node-from-end-of-list/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/9/12
 */
public class LeetCode19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = new ListNode(0, head);
        ListNode pre = result;
        ListNode tmp = null;
        ListNode cur = head;
        int i = 0;
        while (cur != null) {
            if (i < n) {
                i++;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        if (pre.next == null) {
            //n一定>=1
            return null;
        } else {
            tmp = pre.next.next;
        }
        pre.next = tmp;
        return result.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode result = new ListNode(0, head);
        ListNode pre = result;
        ListNode cur = head;
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }
        while (cur != null) {
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return result.next;
    }


    public static void main(String[] args) {
        new LeetCode19().removeNthFromEnd(new ListNode(1, new ListNode(2, null)), 2);
    }
}
