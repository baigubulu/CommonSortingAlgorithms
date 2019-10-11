package leetcode.maxProfit;

/**
 * 完成股票的多次买卖
 * 题目链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class maxProfitII {
    public int maxProfit(int[] prices) {
        return calculate(prices, 0);
    }

    /**
     * 计算子的字符串
     * 时间复杂度:O(n^n)
     * 空间复杂度：O(n)
     * @param prices
     * @param s
     * @return
     */
    public int calculate(int prices[], int s) {
        if (s >= prices.length) {
            return 0;
        }
        int max = 0;
        for (int start = s; start < prices.length; start++) {
            int maxProfit = 0;
            for (int i = start + 1; i < prices.length; i++) {
                // 判断当前价格是否满足增长的条件
                if (prices[start] < prices[i]) {
                    // 计算利润的总和
                    int profit = calculate(prices, i+1) + prices[i] - prices[start];
                    if (profit > maxProfit) {
                        maxProfit = profit;
                    }
                }
            }
            if (maxProfit > max) {
                max = maxProfit;
            }
        }
        return max;
    }

    /**
     * 简单的实现方法，只要上涨就卖出
     * @param prices
     * @return
     */
    public int maxProfitII(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i-1];
            if (tmp > 0) {
                profit += tmp;
            }
        }
        return profit;
    }

    /**
     * 该种方法的解决，之关系波峰和波谷，用波峰的所有值 - 波谷的所有值
     * 时间复杂度：o(n)
     * 空间复杂度：o(1)
     * @param prices
     * @return
     */
    public int maxProfitIII(int[] prices) {
        int i = 0;
        int valley;
        int peak;
        int maxprofit = 0;
        while (i < prices.length -1) {
            // 找波谷的过程
            while (i < prices.length - 1 && prices[i] >= prices[i+1]){
                i++;
            }
            valley = prices[i];
            // 找波峰的过程
            while (i < prices.length -1 && prices[i] <= prices[i+1]) {
                i++;
            }
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        maxProfitII maxProfitII = new maxProfitII();
        int[] testCase = {7,1,5,3,6,4};
        int profit = maxProfitII.maxProfitII(testCase);
        System.out.println(profit);
    }
}
