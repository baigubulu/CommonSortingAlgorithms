package leetcode.isSymmetric;

/**
 * 题目连接：https://leetcode-cn.com/problems/symmetric-tree/
 *  判断两个树是否相似
 */
public class isSymmetric {
    // 将树分成两个，左子树和右子树进行对比
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return  false;
        }
        return (t1.val == t2.val) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
    }
}
