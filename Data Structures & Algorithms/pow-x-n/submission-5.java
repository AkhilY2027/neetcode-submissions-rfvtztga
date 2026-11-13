class Solution {
    public double func(double x, long n) { // Need to make n long in case it is max neg
        if (n == 0) return 1;
        double nextHalf = func(x, n / 2);
        return (n % 2 == 0) ? nextHalf * nextHalf : nextHalf * nextHalf * x;
    }
    
    public double myPow(double x, int n) {
        // To make faster, instead of multiplying x one by one, do a merge sort like algo
            // Essentially, just split the "n" in half (if odd, multiply by x) and calculate that half in the same way to make O(n) a O(logn) algo
        if (x == 0) return 0;
        if (n == 0) return 1;

        double sol = func(x, Math.abs((long) n));
        return (n < 0) ? 1 / sol : sol;
    }
}
