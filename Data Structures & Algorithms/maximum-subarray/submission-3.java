class Solution {
    public int maxSubArray(int[] nums) {
        // if (nums.length == 1) return nums[0];
        // // Can we do a prefix sum, iterate through and find the lowest and highest?
        // int[] prefixSum = new int[nums.length + 1];
        // // Do we need to add an element in front of 0?
        // prefixSum[0] = 0;
        // for (int i = 0; i < nums.length; i++)
        //     prefixSum[i + 1] = prefixSum[i] + nums[i];
        // // System.out.println(Arrays.toString(prefixSum));
        // // Iterate through, and find min and then max
        // int minIndex = 0;
        // int maxIndex = 0;
        // int bestSum = Integer.MIN_VALUE;
        // for (int i = 0; i < nums.length; i++) {
        //     if (prefixSum[i] < prefixSum[minIndex]) {
        //         // Redo minIndex
        //         bestSum = Math.max(bestSum, prefixSum[maxIndex] - prefixSum[minIndex]);
        //         minIndex = i;
        //         maxIndex = i;
        //     }
        //     else if (prefixSum[i] > prefixSum[maxIndex]) {
        //         maxIndex = i;
        //     }
        // }
        // bestSum = Math.max(bestSum, prefixSum[maxIndex] - prefixSum[minIndex]);
        // return bestSum;

        // Use DP
            // Basically, keep a track of the "running sum"
            // However, if it ever becomes negetive, just discard it entirely since we're resetting the subarray at that point
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int bestSum = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            bestSum = Math.max(bestSum, dp[i]);
        }
        return bestSum;
    }
}
