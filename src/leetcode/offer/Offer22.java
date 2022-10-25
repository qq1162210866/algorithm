package leetcode.offer;

/**
 * Offer22.java
 * Description: https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/?favorite=xb9nqhhg
 *
 * @author Peng Shiquan
 * @date 2022/10/25
 */
public class Offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode tmp = head;
        int size = 0;
        while (tmp != null) {
            tmp = tmp.next;
            size++;
        }
        int length = size - k;
        tmp = head;
        for (int i = 0; i < length; i++) {
            tmp = tmp.next;
        }
        return tmp;
    }

    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode cur = head;
        int length = 0;
        ListNode result = head;
        while (cur != null) {
            if (length >= k) {
                result = result.next;
            } else {
                length++;
            }
            cur = cur.next;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
