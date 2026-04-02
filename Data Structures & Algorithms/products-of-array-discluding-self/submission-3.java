class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] frontToBack = new int[n];
        frontToBack[0] = 1;
        for (int i = 1; i < n; i++)
            frontToBack[i] = frontToBack[i - 1] * nums[i - 1];

        int[] backToFront = new int[n];
        backToFront[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--)
            backToFront[i] = backToFront[i + 1] * nums[i + 1];

        int[] sol = new int[n];
        for (int i = 0; i < n; i++)
            sol[i] = frontToBack[i] * backToFront[i];
        return sol;
    }
}  
