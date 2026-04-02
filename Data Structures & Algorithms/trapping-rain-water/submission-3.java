class Solution {
    public int trap(int[] height) {
        // Think about this in terms of how much water we can trap in a single vertical line per x position
            // Cannot exceed the minimum maximum l and r bounds of the position
            // Also is bounded by the height[x] at the bottom of the position
        
        // Easy way:
            // Calculate the maximum left and right at every single position and store in arrays
            // Then, at end, calculate if there can be water stored
        // int n = height.length;
        // if (n == 0) return 0;
        // int[] lMax = new int[n];
        // int[] rMax = new int[n];
        // for (int i = 1; i < n; i++) lMax[i] = Math.max(lMax[i - 1], height[i]);
        //     // lMax[0] does not have a boundary on the left
        // for (int i = n - 2; i >= 0; i--) rMax[i] = Math.max(rMax[i + 1], height[i]);
        // int sol = 0;
        // for (int i = 0; i < n; i++) {
        //     int temp = Math.min(lMax[i], rMax[i]) - height[i];
        //     if (temp > 0) sol += temp;
        // }
        // return sol;

        // Optimization:
            // Use two pointer to "snap" from max pointers
        int l = 0, r = height.length - 1;
        int lMax = height[l], rMax = height[r];
        int sol = 0;
        while (l < r) {
            if (lMax < rMax) {
                // lPos is the limiting factor here - increase and add
                l++;
                lMax = Math.max(lMax, height[l]);
                sol += lMax - height[l];
            }
            else {
                r--;
                rMax = Math.max(rMax, height[r]);
                sol += rMax - height[r];
            }
        }
        return sol;
    }
}
