package leetcode.isBalanced;

/**
 * 题目链接：https://leetcode-cn.com/problems/balanced-binary-tree/
 * 判断一颗树是否是平衡二叉树
 * 高度平衡二叉树：一个二叉树每个节点的左右两个子树的高度差的绝对值不超过1(小于等于1)
 */
public class isBalanced {
    /**
     * 1. 使用DFS，以每一个节点root作为根节点的子树最大高度(左右子树中最大的高度值加1  max(left, right) +1
     * 2. 当有一颗树的左右子树的高度差 > 1的情况，代表此书不是平衡树，返回-1
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = depth(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1: -1;
    }
}
