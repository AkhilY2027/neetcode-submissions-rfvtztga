class Solution {
    public int uniquePaths(int m, int n) {
        // It's how many ways you can arrange m downs and n rights
            // (m + n)! / m! * n! ?
                // ACTUALLY: Number of downs is (m - 1) and rights is (n - 1)
                // So: (m + n - 2)! / (m - 1)! * (n - 1)!
            // Essentially a ((m + n) choose m) since we're choosing what moves will be down and which will be right
        
        long sol = 1;
        int div = 1;
        for (int i = Math.max(m, n); i <= m + n - 2; i++) {
            sol *= i;
            sol /= div;
            div++;
        }
        return (int) sol;
    }
}
