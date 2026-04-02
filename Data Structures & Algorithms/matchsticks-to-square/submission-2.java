class Solution {
    private boolean dfs(int[] matchsticks, int[] sums, int i) {
        if (i == matchsticks.length)
            return sums[0] == sums[1] && sums[1] == sums[2] && sums[2] == sums[3];

        for (int s = 0; s < 4; s++) {
            sums[s] += matchsticks[i];
            if (dfs(matchsticks, sums, i + 1)) return true;
            sums[s] -= matchsticks[i];
        }
        return false;
    }

    private int dfsMask(int[] matchsticks, int n, int curMask, int sideLength, int[] dp) {
        if (curMask == 0) return 0; // Found our answer
        if (dp[curMask] != Integer.MIN_VALUE)
            return dp[curMask];

        // Go through each match still available in curMask and see if we can find a subset that adds to the sideLength
        for (int i = 0; i < n; i++) {
            if ((curMask & (1 << i)) != 0) {
                int sol = dfsMask(matchsticks, n, curMask ^ (1 << i), sideLength, dp);

                if (sol >= 0 && (sol + matchsticks[i]) <= sideLength) {
                    dp[curMask] = (sol + matchsticks[i]) % sideLength;
                    return dp[curMask];
                }

                // If we still have full matchsticks after the previous if, we cannot move forward
                    // Basically because we need to take all matchsticks, so that needs to start from first element
                    // However, if we have started from full bitmask, taken one, done all dps from that point, and still haven't found an answer
                        // Then, that means there is no answer to be made by taking this match – in other words, there is no way for all matches to be used
                if (curMask == (1 << n) - 1) {
                    dp[curMask] = -1;
                    return -1;
                }
            }
        }

        // If we get here, then we know there is no way forword with this bitmask – set to -1 to show that it doesn't work
        dp[curMask] = -1;
        return dp[curMask];
    }

    public boolean makesquare(int[] matchsticks) {
        // Basically, need to put all numbers into a sum / 4 box
        int sum = 0;
        for (int i = 0; i < matchsticks.length; i++)
            sum += matchsticks[i];
        if (sum % 4 != 0) return false;

        // Maybe can sort the matchsticks and match greatest to least numbers?
            // Can't since we never know the true way to combine matchsticks
        
        // Brute Force is a decision tree to find where all matchsticks are the same length
            // Can possibly optimize this via sorting matchsticks (least to greatest) and ensuring no side becomes greater than our necessary length
                // Here, if upon returning from dfs our side is 0 again, we know starting a side with that number will not return any results, so automatically know the whole solution is false
        // return dfs(matchsticks, new int[4], 0);

        // To make even more efficient: Use dp
            // Basically, we'll use a bit mask to keep a track of what matchsticks we have used
                // 1 == not used, 0 == used
                // If we have a mask of all 0s, then we have used all the matchsticks
            // Then, we'll be going through matchsticks and finding subsets that match the target sum (sum / 4)
                // If we have a subset, then we mask all those matches to 0 and find the next subset
                // This way, we don't do repeated work
            // Essentially, for each mask, we are calculating a partial sum for a mask
                // Start from full bitmask (no matches are selected) and recursively remove each matchstick
                // If the resulting partial sum of that new bitmask + removed matchstick does not exceed target, then we update dp to show that we have achieved that length below sidelength
                // If side is completed (sum of partial sum + removed matchstick = sideLength), then modulo of sideLength will "reset" the dp to 0, showing that those removed matchsticks form a completed side
                    // Basically, each subsequent dp gives all possible sums for removing later matchsticks
                    // Then, if we find a sum of 0, then our dp will record and ensure we don't have to do work to get here again
                    // If the mask is at 0, then we have found a path that gets subsets and places them into correct sides
            // Time Complexity: O(n * 2^n)
            // Space Complexity: O(n + 2^n)
        
        int sideLength = sum / 4;
        int n = matchsticks.length;
        for (int i = 0; i < n; i++)
            if (matchsticks[i] > sideLength)
                return false;
        
        Arrays.sort(matchsticks); // Sort from greatest to least for better pruning
        for (int i = 0; i < n / 2; i++) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[n - 1 - i];
            matchsticks[n - 1 - i] = temp;
        }
        int[] dp = new int[1 << n]; // For all possible masks
        Arrays.fill(dp, Integer.MIN_VALUE);

        return dfsMask(matchsticks, n, (1 << n) - 1, sideLength, dp) == 0;
    }
}