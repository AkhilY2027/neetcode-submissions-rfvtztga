class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // Just do sliding window – see what subarrays can add up to target and find minimum length
        int minLen = Integer.MAX_VALUE;
        int l = 0, r = 0, curSum = 0;

        while (r < nums.length) {
            curSum += nums[r];
            while (curSum >= target) {
                minLen = Math.min(minLen, r - l + 1);
                
                // Keep on reducing in case we can make a smaller subarray
                curSum -= nums[l];
                l++;
            }
            r++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}