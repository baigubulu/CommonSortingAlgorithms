package leetcode.maxProfit;

/**
 * 股票问题
 * 题目连接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class maxProfit {

    /**
     * 动态规划问题
     * 解决该问题需要满足两个条件：
     * 1. 数组中两个数字之间的最大差值
     * 2. 买入价格要大于卖出价格
     * 时间复杂度：O(n^2)
     * 空间复杂度:O(1)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    /**
     * 一次遍历解决问题
     * 找到最小价格和最大利润，经过一次遍历就能解决该问题的
     * 时间复杂度：O(n)
     * 空间复杂度: O(1)
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
                // 该数值可能是最大值，如果差值大约maxprofit，那么该数值就是当前找到的最大数值了
            } else if (prices[i] - minPrice > maxprofit) {
                maxprofit = prices[i] - minPrice;
            }
        }
        return maxprofit;
    }
}
