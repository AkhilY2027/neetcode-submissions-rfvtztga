class Solution {
    public int[] countBits(int n) {
        int[] sol = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            // Count 1s for each
            int cur = i;
            while (cur != 0) {
                cur &= (cur - 1);
                sol[i]++;
            }
        }
        return sol;
    }
}
