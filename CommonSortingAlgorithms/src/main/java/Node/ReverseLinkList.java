package Node;

import java.util.Stack;


public class ReverseLinkList {

    /**
     * 实现链表逆序数据，但不更改链表原有的顺序
     * 实现思想，借助栈 -- 先进后出的特性(stack)
     */
    public static void reverseLinkList_Stack(Node head){
        Stack<Node> stack = new Stack<Node>();
        Node node = head.getNext();

        while (node != null) {
            stack.push(node);
            node = node.getNext();
        }

        while (stack.size() > 0) {
            //pop的过程是单个推出数据的过程
            node = stack.pop();
            System.out.println(node.getData() + "->");
        }

        System.out.println("null");
    }

    /**
     * 实现思想：将整个链表反转，并打印输出，实现方法详见：reviseLinkedList3
     * @param head
     */
    public static void reverseLinkList(Node head){
        //不在进行代码实现
    }
}
