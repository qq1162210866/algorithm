package leetcode.offer;

/**
 * Offer06.java
 * Description: https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/?favorite=xb9nqhhg
 *
 * @author Peng Shiquan
 * @date 2022/10/18
 */
public class Offer06 {

    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[0];
        ListNode tmp = head;
        int size = 0;
        while (tmp != null) {
            size++;
            tmp = tmp.next;
        }
        int[] result = new int[size];
        tmp = head;
        int index = 0;
        while (tmp != null) {
            result[size - index - 1] = tmp.val;
            index++;
            tmp = tmp.next;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}