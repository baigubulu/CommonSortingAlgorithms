package leetcode.hasCycle;


/**
 * 题目连接：https://leetcode-cn.com/problems/linked-list-cycle/
 * 判断链表中是否存在一个环，
 */
public class hasCycle {

    /**
     * 判断该链表是否有环存在
     * 使用双指针的方式来实现
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
