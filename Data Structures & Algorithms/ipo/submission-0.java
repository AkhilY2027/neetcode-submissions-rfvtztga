class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // Can only do profit if we have enough capital
            // Foil: Can add profit back into capital to take on more projects

        // Idea: Split up projects into those we can take on and those we can't
            // Each in heap
                // one for max profit – can take on
                // other for min capital – want to take on
            // Upon adding capital, can search through second heap to add new projects to first heap
        
        // For PQs, only use indices to mark projects
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>(
            (a, b) -> profits[b] - profits[a]
        );
        PriorityQueue<Integer> minCapital = new PriorityQueue<>(
            (a, b) -> capital[a] - capital[b]
        );

        // Initially, add all into minCapital – Will pop when necessary
        for (int i = 0; i < profits.length; i++) {
            minCapital.offer(i);
        }

        // Then, iterate k times
        for (int i = 0; i < k; i++) {
            // 1. If we can access more projects, do so
            while (!minCapital.isEmpty() && capital[minCapital.peek()] <= w)
                maxProfit.offer(minCapital.poll());
            
            // 2. Add the best profit project in
            if (maxProfit.isEmpty())
                break;
            w += profits[maxProfit.poll()];
        }
        return w;
    }
}