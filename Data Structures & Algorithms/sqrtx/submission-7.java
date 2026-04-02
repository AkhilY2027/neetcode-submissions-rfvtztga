class Solution {
    public int mySqrt(int x) {
        // int i = 0;
        // while (i * i <= x)
        //     i++;
        // return i - 1;

        // Binary search for what sqrtx should be
        int l = 0, r = x;
        int sol = 0;
        while (l <= r) {
            int m = l + (r - l) / 2;
            System.out.println(m);
            if ((long) m * m > x)
                r = m - 1;
            else if ((long) m * m < x) {
                l = m + 1;
                sol = m; // Best possible number it can be
            }
            else
                return m;
        }
        return sol;
    }
}