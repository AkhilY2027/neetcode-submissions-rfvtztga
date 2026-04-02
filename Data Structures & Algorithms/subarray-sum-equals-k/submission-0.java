class Solution {
    public int subarraySum(int[] nums, int k) {
        // Brute Force: O(n^2)

        // Possible Optimization: Use a sliding window?
            // However, this cannot work because some values could be negative – thus, strictly increasing doesn't lead to finding a k necessarily
        
        // Actual Optimization: Use prefix sums with a hashmap
            // Basically, if we encounter a prefix sum that is greater than k, need to find sum - k within the prefix sum so we can "chop" it off for the needed subarray
            // This is why we also use a hashmap – to keep a track of what sums have been made so far
                // HashMap relates to a count variable as with negative numbers, prefix sums can occur multiple times
                // If we find sum - k within this hashmap, then we have found a subarray to output
            // To ensure that we only remove elements within the subarray, need to compute this as we're building the prefix sum
                // Thus, we only have access to prefix sums that can already be made
            // Edge Case: If prefix sum is equal to k, there may not be a prefix sum with 0 in hashmap
                // Thus, add it initially as a prefix sum of 0 (becomes a base case)
                // This count can be updated if another subarray is also 0
        
        HashMap<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);
        int curSum = 0;
        int sol = 0;
        for (int num : nums) {
            curSum += num;
            sol += prefixCount.getOrDefault(curSum - k, 0); // 1. Check if sum - k exists
            prefixCount.put(curSum, prefixCount.getOrDefault(curSum, 0) + 1); // 2. Add the current prefix sum to our array as a prefix to hash
                // Cannot do the opposite order for one such edge case:
                    // Say we need to find k = 4 and our current sum is 2
                    // If we add to the hash before, then we count our own sum when finding sum - k, which makes no sense
        }
        return sol;
    }
}