package leetcode.hot;

/**
 * LeetCode206.java
 * Description: https://leetcode.cn/problems/reverse-linked-list/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/9/5
 */
public class LeetCode206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {

    }
}
