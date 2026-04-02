class Solution {
    private int dfs(int i, int[] nums, int m, int[][] dp) {
        if (i == nums.length)
            return m == 0 ? 0 : Integer.MAX_VALUE; // Should either split perfectly (0 on nth element which doesn't exist) or shouldn't exist
        if (m == 0)
            return Integer.MAX_VALUE; // Still have elements left to split but have no groups to put them into
        if (dp[i][m] != -1)
            return dp[i][m];
        
        int sol = Integer.MAX_VALUE;
        int curSum = 0;
        for (int j = i; j <= nums.length - m; j++) { // Remember, we're only calculating the min max sum of a subarray – we only need to store that in our dp
            curSum += nums[j];
            sol = Math.min(sol, Math.max(curSum, dfs(j + 1, nums, m - 1, dp)));
                // Here, recursive call is all about adding elements to this subarray and seeing if the min max sum changes
        }
        dp[i][m] = sol;
        return sol;
    }

    private boolean canSplitArray(int[] nums, int k, int maxSumPossible) {
        int curSubArray = 1, curSum = 0;
        for (int num : nums) {
            curSum += num;
            if (curSum > maxSumPossible) {
                curSum = num;
                if (++curSubArray > k) return false;
            }
        }
        return true;
    }

    public int splitArray(int[] nums, int k) {
        // Brute Force Solution: Adding each number from nums into a k manually
            // While inefficient, does show that the inputs needed for this solution are index i of nums and index m of k (which subarray we're putting i into)
        
        // Thus, Optimization 1: DP of i and m
            // Basically, since we're going through every k subarray linearly (from 1, 2, to k), we don't look back – thus acylical
            // Time: O(n^2 * k) – n * k for i and m possibilities, with O(n) for each step since we have to calculate each subarray's potential sum
        // int[][] dp = new int[nums.length][k + 1];
        // for (int[] row : dp)
        //     Arrays.fill(row, -1);
        // return dfs(0, nums, k, dp);

        // Optimization 2: Binary Search
            // Minimum of the largest subarray has to be the largest element within nums
            // Maximum has to be the total sum of nums - smallest two elements
                // For efficiency's sake, drop the minus elements and just say it is the sum
            // These act as L and R within a binary search
                // Upon a M, need to check whether we can split an array such that the largest subarray has a maximum sum of M
                    // Only need to do a greedy algorithm here – basically, just add values until we cross M threshold
                    // If we every cross M, then create a split at that point
                        // Now, two possibilities:
                        // We get to end element with <= k splits and we find that maximum sum has not been reached
                            // Whether we reach k splits does not matter as it would only lessen maximum sum – thus, update R
                        // We run out of splits before reaching end elements – Otherwise, would cross maximum sum
                            // No way to split properly with M being our limiter – thus, update L
                        // Last possibility is doing exactly k splits and reaching end with M
                            // Part of L's case, so update L here
                // Then, based on behavior, update L and R
            // Time: O(n * log(s)) where s is the sum of all elements
        int l = 0, r = 0;
        for (int num : nums) {
            l = Math.max(l, num);
            r += num;
        }
        int sol = r;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (canSplitArray(nums, k, m)) {
                sol = m; // If we can split it as such, this max sum is possible
                r = m - 1;
            }
            else
                l = m + 1;
        }

        return sol;
    }
}