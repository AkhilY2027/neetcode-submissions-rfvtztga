class Solution {
    public int removeDuplicates(int[] nums) {
        // Brute Force: Go through array, find duplicates, and bring duplicates to end of array
            // However, to do so in-place would mean O(n) operation each time
        
        // Observation: Doesn't matter what we do with other spaces
            // In other words, can even destroy duplicates so long as first elements are all unique
            // Solution: Go through linearly, and upon a unique element, have it overwrite the position next to the previous unique element
                // This way, guarenteed that all first elements are unique
        
        int n = nums.length, r = 0, l = 0;
        while (r < n) {
            // 1. Know that r is a unique element – "beam" it to l, which is the space next to the previous unique element
            nums[l] = nums[r];

            // 2. Increment l and r to next positions
                // For r, need to find the next unique number
            while (r < n && nums[l] == nums[r])
                r++;
            l++;
        }
        return l;
    }
}