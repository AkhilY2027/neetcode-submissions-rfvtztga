class Solution {
    public int maxProfit(int[] prices) {
        // Brute force: Find a day to buy, then find a day to sell
            // Optimization Intuition: Do the other way around. Find the day to sell, and along the way, figure out the best day to buy

        int sol = 0;
        int minBuy = prices[0];

        // At every point, thinking that this is the day we are about to sell
            // minBuy will record best day it is to buy so far
        for (int price : prices) {
            sol = Math.max(sol, price - minBuy);
            minBuy = Math.min(minBuy, price);
        }
        return sol;
    }
}
