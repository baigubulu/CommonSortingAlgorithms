package leetcode.majorityElement;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目连接：https://leetcode-cn.com/problems/majority-element/
 * 该题目中保证一定会产生一个众数，所以无需对n/2进行比较了
 */
public class majorityElement {

    /*
    使用hash表存储每个元素，然后使用一个循环在线性时间内遍历nums，然后我们只需要返回最大的键值就可以了
    时间复杂度为o(n),空间复杂度为:O(n)
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);
        Map.Entry<Integer, Integer> majority = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majority == null || entry.getValue() > majority.getValue()) {
                majority = entry;
            }
        }
        return majority.getKey();
    }

    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num) + 1);
            }
        }
        return counts;
    }

    /**
     * 投票的方法解决问题
     * 时间复杂度o(n), 空间复杂度o(1)
     * 投票方法就是出现次数的问题，如果该数字是众数，那么该数字出现的的次数是最多的，他的count就是最大的。
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
