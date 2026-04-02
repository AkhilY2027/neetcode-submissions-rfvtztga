class Solution {
    public int reverse(int x) {
        if (x == 0) return 0;
        boolean isNeg = (x < 0);
        if (isNeg) x = -1 * x;

        int sol = 0;
        while (x > 0) {
            int dig = x % 10;
            if ((sol > Integer.MAX_VALUE / 10) || (sol == Integer.MAX_VALUE / 10 && dig > Integer.MAX_VALUE % 10)) return 0; // Too much for int
            sol = sol * 10 + dig;
            x /= 10;
        }
        return isNeg ? -1 * sol : sol;
    }
}
