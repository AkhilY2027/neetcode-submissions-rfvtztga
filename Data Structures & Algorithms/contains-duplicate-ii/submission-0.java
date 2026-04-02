class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Duplicate has to be within k steps
            // Maybe a two pointer with hashset set and remove?
        int r = 0, l = 0;
        HashSet<Integer> set = new HashSet<>();
        while (r < nums.length) {
            // For each number: Add to hashset or return true
            if (set.contains(nums[r]))
                return true;
            else
                set.add(nums[r]);
            
            r++;
            if (r - l > k) {
                set.remove(nums[l]);
                l++;
            }
        }
        return false;
    }
}