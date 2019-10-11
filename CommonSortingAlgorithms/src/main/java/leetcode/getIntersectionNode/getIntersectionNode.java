package leetcode.getIntersectionNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目连接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * 获取两个链表相交的点
 */
public class getIntersectionNode {
    /**
     * 当前最理想的解决方法：以指针A为例子，先遍历A链表的N个元素，后遍历B链表的M个元素，所以要话费O(M+N)的时间
     * 空间复杂度就是o(1)
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode apointer = headA;
        ListNode bpointer = headB;
        while (apointer != bpointer) {
            apointer = (apointer == null ? headB : apointer.next);
            bpointer = (bpointer == null ? headA : bpointer.next);
        }
        return apointer;
    }

    /**
     * 方法2：对链表A中的每一个节点a，遍历整个链表B并检查链表B中是否存在节点和a相同
     */
    /**
     * 方法3：遍历链表A并将每个节点的地址/引用存储到哈希表中，让后检查链表B中的每一个节点B是否存在与哈希表中，如果存在，则为找到相交的点了
     */
    public ListNode getIntersectionNodeList(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // 遍历headA
        Map<Integer, Integer> map = new HashMap();
        while (headA.next != null) {
            map.put(headA.val, headA.val);
            headA = headA.next;
        }
        // 遍历headB 找相交的节点
        while(headB.next != null) {
            if (!map.get(headB.val).equals(null)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
