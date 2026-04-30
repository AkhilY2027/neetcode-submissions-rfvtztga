class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // int n = cost.length;
        // int[] minCost = new int[n];
        // minCost[n - 1] = cost[n - 1];
        // minCost[n - 2] = cost[n - 2];
        // for (int i = n - 3; i >= 0; i--)
        //     minCost[i] = cost[i] + Math.min(minCost[i + 1], minCost[i + 2]);
        // return Math.min(minCost[0], minCost[1]);

        // For O(1) Time Complexity:
        for (int i = cost.length - 3; i >= 0; i--)
            cost[i] += Math.min(cost[i + 1], cost[i + 2]);
        return Math.min(cost[0], cost[1]);
    }
}
