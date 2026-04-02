class Solution {
    public int singleNumber(int[] nums) {
        // Apparently O(n) and O(1) Space Manipulation is BIT MANIPULATION
        int sol = 0;
        for (int num: nums){
            sol ^= num; // Will cancel out all duplicates because they will have the same duplicate number
        }
        return sol;
    }
}
