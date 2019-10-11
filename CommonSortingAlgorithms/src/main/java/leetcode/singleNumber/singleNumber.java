package leetcode.singleNumber;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 题目链接：https://leetcode-cn.com/problems/single-number/
 * 求出现一次的数字
 * 该问题最灵活的解法就是使用异或的方法来实现的
 */
public class singleNumber {
    public int singleNumber(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return -1;
        }
        Map<Integer, Integer> numberMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (!numberMap.containsKey(nums[i])) {
                numberMap.put(nums[i], 1);
            } else {
                numberMap.put(nums[i], numberMap.get(nums[i]) + 1);
            }
        }
        Set<Integer> keySet = numberMap.keySet();
        Iterator keyIterator = keySet.iterator();
        while(keyIterator.hasNext()) {
            Integer key = (Integer) keyIterator.next();
            if (numberMap.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }

    /**
     * 该方法是对上面上面方法的简练
     * @param nums
     * @return
     */
    public int singleNumberI(int[] nums){
        if (nums.length == 0 || nums == null) {
            return -1;
        }
        Map<Integer, Integer> numberMap = new HashMap();
        for(Integer i : nums){
            Integer count = numberMap.get(i);
            count = count == null ? 1 : ++count;
            numberMap.put(i, count);
        }
        for (Integer i : numberMap.keySet()){
            Integer count = numberMap.get(i);
            if (count == 1){
                return i;
            }
        }
        return -1;
    }

    /**
     * 采用异或定律实现该问题
     * 异或定律存在交换定律：将两个相同的数字先异或，这样两两异或就只剩下了0，让后在和最后的一个数字异或等到最终值.
     * @param nums
     * @return
     */
    public int singleNumberII(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1){
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }

    /**
     * 测试程序
     * @param args
     */
    public static void main(String[] args){
        singleNumber singleNumber = new singleNumber();
        singleNumber.singleNumberI(new int[]{1,2,3,4});
    }
}
