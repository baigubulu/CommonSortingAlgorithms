package leetcode.climbStairs;

import java.util.HashMap;

/**
 * 传送门：https://leetcode-cn.com/problems/climbing-stairs/
 */
public class ClimbStairs {
    // 递归的方式
    public int climbStairs(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n -2);
//        return (n == 1 || n == 2) ? n : climbStairs(n - 2) + climbStairs(n - 1);
    }

    /**
     * 使用缓存的思想，解决问题
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int sum = climbStairs(n - 1) + climbStairs(n -2);
        map.put(n, sum);
        return sum;
    }

    public int climbStairs3(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int sum[] = new int[n];
        sum[0] = 1;
        sum[1] = 2;
        for (int i = 2; i < n; i++) {
            sum[i] = sum[i - 1] + sum[i - 2];
        }
        return sum[n - 1];
    }
}
