package leetcode.sortedArrayToBST;

/**
 * 题目链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * 有序数组转换成高度平衡的二叉搜索树
 * 高度平衡：一个二叉树每个节点的左右两个子树的高度差的绝对值不超过1
 */
public class sortedArrayToBST {
    /**
     * 递归的思想实现该问题
     * 实际的问题就是区间分治类
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start == end) {
            return null;
        }
        int mid = (start + end) >>> 1;
        // 创建根节点
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, start, mid);
        root.right = sortedArrayToBST(nums, mid + 1, end);
        return root;
    }
}
