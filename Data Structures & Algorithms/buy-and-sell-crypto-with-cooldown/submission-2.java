class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MIN_VALUE;
        int profit = 0;
        int profit_before = 0;
        for (int price : prices) {
            int profit_old = profit;
            buy = Math.max(buy, profit_before - price); // If we're buying, need to make sure its based off of the profit 2 days before due to cooldown
            profit = Math.max(profit, buy + price);
            profit_before = profit_old; // Will reflect the profit value before its change
        }
        return profit;
    }
}
