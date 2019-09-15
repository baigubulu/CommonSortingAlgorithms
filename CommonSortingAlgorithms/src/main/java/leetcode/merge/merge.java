package leetcode.merge;

/**
 * 题目链接：https://leetcode-cn.com/problems/merge-sorted-array/
 * 合并两个有序数组
 */
public class merge {
    /**
     * 解题思路：从后往前进行比较，将结果放置到num1 数组中
     * @param nums1
     * @param m : num1实际的数组长度
     * @param nums2
     * @param n : num2 实际数组数组长度
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n -1;
        while (len1 >= 0 && len2 >= 0) {
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }
        // 将num2剩余的元素拷贝到num1中
        System.arraycopy(nums2, 0, nums1, 0, len2+1);
    }
}
