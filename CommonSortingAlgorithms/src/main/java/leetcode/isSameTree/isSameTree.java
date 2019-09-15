package leetcode.isSameTree;

/**
 * 题目链接：https://leetcode-cn.com/problems/same-tree/
 * 判断两个树是否相同
 */
public class isSameTree {
    /**
     * 深度优先遍历
     * 时间复杂度：O(n),n是树的节点个数
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        // 判断两个数值是否相等
        if (p.val != q.val) {
            return false;
        }
        // 判断左子树和右子树是否相等
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
