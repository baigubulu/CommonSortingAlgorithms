package leetcode.Sqrt;

/**
 * 题目链接：https://leetcode-cn.com/problems/sqrtx/
 */
public class Sqrt {
    // 使用二分查找完成,该方法在使用过程中需要注意中间的计算过程可能存在溢出的情况，因此在定数类型的时候，必须要使用long
    public int sqrt(int x) {
        if (x < 1) {
            return x;
        }
        long i = 0;
        long j = x/2 + 1;
        while (i <= j) {
            long mid = (i + j) / 2;
            long sq = mid * mid;
            if (sq == x) {
                return (int)mid;
            } else if (sq < x) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return (int)j;
    }

    // 使用牛顿迭代法
    public int sqrtNewton(int x) {
        if (x == 0) {
            return 0;
        }
        long i = x;
        while(i > x / i) {
            i = (i + x / i) / 2;
        }
        return (int)i;
    }

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        sqrt.sqrt(4);
    }
}
