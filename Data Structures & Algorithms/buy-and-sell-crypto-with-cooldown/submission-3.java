class Solution {
    private int dfs(int i, boolean buying, int[] prices, HashMap<String, Integer> dp) {
        if (i >= prices.length)
            return 0;
        String key = i + "-" + buying;
        if (dp.containsKey(key))
            return dp.get(key);

        // Three Decisions:
        int cooldownPrice = dfs(i + 1, buying, prices, dp);
        if (buying)
            dp.put(key, Math.max(cooldownPrice, dfs(i + 1, false, prices, dp) - prices[i]));
        else
            dp.put(key, Math.max(cooldownPrice, dfs(i + 2, true, prices, dp) + prices[i]));
        return dp.get(key);
    }
    public int maxProfit(int[] prices) {
        // Always a decision tree based problem here
            // At any point, we either buy, sell, or cooldown
            // Selling depends on buying first + Goes toward a cooldown (Essentially, skip a day)
        
        // Thus, use DP – keys are index of day + Whether we are currently buying/selling
            // For caching, use a hashmap as possible profit can be many numbers
        HashMap<String, Integer> dp = new HashMap<>();

        return dfs(0, true, prices, dp);
    }
}
