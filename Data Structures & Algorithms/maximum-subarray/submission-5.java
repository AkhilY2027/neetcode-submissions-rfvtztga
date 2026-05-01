class Solution {
    public int maxSubArray(int[] nums) {
        // Brute Force – calculate every possible subarray – n^2

        // To optimize: Prefix sum? – No, would give the same problem
        // Can do a DP?
        // OR: Can linearly go through the nums array and see if we should discard any numbers
            // Basically, on the current number, see what the previous subarray score is – if negative, throw it out
            // Otherwise, continue on with that number

        // Linearly go through the nums array and find how to best add
        int maxSum = nums[0];
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (curSum < 0) curSum = 0; // Chop off any parts that become negative – keep the subarray positive
            curSum += nums[i];
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }
}
