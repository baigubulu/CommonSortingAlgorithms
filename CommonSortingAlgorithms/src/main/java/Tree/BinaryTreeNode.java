package Tree;

public class BinaryTreeNode {
    private int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryTreeNode(){}

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    BinaryTreeNode root;

    public BinaryTreeNode(int[] array) {
        root = makeBinaryTreeByArray(array, 1);
    }

    //将数列整理成二叉树
    public static BinaryTreeNode makeBinaryTreeByArray(int[] array, int index) {
        if (index < array.length) {
            int value = array[index];
            if (value != 0) {
                BinaryTreeNode treeNode = new BinaryTreeNode(value);
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
}
