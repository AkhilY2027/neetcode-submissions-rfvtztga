class Solution {
    public int singleNumber(int[] nums) {
        // Possible solutions:
            // Using a hashset – O(n) time and O(n) space
            // Sorting and searching – O(nlogn) time and O(1) space
            // Using a variable that cancels out duplicates?
        int var = 0;
        for (int i = 0; i < nums.length; i++) {
            var ^= nums[i];
        }
        return var;
    }
}
