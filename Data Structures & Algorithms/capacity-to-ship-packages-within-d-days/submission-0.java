class Solution {
    private boolean canShip(int[] weights, int maxCapacity, int days) {
        int curCap = 0;
        for (int i = 0; i < weights.length; i++) {
            curCap += weights[i];
            if (curCap > maxCapacity) {
                curCap = weights[i];
                days--;
            }
        }
        return days > 0;
    }

    public int shipWithinDays(int[] weights, int days) {
        // Essentially, putting all the weights in "days" amount of boxes
            // Trying to equalize these boxes as much as possible
        
        // Observations: Max capacity has to be at least the largest element in weights
            // Upper bound: Sum of all weights in array
            // Want to combine lesser weights together to equalize them together
        
        // Intuition: Can brute force if we can ship in days given a specific capacity – O(n) solution
            // However, manually searching through all possible capacities is a O(N^2) solution
            // Can optimize via a binary search, as we know upper and lower bounds
        
        int l = 0, r = 0;
        for (int i = 0; i < weights.length; i++) {
            l = Math.max(l, weights[i]);
            r += weights[i];
        }
        
        // For each of these possible capacities, do a binary search to see if it can work
        int best = r;
        while (l <= r) {
            int mid = (l + r) / 2;

            boolean works = canShip(weights, mid, days);
            if (works) {
                // Can move up r so that can search for lesser max
                best = Math.min(best, mid);
                r = mid - 1;
            }
            else l = mid + 1; // Have to move up l bc we know mid is outside of possible range
        }
        return best;
    }
}