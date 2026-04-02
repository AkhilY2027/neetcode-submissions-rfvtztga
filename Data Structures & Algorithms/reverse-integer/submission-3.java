class Solution {
    public int reverse(int x) {
        // Intuition is to just check at each step if reversing x will make it go outside the int bounds
        boolean neg = x < 0; // Also don't want to handle negatives yet because integers are signed
        if (neg) x = -1 * x;

        int sol = 0;
        while (x > 0) {
            int curDigit = x % 10;
            
            // Check if reversing (ie, adding the last digit of x to sol) will make sol exceed int bounds
            if ((sol > Integer.MAX_VALUE / 10) ||
                (sol == Integer.MAX_VALUE / 10 && curDigit > Integer.MAX_VALUE % 10))
                    return 0;
            
            sol = sol * 10 + curDigit;
            x /= 10;
        }
        return neg ? -1 * sol : sol;
    }
}
