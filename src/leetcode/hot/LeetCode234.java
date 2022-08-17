package leetcode.hot;

/**
 * LeetCode234.java
 * Description: https://leetcode.cn/problems/palindrome-linked-list/
 *
 * @author Peng Shiquan
 * @date 2022/8/17
 */
public class LeetCode234 {

    public static void main(String[] args) {
        System.err.println(new LeetCode234().isPalindrome(new ListNode(1, new ListNode(2, new ListNode(1, null)))));
    }

    public boolean isPalindrome(ListNode head) {

        ListNode tmp = reverseList(head);
        while (tmp != null) {
            if (tmp.val != head.val) return false;
            head = head.next;
            tmp = tmp.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        ListNode result = new ListNode(head.val, null);
        ListNode tmp = head.next;
        while (tmp != null) {
            ListNode cur = new ListNode(tmp.val, result);
            tmp = tmp.next;
            result = cur;
        }
        return result;
    }
}
