package array.leetcode121;

public class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int min = prices[0];
        int max = prices[0];
        int currentProfit = 0;
        for (int i = 0; i < length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (prices[i] - min > currentProfit) {
                currentProfit = prices[i] - min;
            }
        }
        return currentProfit;
    }

    public static void main(String[] args) {
        int[] array1 = {7, 1, 5, 3, 6, 4};
        int[] array2 = {7, 6, 4, 3, 1};
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(array1));
        System.out.println(solution.maxProfit(array2));
    }
}
