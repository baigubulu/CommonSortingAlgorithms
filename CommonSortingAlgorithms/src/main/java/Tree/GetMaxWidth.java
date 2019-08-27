package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 获取二叉树最大宽度，借助队列queue实现
 */
public class GetMaxWidth {

    public static int getMaxWidth(BinaryTree.TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<BinaryTree.TreeNode> queue = new ArrayDeque<BinaryTree.TreeNode>();
        int maxWidth = 1;
        queue.add(root);

        while (true) {
            //当前数的宽度
            int len = queue.size();
            if (len == 0) {
                break;
            }
            //如果当前层 还有节点
            while (len > 0) {
                //弹出一个节点,队列的长度就减少1
                BinaryTree.TreeNode treeNode = queue.poll();
                len--;
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
                maxWidth = Math.max(maxWidth, queue.size());
            }
        }
        return maxWidth;
    }
}
