package leetcode.hot;

/**
 * LeetCode21.java
 * Description: https://leetcode.cn/problems/merge-two-sorted-lists/
 *
 * @author Peng Shiquan
 * @date 2022/8/12
 */
public class LeetCode21 {

    public static void main(String[] args) {
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode result = new ListNode();
        if (list1.val <= list2.val) {
            result.val = list1.val;
            result.next = mergeTwoLists(list1.next, list2);
        } else {
            result.val = list2.val;
            result.next = mergeTwoLists(list1, list2.next);
        }
        return result;
    }
}
