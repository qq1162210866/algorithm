package leetcode.offer;

/**
 * Offer24.java
 * Description: https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof/?favorite=xb9nqhhg
 *
 * @author Peng Shiquan
 * @date 2022/10/25
 */
public class Offer24 {
    public ListNode reverseList(ListNode head) {
        ListNode result = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = new ListNode(cur.val);
            tmp.next = result;
            result = tmp;
            cur = cur.next;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
