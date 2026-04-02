class Solution {
    public String longestDiverseString(int a, int b, int c) {
        // a, b, and c are how many of the strings we each have

        // Brute Force: Decision tree that prevents consecutive letters – O(3^n)

        // Intuition: Want 2 letters, then split with another letter (Greedy Algorithm)
            // Want the letter that has the most to give, then split with the next best?
            // PriorityQueue is probably best
        
        // O(n) solution since pushing/popping is O(log(3)) = O(1)
        StringBuilder sol = new StringBuilder();
        PriorityQueue<int[]> findMax = new PriorityQueue<>(
            (x, y) -> y[0] - x[0]
        );

        // Add elements only if they are not zero – Edge case
        if (a > 0) findMax.offer(new int[] {a, 'a'});
        if (b > 0) findMax.offer(new int[] {b, 'b'});
        if (c > 0) findMax.offer(new int[] {c, 'c'});

        // Greedy Algo starts here
        while (!findMax.isEmpty()) {
            int[] best = findMax.poll();

            // Want to ensure we're not making a consecutive substring
            if (sol.length() > 1 && sol.charAt(sol.length() - 1) == best[1]
                && sol.charAt(sol.length() - 2) == best[1]) {

                if (findMax.isEmpty()) // Edge Case – What if this is the last character we can add, so end here
                    break;
                // Just add one from the second best now since we can't do consecutive
                int[] secondBest = findMax.poll();
                findMax.offer(best); // Return best to the pq, no use for it on this turn
                sol.append((char) secondBest[1]);
                secondBest[0]--;
                if (secondBest[0] > 0)
                    findMax.offer(secondBest);
            }
            else {
                sol.append((char) best[1]);
                best[0]--;
                if (best[0] > 0)
                    findMax.offer(best);
            }
        }
        return sol.toString();
    }
}