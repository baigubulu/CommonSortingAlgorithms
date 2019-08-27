package Tree;

//实现树的前序遍历，中序遍历以及后续遍历
public class TreeIterate {

    /**
     * 前序遍历
     * 首先打印根节点
     *
     * @param node
     */
    public void iterateFirstOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        operate(node);
        iterateFirstOrder(node.left);
        iterateFirstOrder(node.right);
    }

    /**
     * 中序遍历，其实就是顺序进行打印，左中右
     * 中间打印根节点
     *
     * @param node
     */
    public void iterateMediumOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        iterateMediumOrder(node.left);
        operate(node);
        iterateMediumOrder(node.right);
    }

    /**
     * 后序遍历
     * 最后打印根节点
     *
     * @param node
     */
    public void iterateLastOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        iterateLastOrder(node.left);
        iterateLastOrder(node.right);
        operate(node);
    }

    public static void operate(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.getValue());
    }

    //测试程序
    public static void main(String[] agrs) {
        //队列数组
        int[] array = {0,13,65,5,97,25,0,37,22,0,4,28,0,0,32,0};
        BinaryTreeNode binaryTree = new BinaryTreeNode(array);
        TreeIterate treeIterate =  new TreeIterate();
        treeIterate.iterateFirstOrder(binaryTree);
    }
}
