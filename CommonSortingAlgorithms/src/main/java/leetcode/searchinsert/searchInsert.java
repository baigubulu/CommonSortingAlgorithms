package leetcode.searchinsert;

/**
 * 题目链接：https://leetcode-cn.com/problems/search-insert-position/
 * 在有序链表中完成target的查找并返回索引
 */
public class searchInsert {
    /**
     * 盖世仙方法为o(n)
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (i + 1 != nums.length) {
                if (nums[i] < target && nums[i + 1] > target) {
                    return i + 1;
                }
            } else {
                if (nums[nums.length - 1] < target) {
                    return nums.length;
                }
            }
        }
        if (nums[0] > target) {
            return 0;
        } else {
            return  -1;
        }
    }

    /**
     * 使用二分查找来实现，时间复杂度可以减少到logn
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right =nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                return left = mid + 1;
            } else {
                return right = mid -1;
            }
        }
        return left;
    }
    public static void main(String args[]) {

    }
}
