class Solution {
    // public int factorial(int fac) {
    //     int res = 1;
    //     for (int i = 1; i <= fac; i++)
    //         res *= i;
    //     return res;
    // }

    // public int starsAndBars(int n, int k) {
    //     // Formula: (n + m choose m)
    //     return factorial(n + k - 1) / (factorial(k - 1) * factorial(n));
    // }

    public int climbStairs(int n) {
        // return (n / 2) * 2;

        // First: 2 + 2 + 2... + 1 ->

        // Ex. 5 -> 2 + 2 + 1, 1 + 2 + 2, 2 + 1 + 2
            // 2 + 1 + 1 + 1 (4 ways)
        // int numTwos = n / 2;
        // int numOnes = n % 2;
        // int sol = 0;
        // while(numTwos >= 0) {
        //     sol += starsAndBars(numTwos, numOnes);
        //     numTwos--;
        //     numOnes += 2;
        // }
        // return sol;

        // DFS:
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] dfs = new int[n + 1];
        dfs[0] = 0;
        dfs[1] = 1;
        dfs[2] = 2;
        for (int i = 3; i <= n; i++) {
            dfs[i] = dfs[i - 1] + dfs[i - 2];
        }
        return dfs[n];
    }
}
