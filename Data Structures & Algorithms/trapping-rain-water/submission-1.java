class Solution {
    public int trap(int[] height) {
        // Main idea: At position i, can trap min(L, R) - h[i] above position
            // If negative, cannot trap any number
        
        // First algorithm:
            // Scan through array left to right to find maxLeft at each point
            // Scan through array right to left to find maxRight at each point
            // Then, go through each input and calculate water to trap
        int n = height.length;
        if (n == 0) return 0;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        maxLeft[0] = height[0];
        for (int i = 1; i < n; i++) maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);

        maxRight[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) maxRight[i] = Math.max(maxRight[i + 1], height[i]);

        int sol = 0;
        for (int i = 0; i < n; i++) {
            int cal = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (cal > 0) sol += cal;
        }
        return sol;
    }
}
