package Tree;

/**
 * 获取二叉树最大深度
 * 递归调用
 */
public class GetMaxDepth {

    public static int getMaxDepth(BinaryTree.TreeNode root){
        if (root == null){
            return  0;
        }
        int left = getMaxDepth(root.left);
        int right = getMaxDepth(root.right);

        return Math.max(left, right) + 1;
    }

}
