package Tree;

public class GetMaxAndMin {
    /**
     * 找到最小值：左节点的左孩子
     * @param node
     * @return
     */
    public BinaryTreeNode getMin(BinaryTreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public BinaryTreeNode getMax(BinaryTreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            node = node.right;
        }
        return node;
    }
}
