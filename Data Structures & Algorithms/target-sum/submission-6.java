class Solution {
    private int[][] dpArr;
    private int totalSum;
    public int recur(int[] nums, int curIndex, int curTarget, int target) {
        if (curIndex == nums.length) return curTarget == target ? 1 : 0;
        if (dpArr[curIndex][curTarget + totalSum] != Integer.MIN_VALUE) return dpArr[curIndex][curTarget + totalSum];
        dpArr[curIndex][curTarget + totalSum] =
            recur(nums, curIndex + 1, curTarget + nums[curIndex], target)
            + recur(nums, curIndex + 1, curTarget - nums[curIndex], target);
        return dpArr[curIndex][curTarget + totalSum];
    }

    public int findTargetSumWays(int[] nums, int target) {
        // This is top-down DP:
            // Basically we just add a cache to optimize all repeated decisions
            // This is why time complexity becomes O(n*m) since that's the maximum amount of operations
                // that will occur with this new cache
        // totalSum = 0;
        // for (int num : nums) totalSum += num;
        // dpArr = new int[nums.length][totalSum * 2 + 1];
        // for (int i = 0; i < nums.length; i++)
        //     for (int j = 0; j < 2 * totalSum + 1; j++)
        //         dpArr[i][j] = Integer.MIN_VALUE;
        // return recur(nums, 0, 0, target);

        // Space-Optimized: Use Bottom-Up DP
            // Think of it as a BFS compared to a DFS
            // Now, since we go one index at a time, the first part of the array - the [nums.length]
                // is not necessary and can be optimized
        HashMap<Integer, Integer> dp = new HashMap<>(); // Use HashMap for optimal space
            // Associating the sums that we find with the number of ways we can achieve them
        dp.put(0, 1);

        for (int num : nums) {
            HashMap<Integer, Integer> nextDP = new HashMap<>();
            for (Map.Entry<Integer, Integer> e : dp.entrySet()) {
                int curTotal = e.getKey();
                int countOfTotalWays = e.getValue();
                nextDP.put(curTotal + num, nextDP.getOrDefault(curTotal + num, 0) + countOfTotalWays);
                nextDP.put(curTotal - num, nextDP.getOrDefault(curTotal - num, 0) + countOfTotalWays);
            }
            dp = nextDP;
        }
        return dp.getOrDefault(target, 0);
    }
}
