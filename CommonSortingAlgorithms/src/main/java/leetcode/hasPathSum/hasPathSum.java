package leetcode.hasPathSum;

import java.util.LinkedList;

/**
 * 题目链接：https://leetcode-cn.com/problems/path-sum/
 */
public class hasPathSum {
    /**
     * 递归的方式完成整棵树的遍历：如果当前节点不是叶子节点，那么就要对他的所有孩子节点完成递归调用，sum值要减去当前节点的权值;如果当前节点就是叶子，检查sum值是否为0，也就是是否找到给定的目标值
     * 时间复杂度：o(N)
     * 空间复杂度：最好：o(logN) 最坏：o(N)
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (null == root) {
            return  false;
        }

        sum -= root.val;
        if ((root.left == null) && (root.right == null)) {
            return sum == 0;
        }

        // 递归的出口程序
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    /**
     * 实现方法2：深度优先遍历除了在最坏情况下比广度优先遍历慢
     * 从包含根节点的栈开始模拟，剩余目标和为 sum - root.val;
     * 开始迭代： 弹出当前元素，如果当前剩余目标和为0，并且在叶子节点上返回true;
     * 如果剩余和不为0并且还处在非叶子节点上，将当前节点的所有孩子以及对应的剩余和压入栈中
     * 时间复杂度：o(N)
     * 空间复杂度：o(logN)
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        LinkedList<TreeNode> node_stack = new LinkedList();
        LinkedList<Integer> sum_stack = new LinkedList();

        node_stack.add(root);
        sum_stack.add(sum - root.val);

        TreeNode node;
        int cur_sum;

        while(!node_stack.isEmpty()) {
            node = node_stack.pollLast();
            cur_sum = sum_stack.pollLast();
            if ((node.right == null) && (node.left == null) && (cur_sum == 0)) {
                return true;
            }
            if (node.right != null) {
                node_stack.add(node.right);
                sum_stack.add(cur_sum - node.right.val);
            }

            if (node.left != null) {
                node_stack.add(node.left);
                sum_stack.add(cur_sum - node.left.val);
            }
        }
        return  false;
    }
}
