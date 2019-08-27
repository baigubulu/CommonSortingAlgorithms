package Tree;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * 二叉树的特点，左节点一定小于根节点，右节点一定大于根节点
 */
public class BinaryTree {
    //static只能用在内部类中
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    TreeNode root;

    public BinaryTree(int[] array) {
        root = makeBinaryTreeByArray(array, 1);
    }

    //将数列整理成二叉树，index的默认值为1
    public static TreeNode makeBinaryTreeByArray(int[] array, int index) {
        if (index < array.length) {
            int value = array[index];
            if (value != 0) {
                TreeNode treeNode = new TreeNode(value);
                //将已经创建树节点的数值至0
                array[index] = 0;
                //创建左节点
                treeNode.left = makeBinaryTreeByArray(array, index * 2);
                //创建右节点
                treeNode.right = makeBinaryTreeByArray(array, index * 2 + 1);
                return treeNode;
            }
        }
        return null;
    }

    /**
     * 深度遍历 -- 使用栈(stack)相关的知识
     * 1. 将数组转换成二叉树
     * 2. 创建栈
     * 3. 在栈中完成数据相关的操作
     */
    public void depthOrderTraversal() {
        if (root == null) {
            System.out.println("empty tree");
            return;
        }

        //栈 -- 先进后出
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println("pop node value:" + node);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        System.out.println("\n");
    }

    /**
     * 广度遍历 -- 使用到队列(queue)相关的知识
     * 1. 将数组转换成二叉树
     * 2. 创建队列
     * 3. 在队列中完成数据相关的操作
     */
    public void levelOrderTraversal() {
        if (root == null) {
            System.out.println("empty tree");
            return;
        }

        //队列 -- 先进先出
        ArrayDeque<TreeNode> queue = new ArrayDeque();
        queue.add(root);
        while (queue.isEmpty() == false) {
            TreeNode node = queue.remove();
            System.out.println("Queue node value" + node);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    //实验函数
    public static void main(String[] args) {
        int array[] = {0,13,65,5,97,25,0,37,22,0,4,28,0,0,32,0};
        //在每次舒适化的时候，完成数组创建树
        BinaryTree binaryTree = new BinaryTree(array);
        binaryTree.depthOrderTraversal();
        binaryTree.levelOrderTraversal();
    }
}
