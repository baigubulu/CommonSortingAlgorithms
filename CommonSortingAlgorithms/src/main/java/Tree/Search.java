package Tree;

public class Search {

    /**
     * 二叉查找树或者二叉搜索树，时间复杂度为o(logn)
     * @param node
     * @param data
     * @return
     */
    public BinaryTreeNode search(BinaryTreeNode node, int data) {
        if (node == null || node.getValue() == data) {
            return node;
        }

        if (node.getValue() > data) {
            return search(node.left, data);
        } else {
            return search(node.right, data);
        }
    }

    //树 - 插入排序 -- 递归
    public BinaryTreeNode searchAndInsert(BinaryTreeNode parentNode, BinaryTreeNode childNode, int data) {

        if (childNode == null) {
            //创建新的节点
            childNode = new BinaryTreeNode();
            childNode.setValue(data);
        }

        if (parentNode != null) {
            if (data < parentNode.getValue()) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }
            return childNode;
        }

        if (childNode.getValue() == data) {
            return childNode;
        } else if (data < childNode.getValue()) {
            return searchAndInsert(childNode, childNode.left, data);
        } else {
            return searchAndInsert(childNode, childNode.right, data);
        }
    }
}
