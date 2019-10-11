package leetcode.twoSum;

/**
 * 题目连接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * 解决该问题有三种方法：
 * 1. O(n^2)的时间复杂度和O(1)的空间复杂度的暴力方法解决
 * 2. 哈希表的方式：O(n) 和 O(n)
 * 3. 双指针的方式
 */
public class twoSum {
    /**
     * ji选择两个指针，两个指针分别位于头部和尾部，初始分别位于第一个元素和最后一个元素位置，比较这两个元素之和与目标值的大小。如果和等于目标值，我们发现了这个唯一解。如果比目标值小，我们将较小元素指针增加1。如果比目标值大，我们将较大指针减小一。
     * 当前选用的方法，时间复杂度为o(n),空间复杂度o(1)
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                if (low > high) {
                    return new int[]{-1, -1};
                }
                return new int[]{low+1, high+1};
            } else if(sum < target) {
                low++;
            } else if (sum > target) {
                high--;
            }
        }
        return new int[] {-1, -1};
    }
}
