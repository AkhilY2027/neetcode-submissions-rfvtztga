class Solution {
    public double myPow(double x, int n) {
        // double sol = 1.0;
        // if (n > 0) {
        //     for (int i = 0; i < n; i++) {
        //         sol *= x;
        //     }
        // }
        // else if (n < 0) {
        //     for (int i = n; i < 0; i++) {
        //         sol /= x;
        //     }
        // }
        // else
        //     return 1;
        // return sol;

        if (x == 0) return 0;
        if (n == 0) return 1;

        // To make more optimized, use a divide and conquer method - O(logn)
        double sol = 1;
        long power = Math.abs((long) n);

        while (power > 0) {
            if ((power & 1) == 1) {
                // Will trigger any time exponent is odd (need to multiply by an extra x)
                    // Or when at 1 (need to multiply by entirety of x at that point)
                sol *= x;
            }
            x *= x;
            power >>= 1;
        }

        return n >= 0 ? sol : 1 / sol;
    }
}
