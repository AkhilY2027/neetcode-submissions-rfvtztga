class Solution {
    public int candy(int[] ratings) {
        // Basically, at least n candies so far – Doesn't help optimize a thing
        // If neighbor has a higher rating, then will need +1 candies
            // However, if neighbor has a lower rating, can't automatically give "0" candies, since they too could also have a lower rating

        // Thinking about from an intuition perspective, need to start from "valleys" with 0 and work our way up each step
            // Then, on each turn, go to neighbors and give +1 candies
            // Like a linear bfs
            // However, if a neighbor is gotten to twice, then only continue if that neighbor's value must be bigger than what is already recorded
        
        int n = ratings.length;
        int[] candies = new int[n];
        if (n == 1) return 1;

        // Find the troughs to add
        Queue<Integer> bfs = new LinkedList<>();
        if (ratings[0] <= ratings[1]) bfs.add(0);
        if (ratings[n - 1] <= ratings[n - 2]) bfs.add(n - 1);
        for (int i = 1; i < n - 1; i++)
            if (ratings[i] <= ratings[i - 1] && ratings[i] <= ratings[i + 1])
                bfs.add(i);

        // Do the bfs
            // On each turn, find the neighbors and give them +1 candies
        while (!bfs.isEmpty()) {
            int cur = bfs.poll();

            // Go to neighbor 1 on left – If its rating is higher, need to increase
            if (cur - 1 >= 0 && ratings[cur - 1] > ratings[cur] && candies[cur - 1] <= candies[cur] + 1) {
                candies[cur - 1] = candies[cur] + 1;
                bfs.add(cur - 1);
            }

            // Go to neighbor 2 on right
            if (cur + 1 < n && ratings[cur + 1] > ratings[cur] && candies[cur + 1] <= candies[cur] + 1) {
                candies[cur + 1] = candies[cur] + 1;
                bfs.add(cur + 1);
            }
        }

        // Sum the candies we must use
        int sol = 0;
        for (int i = 0; i < n; i++)
            sol += candies[i];
        return sol + n;

        // Intuition was correct – However, to simplify, can do a two pass on both sides
            // Go from left, see if a rating is greater, then add from previous
            // Go from right, see if a rating is greater, then add from previous
            // Basically a simpler version of what we're doing from before – just work is split up so functionality is simpler

    }
}