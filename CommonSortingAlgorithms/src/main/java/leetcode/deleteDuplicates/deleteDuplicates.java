package leetcode.deleteDuplicates;

/**
 * 题目链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head;
        while(node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }
}
