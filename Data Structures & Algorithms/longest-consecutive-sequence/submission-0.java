class Solution {
    public int longestConsecutive(int[] nums) {
        // int[] dp = new int[nums.length];
        // int n = nums.length;
        // // Subproblem: dp[i] = Length of best subsequence starting from i
        // // Bellman: dp[i] = 1 + Look for all consequtive nums and max that
        // for (int i = n - 1; i >= 0; i--) {
        //     int tempMax = 0;
        //     for (int j = i + 1; j < n; j++) {
        //         if (nums[j] == nums[i] + 1) tempMax = Math.max(tempMax, dp[j]);
        //     }
        //     dp[i] += 1 + tempMax;
        // }
        // return dp[0];

        // Easy way is to sort – O(nlogn)
        // However, can use HashSet to keep a track of best subsequence
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int sol = 0;
        for (int num : set) {
            // Find each start of the subsequence and find the best subsequence of that
            if (!set.contains(num - 1)) { // Has no left neighbor – at start
                int length = 1;
                while(set.contains(num + length))
                    length++;
                sol = Math.max(length, sol);
            }
        }
        return sol;
    }
}
