package Tree;

/**
 * 删除二叉树中的节点，存在三种情况
 * 1. 删除的节点为叶子节点，直接删除就好
 * 2. 删除的节点有一个子节点，将下一个节点上移到该节点
 * 3. 删除的节点有两个子节点，将右节点的
 * 时间复杂度：最好：logn，最坏：logn
 */
public class delete {
    private BinaryTreeNode root;

    public boolean delete(int key) {
        if (this.root == null) {
            System.out.println("tree is empty");
            return false;
        }
        BinaryTreeNode targetParent = root;
        BinaryTreeNode target = root;
        boolean isLeftChild = true;
        while (target.getValue() != key) {
            if (key > target.getValue()) {
                targetParent = target;
                target = target.right;
                isLeftChild = false;
            } else {
                targetParent = target;
                target = target.left;
                isLeftChild = true;
            }
            if (target == null) {
                System.out.println("node dosen't exist");
                return  false;
            }
        }
        // 被删除的节点为叶子节点
        // 被删除的节点有一个叶子节点
        // 被删除的节点只有有节点
        // 被删除的节点只有左节点
        // 被删除节点有左右子节点，先找到后续节点，然后将后续节点插入至待删除节点的位置
        // 获取被删除节点的后序节点

        if(target.left == null && target.right == null){
            if(target.getValue() == root.getValue()){
                root = null;
                return true;
            }
            if(isLeftChild) {
                targetParent.left = null;
            } else {
                targetParent.right = null;
            }
        }
        else if(target.left == null &&
                target.right != null){
            if(target.getValue() == root.getValue()){
                root = root.right;
                return true;
            }
            if(isLeftChild) {
                targetParent.left = target.left;
            } else {
                targetParent.right = target.right;
            }
        }
        else if(target.left != null &&
                target.right == null){
            if(target.getValue() == root.getValue()){
                root = root.left;
                return true;
            }
            if(isLeftChild) {
                targetParent.left = target.left;
            }
            else {
                targetParent.right = target.left;
            }
        }
        //被删除节点有左右子节点，先找到后续节点，将，然后将后续节点插入至待删除节点的位置
        else{
            // 获取被删除节点的后序节点
            BinaryTreeNode followingNode = this.getFollowingNode(target);
            if(target.getValue() == root.getValue()) {
                root = followingNode;
            }

            else if(isLeftChild) {
                targetParent.left = followingNode;
            }

            else {
                targetParent.right = followingNode;
            }
            followingNode.left = target.left;
            followingNode.right = target.right;
        }
        return  true;
    }

    public BinaryTreeNode getFollowingNode(BinaryTreeNode node) {
        BinaryTreeNode node1 = new BinaryTreeNode();
        return node1;
    }
}
