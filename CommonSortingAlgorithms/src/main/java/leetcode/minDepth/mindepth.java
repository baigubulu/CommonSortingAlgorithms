package leetcode.minDepth;

import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;
import javafx.util.Pair;

import java.util.LinkedList;

/**
 * 题目链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * 求二叉树的最小深度
 */
public class mindepth {
    /**
     * 使用递归 + 深度优先搜索 解决该问题
     * 时间复杂度： o(N)
     * 空间复杂度： 该树在非平衡的情况下：o(N). 该树在平衡的情况下：o(logN), 因此空间复杂度为：o(logN)
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if ((root.left == null) && (root.right == null)) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }
        return min_depth + 1;
    }

    /**
     * 深度优先搜索迭代的方式解决该问题
     * 利用栈将递归变成迭代的方式解决该问题
     * 时间复杂度：o(N), 空间复杂度：o(N)
     * Pair(配对): 简单的键值对映射关系，也可以完成类型的转换
     * pair 的应用场景：当key 和 value都保存具体的信息的时候，我们需要用到Pair相关的内容，可以认为Pair保存的是一个信息对，没有key 和 value之分，这两个信息都是我们需要的
     * Pair<String, String> pair = new Pair<>("aku", "female");
     * pair.getKey();
     * pair.getValue();
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root) {
        /**
         * pair 中的两个节点存放的是root 和 对应的当前深度
         */
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList();
        if (root == null) {
            return 0;
        } else {
            stack.add(new Pair<TreeNode, Integer>(root, 1));
        }

        int min_depth = Integer.MAX_VALUE;

        /**
         * 父节点弹出栈，子节点压进栈
         */
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.pollLast();
            root = current.getKey();
            int current_depth = current.getValue();
            if (root.left == null && root.right == null) {
                min_depth = Math.min(min_depth, current_depth);
            }
            if (root.left != null) {
                stack.add(new Pair<>(root.left, current_depth + 1));
            }
            if (root.right != null) {
                stack.add(new Pair<>(root.right, current_depth + 1));
            }
        }
        return min_depth;
    }
}
