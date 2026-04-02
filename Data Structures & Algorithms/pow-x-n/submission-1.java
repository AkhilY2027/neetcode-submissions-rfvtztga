class Solution {
    public double myPow(double x, int n) {
        double sol = 1.0;
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                sol *= x;
            }
        }
        else if (n < 0) {
            for (int i = n; i < 0; i++) {
                sol /= x;
            }
        }
        else
            return 1;
        return sol;
    }
}
