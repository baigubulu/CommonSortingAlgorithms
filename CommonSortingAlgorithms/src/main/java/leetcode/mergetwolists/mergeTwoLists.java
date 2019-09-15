package leetcode.mergetwolists;

/**
 * 题目链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 合并两个有序链
 */
public class mergeTwoLists {
    //

    /**
     * 使用递归的思想来实现，时间复杂度为o(m + n), m是l1的长度，n是l2的长度
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}
