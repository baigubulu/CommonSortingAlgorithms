package Node;

/**
 * 定义链表节点
 */
public class Node {

    private int data;
    private Node next;

    public Node(){}

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
