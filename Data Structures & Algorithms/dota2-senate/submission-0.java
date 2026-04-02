class Solution {
    public String predictPartyVictory(String senate) {
        // Basically, need to eliminate all of the other party
            // Each senator can only elimininate another senator until all senators are of one party
            // We also need to make sure to loop!!!
        
        // Idea: Have a pointer that correlates to the first R and first D
            // Then, linearly go through the array and see which pointer gets to the end first

        // Or optimization: Use a queue for both R and D
            // This way, we can keep a track of the positions for both parties
            // Also, if we still have senators that are of both parties, then we can loop via adding another "position" back into the queue
        
        char[] senators = senate.toCharArray();
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> dQueue = new LinkedList<>();

        // Add all r and d positions to their respective queues
        for (int i = 0; i < senators.length; i++) {
            char c = senators[i];
            if (c == 'R') rQueue.add(i);
            else dQueue.add(i);
        }

        // Loop through senators again – we know that first of R and D are either eliminated or use their turn
        int n = senators.length;
        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
            int rPos = rQueue.poll();
            int dPos = dQueue.poll();

            if (rPos < dPos) // Eliminate D
                rQueue.add(rPos + n);
            else
                dQueue.add(dPos + n);
        }

        return rQueue.isEmpty() ? "Dire" : "Radiant";
    }
}