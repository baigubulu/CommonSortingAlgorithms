package Node;

public class LinkedList {

    public Node head;

    /**
     * 根据数组创建链表，存在head节点
     * @param array
     */
    public Node createLinkList(int[] array){
        //真正插入数据的节点
        Node pnew;
        //创建指针变量
        Node ptail = new Node();
        head = ptail;
        for (int i = 0; i < array.length; i++){
            pnew = new Node(array[i]);
            ptail.setNext(pnew);
            //ptail移动位置的过程
            ptail = pnew;
        }
        return head;
    }

    /**
     * 正序输出链表的内容
     */
    public void displayLinkList(){
        Node node = head.getNext();
        while (node != null) {
            System.out.println(node.getData() + "--->");
            node = node.getNext();
        }
        System.out.println("null");
    }

    /**
     * 查找倒数第k个元素
     * @param head
     * @param k
     * @return
     */
    public Node findEle(Node head, int k) {
        if (k < 1) {
            return null;
        }

        Node cur1 = head;
        Node cur2 = head;

        for (int count = 0; count < k - 1; count++) {
            cur1 = cur1.getNext();
        }

        while (cur1 != null) {
            cur1 = cur1.getNext();
            //cur2就是第K个元素
            cur2 = cur2.getNext();
        }
        //返回倒数第k个元素
        return cur2;
    }

    //求链表的长度
    public int length(Node head) {
        Node node = head;
        int length = 0;
        while (node.getNext() != null) {
            length++;
            node = node.getNext();
        }
        return length;
    }

    //

    /**
     * 链表反转  方法1 -- 递归调用
     * head: 前一节点的指针域
     * reHead: 反转后新链表的头结点
     * @param head
     * @return
     */
    public Node reviseLinkedList(Node head) {
        if (head == null && head.getNext() == null) {
            return head;
        } else {
            Node preNode = reviseLinkedList(head.getNext());
            //下一个节点指向头部节点
            head.getNext().setNext(head);
            //反转之后，head位于链表的尾部
            head.setNext(null);
            return preNode;
        }
    }

    //链表反转  方法2 -- 此时需要两个指针来完成链表的反转(循环实现功能)

    /**
     * 将当前节点cur的下一个节点缓存到temp后，然后更改当前节点指针指向上一节点pre，反转当前节点的指针域用tmp临时保存，以便下一次使用。
     * @param node
     * @return
     */
    public Node reviseLinkedList2(Node node) {
        if (head == null) {
            return null;
        }
        //newNode类似于head接口，并没有确定的值存在
        Node newNode = null;
        Node curNode = node;

        while (curNode != null) {
            Node tmpNode = curNode.getNext();
            //当为null的时候，是head指针
            curNode.setNext(newNode);
            //移动指针的过程，新链表的头
            newNode = curNode;
            //下一个head为当前需要处理的节点
            curNode = tmpNode;
        }
        return newNode;
    }

    //实现链表反转，比较好理解方式
    public void reviseLinkedList3(){
        if (head == null || head.getNext() == null){
            return;
        } else {
            //创建两个指针
            Node p = head.getNext();
            Node q = head.getNext().getNext();
            p.setNext(null);
            Node tmp = null;
            while(q != null){
                //都需要首先找到链表的下一个节点
                tmp = q.getNext();
                q.setNext(p);
                p = q;
                q = tmp;
            }
            if (q == null){
                head.setNext(p);
                q = null;
            }
        }
    }

    //链表排序 -- 双指针完成功能
    public Node sortLinkedList(Node head) {
        // 这里面涉及到值传递和指针传递
        Node tmp = head;
        Node secondTmp = head.getNext();
        while (tmp.getNext() != null) {
            while (secondTmp.getNext() != null) {
                if (tmp.getNext().getData() > secondTmp.getNext().getData()) {
                    int temp = secondTmp.getNext().getData();
                    secondTmp.getNext().setData(tmp.getNext().getData());
                    tmp.getNext().setData(temp);
                }
                secondTmp = secondTmp.getNext();
            }
            tmp = tmp.getNext();
            secondTmp = tmp.getNext();
        }
        //打印整个链表
        while (head.getNext() != null) {
            System.out.println(head.getNext().getData());
            head = head.getNext();
        }
        return head;
    }

    /**
     * 删除基数位的节点
     * @param head
     */
    public Node delOddLinkedList(Node head) throws Exception{
        if (head == null) {
            throw new Exception("current node is null");
        }
        int size = getLength(head);
        for (int index = 1; index < size; index += 2){

            if (head != null) {
                head = deleteElement(head, index);
            }
        }
        return head;
    }

    private Node deleteElement(Node head, int index) {
        int size =  getLength(head);
        if (index == 0) {
            return deleteHead(head);
        } else if (index == size -1) {
            deleteTail(head);
        } else {
            Node pre = head;
            while (pre.getNext() != null && index > 1) {
                pre = pre.getNext();
                index--;
            }
            if (pre.getNext() != null) {
                pre.setNext(pre.getNext().getNext());
            }
        }
        return head;
    }

    private Node deleteHead(Node head) {
        return head.getNext();
    }

    private void deleteTail(Node head) {
        Node dummyHead = head;
        while (dummyHead.getNext() != null && dummyHead.getNext().getNext() != null) {
            dummyHead = dummyHead.getNext();
        }
        dummyHead.setNext(null);
    }
    private int getLength(Node head) {
        if (head == null) {
            return 0;
        }
        int len = 0;
        while (head!= null) {
            len++;
            head = head.getNext();
        }
        return len;
    }

    public static void main(String[] args) {
        int array[] = {2,3,1,4};
        LinkedList linkedList = new LinkedList();
        Node head = linkedList.createLinkList(array);
        linkedList.sortLinkedList(head);
    }
}
