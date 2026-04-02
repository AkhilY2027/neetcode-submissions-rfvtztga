class Solution {
    // Top-Down Approach
    private int dfs(int[] nums, int target, Map<Integer, Integer> dp) {
        // if (target < 0) return 0;
        if (dp.containsKey(target)) return dp.get(target);

        // Add another number to the combination
        int sol = 0;
        for (int num : nums) {
            if (target - num < 0) break;
            sol += dfs(nums, target - num, dp);
        }
        dp.put(target, sol);
        return sol;
    }

    public int combinationSum4(int[] nums, int target) {
        // 1 Dimension DP is the easiest way to do this
            // Make sure that combinations can repeat characters as well + all characters are unique
        Arrays.sort(nums); // Don't need to explictely sort the array, but makes it better by allowing for "early breaks"

        Map<Integer, Integer> dp = new HashMap<>(); // Can use a hashmap for caching instead of array for easier storage
        dp.put(0, 1); // Whenever we get to a total of 0, invoke this
        // return dfs(nums, target, dp);

        // Can also do a bottom up approach as well – both O(n * t)
        for (int i = 1; i <= target; i++) {
            int sol = 0;
            for (int num : nums) {
                if (i - num < 0) break;
                sol += dp.get(i - num);
            }
            dp.put(i, sol);
        }
        return dp.get(target);
    }
}