package Tree;

/**
 * 时间复杂度：最好：logn,最坏：n
 */
public class find {
    private BinaryTreeNode node;

    /**
     * 在二叉树中查找数值
     * @param key
     * @return
     */
    public BinaryTreeNode find(int key) {
        if (node == null) {
            return null;
        }
        BinaryTreeNode currentNode = node;
        if (currentNode.getValue() != key) {
            if (node.getValue() < key) {
                currentNode = currentNode.left;
            } else if (node.getValue() > key) {
                currentNode = currentNode.right;
            }
            if(currentNode == null) {
                return null;
            }
        }
        return currentNode;
    }
}
