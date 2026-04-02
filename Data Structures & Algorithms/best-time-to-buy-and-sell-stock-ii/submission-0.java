class Solution {
    public int maxProfit(int[] prices) {
        // On any day, you either buy or sell – however, need to buy before a sell
            // Thus, can do a dp for both buying and selling actions
            // For buying, either better to buy with next day's best sell or to not buy at all
                // Same for selling (sell with next day's best buy or not sell)
            // For bottom-up, go from last day to first
        int n = prices.length;
        int[] dpBuy = new int[n + 1]; // On last day, best choice for buy and sell is to do nothing – so 0
        int[] dpSell = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            dpBuy[i] = Math.max(dpSell[i + 1] - prices[i], dpBuy[i + 1]);
            dpSell[i] = Math.max(dpBuy[i + 1] + prices[i], dpSell[i + 1]);
        }
        return dpBuy[0]; // Since we need to start with a buy
    }
}