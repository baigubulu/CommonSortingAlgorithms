package Tree;

/**
 * 在树中插入节点
 * 时间复杂度：最坏：n，最好：logn
 */
public class insert {
    public BinaryTreeNode root;
    public find find;

    public boolean insert(BinaryTreeNode node) {
        if (node == null) {
            return false;
        }
        if (root == null) {
            root = node;
            return true;
        }
        if (find.find(node.getValue()) != null) {
            System.out.println("该节点已经存在于树中");
            return false;
        }
        BinaryTreeNode currentNode =node;
        while (node != null) {
            if (node.getValue() > currentNode.getValue()) {
                if (node.right == null) {
                    currentNode.right = node;
                    return true;
                }
                currentNode = currentNode.right;
            }

            if (node.getValue() < currentNode.getValue()) {
                if (node.left == null) {
                    currentNode.left = node;
                    return true;
                }
                currentNode = currentNode.left;
            }
        }
        return false;
    }
}
