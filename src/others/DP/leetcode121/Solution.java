package others.DP.leetcode121;

public class Solution {
    /*
    动态规划
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        // 特殊判断
        if (len < 2) {
            return 0;
        }
        int[][] dp = new int[len][2];

        // dp[i][0] 下标为 i 这天结束的时候，不持股，手上拥有的现金数
        // dp[i][1] 下标为 i 这天结束的时候，持股，手上拥有的现金数

        // 初始化：不持股显然为 0，持股就需要减去第 1 天（下标为 0）的股价
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        // 从第 2 天开始遍历
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }

    /*
    优化思路1：滚动数组
    出发点：今天的状态只需要依据昨天的状态得出，故只需要两行即可以解决问题
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int[][] dp = new int[2][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i % 2][0] = Math.max(dp[(i - 1) % 2][0], dp[(i - 1) % 2][1] + prices[i]);
            dp[i % 2][1] = Math.max(dp[(i - 1) % 2][1], -prices[i]);
        }
        return dp[(len - 1) & 1][0];
    }
     */

    /*
    优化思路2：  下标为 i 的行并且状态为 0 的行参考了上一行状态为 0 和 1 的行；
                下标为 i 的行并且状态为 1 的行只参考了上一行状态为 1 的行。
    故可以将优化思路1中的两行合并成一行，对于新的一天，先计算这一天状态为0的值更改，再计算状态为1的值更改。
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            dp[1] = Math.max(dp[1], -prices[i]);
        }
        return dp[0];
    }

     */


    public static void main(String[] args) {
        int[] array1 = {7, 1, 5, 3, 6, 4};
        int[] array2 = {7, 6, 4, 3, 1};
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(array1));
        System.out.println(solution.maxProfit(array2));
    }
}
