/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        // So in mountain array, there is a "peak"
            // Never will be the first or last element
        
        // Goal: Trying to find target
            // Intuition is to use a binary search, but both sides have increasing and decreasing
                // Also, only want the first place where element is found
            // No easy way to get peak element to split up array?
            // Also, limitation of 100 calls
                // Need O(nlogn) solution with a binary search
        
        // Solution: First need to find the peak element
            // Then, binary search between the two increasing and decreasing elements

        // 1. Find peak
        int l = 1, r = mountainArr.length() - 2; // Because we know peak won't be at ends
        int peak = 0;
        while (l <= r) {
            int m = (l + r) / 2;
            int lmid = mountainArr.get(m - 1), mid = mountainArr.get(m), rmid = mountainArr.get(m + 1);
            if (lmid < mid && mid < rmid) // Strictly increasing, so we're still on left side
                l = m + 1;
            else if (lmid > mid && mid > rmid) // Strictly decreasing, so we're on right
                r = m - 1;
            else {
                peak = m;
                break;
            }
        }

        // 2. Go through left of peak
        l = 0;
        r = peak - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            int mid = mountainArr.get(m);

            if (mid > target)
                r = m - 1;
            else if (mid < target)
                l = m + 1;
            else
                return m;
        }

        // 3. Go through right of peak
        l = peak;
        r = mountainArr.length();
        while (l <= r) {
            int m = (l + r) / 2;
            int mid = mountainArr.get(m);

            if (mid < target)
                r = m - 1;
            else if (mid > target)
                l = m + 1;
            else
                return m;
        }
        return -1;
    }
}