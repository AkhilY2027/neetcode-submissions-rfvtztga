class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        // Without circular array, just normal subarray sum where we can use prefix sum to find the least and greatest indices
            // Or Kadane's Algo:
            // Greedy algo where we linearly go through array and keep track of a currentMax and a globalMax (initially value of first index)
                // Whenever we get to another index, either add to currentMax or currentMax becomes the index (whichever is greater)
                // Then, keep on updating the globalMax as necessary
        
        // With circular algo, can split into two cases:
            // Either not wrapping subarray around – So normal subarray sum
            // Or wrapping subarray around end – Can split subarray into two subarrays at beginning and ending
                // OR: In another way to put it, middle of this split subarray is the minimum of nums
                // Thus, we can do a Kadane's for the global Min (contiguous) without the subarray – directly correlating to the global Max of a split subarray

        int curMax = 0, curMin = 0;
        int globalMax = nums[0], globalMin = nums[0];
        int total = 0;
        for (int num : nums) {
            curMax = Math.max(num, curMax + num);
            globalMax = Math.max(globalMax, curMax);
            curMin = Math.min(num, curMin + num);
            globalMin = Math.min(globalMin, curMin);
            total += num;
        }

        // Edge Case: If every num is negative, then total - globalMin does not give us any subarray
            // Thus, only return global Max in that case
        if (globalMax < 0)
            return globalMax;
        else
            return Math.max(globalMax, total - globalMin);
    }
}