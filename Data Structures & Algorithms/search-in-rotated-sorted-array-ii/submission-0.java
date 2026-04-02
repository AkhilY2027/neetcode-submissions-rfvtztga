class Solution {
    public boolean search(int[] nums, int target) {
        // Need a binary search algo
            // Upon a mid – Either L to M does not contain break, or M to R does not contain break
            // Complication: Non monotonically increasing + values can be repeated
                // So this isn't a simple check to see if the target value is in there
            // Thus, we narrow down the search range as follows:
                // Get the section (Either L to M or M to R) that does not contain the break
                // See if its possible for the target to be within that section (just possible, not within) and either set R or L to narrow down the range to that section
                    // Otherwise, set the search range outside of that section
            // Edge Case: M is equal to L/R (Whatever we're comparing against) and Nums[M] != Target
                // Just move L up one
                // Cannot just set to M as there can be a break in between L and M (We cannot properly check in that binary search loop, hence moving L so we can check on the next)
            // Overall: O(logn) time (On average – Can be O(n) in worst-case scenario)
        
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target)
                return true;

            if (nums[l] < nums[m]) { // L to M does not contain break
                if (nums[l] <= target && target <= nums[m]) // Checking if target is within this increasing range – Only property we can be sure of
                    r = m - 1;
                else
                    l = m + 1;
            }
            else if (nums[l] > nums[m]) { // M to R does not contain break
                if (nums[m] <= target && target <= nums[r]) // Checking if target is within this increasing range – Only property we can be sure of
                    l = m + 1;
                else
                    r = m - 1;
            }
            else // Edge Case: Nums[M] == Nums[L], stopping comparisons
                l++;
        }
        return false;
    }
}