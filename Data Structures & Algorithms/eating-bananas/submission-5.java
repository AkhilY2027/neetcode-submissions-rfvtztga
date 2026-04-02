class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // If we decide to eat k per hour, then total hours needed will be:
            // ceil(piles[i] / k)
        // Max k will always be max(piles)
            // Can we do a binary search?
        int maxk = -1;
        for (int i = 0; i < piles.length; i++) {
            maxk = Math.max(maxk, piles[i]);
        }

        // for (int k = 1; k <= maxk; k++) {
        //     long total = 0;
        //     for (int i = 0; i < piles.length; i++) {
        //         total += (long) Math.ceil((double) piles[i] / k);
        //     }
        //     if (total > Integer.MAX_VALUE) continue;
        //     if (total <= h) return k;
        // }
        // return maxk;

        // Reduce time complexity with binary search
        int mink = 1;
        int k = maxk; // Only guarenteed solution
        while (mink <= maxk) {
            int curk = (mink + maxk) / 2;

            // Calculate time at current position
            int total = 0;
            for (int i = 0; i < piles.length; i++)
                total += (int) Math.ceil((double) piles[i] / curk);
            
            // Based on this, know where our k has to go
            if (total > h) {
                mink = curk + 1; // Exceeded, so we need to bring up our bounds
            }
            else {
                k = curk; // Know that the current solution works, so we set our k to this
                maxk = curk - 1; // Set bounds to see if there's a better solution
            }
        }
        return k;
    }
}
