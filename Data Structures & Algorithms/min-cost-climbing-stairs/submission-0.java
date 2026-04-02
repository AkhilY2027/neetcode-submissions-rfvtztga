class Solution {
    public int recur(int[] cost, int i) {
        if (i >= cost.length) return 0;
        if (i == cost.length - 1) return cost[i];

        return cost[i] + Math.min(recur(cost, i + 1), recur(cost, i + 2));
    }
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(recur(cost, 0), recur(cost, 1));
    }
}
