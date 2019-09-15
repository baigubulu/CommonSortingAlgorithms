package leetcode.levelOrderBottom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 题目连接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * 二叉树的层次遍历
 */
public class levelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, 0, res);
        Collections.reverse(res);
        return res;
    }

    // 添加root 添加到 list中

    /**
     *
     * @param root
     * @param depth : 当前的深度
     * @param res
     */
    public void helper(TreeNode root, int depth, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        // 到了一个新的深度，需要扩充list
        if (depth + 1 > res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(depth).add(root.val);
        if (root.left != null) {
            helper(root.left, depth+1, res);
        }
        if (root.right != null) {
            helper(root.right, depth+1, res);
        }
    }
}
