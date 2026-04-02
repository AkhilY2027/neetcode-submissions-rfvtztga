class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Basically, each k -> Time per pile = ceiling(pile / k)
            // Need the total time to be <= h
            // Binary search the k?
        int mink = 1;
        int maxk = -1;
        for (int i = 0; i < piles.length; i++) {
            maxk = Math.max(maxk, piles[i]);
        }

        int k = maxk;
        while (mink <= maxk) {
            int curk = (mink + maxk) / 2;
            // Now, count the total time with this
            int curTotal = 0;
            for (int i = 0; i < piles.length; i++) {
                curTotal += Math.ceil(((double) piles[i] / curk));
            }
            System.out.println("Current k: " + curk);
            System.out.println("Stored k: " + k);
            System.out.println("Current Total Time: " + curTotal);
            if (curTotal > h)
                mink = curk + 1;
            else {
                // Works - Reduce max and restart to see if there is a better answer
                k = curk;
                maxk = curk - 1;
            }
        }
        return k;
    }
}
