package leetcode.hot;

/**
 * LeetCode1.java
 * Description: https://leetcode.cn/problems/add-two-numbers/
 *
 * @author Peng Shiquan
 * @date 2022/8/8
 */
public class LeetCode1 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode last = null;
        ListNode head = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int iTmp = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = iTmp / 10;
            if (last == null) {
                last = new ListNode(iTmp % 10);
                head = last;
            } else {
                last.next = new ListNode(iTmp % 10);
                last = last.next;
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (carry > 0) {
            last.next = new ListNode(carry, null);
        }
        return head;
    }

    public static void main(String[] args) {

        ListNode result = new LeetCode1().addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3, null)))
                , new ListNode(5, new ListNode(6, new ListNode(4, null))));
        while (result != null) {
            System.out.printf(result.val + "");
            result = result.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
