class Solution {
    public int missingNumber(int[] nums) {
        int sol = 0;
        for (int i = 0; i < nums.length; i++) {
            sol += i - nums[i];
        }
        sol += nums.length;
        return sol;
    }
}
