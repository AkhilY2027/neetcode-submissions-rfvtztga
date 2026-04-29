class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        // Basically, have a range of where you're allowed to jump toward

        // Basically just the dp problem again except we have to search within range
            // At worst, would be O(n^2) since we're constantly searching
        
        // Or: Think about it this way
            // If there is a patch of 1s that is bigger than maxJump - minJump, then we can't jump toward it
                // Otherwise, should always be a patch available
        
        // OR EVEN BETTER: Do a BFS to go through all positions at once
            // At every position, check if we've already done that position (visited indices) and if its a zero
                // Then, can add the next positions we can go to
            // Instead of a visited array, maintain a 'farthest' variable to know that we've already reached that far
                // Thus don't need consider indices before it
        
        Queue<Integer> bfs = new LinkedList<>();
        int farthest = 0;
        bfs.add(0);
        while (!bfs.isEmpty()) {
            int curIndex = bfs.poll();
            if (s.charAt(curIndex) != '0')
                continue;
            if (curIndex == s.length() - 1)
                return true;
            
            // Jump
            for (int j = Math.max(curIndex + minJump, farthest + 1); j < Math.min(curIndex + maxJump + 1, s.length()); j++) {
                bfs.add(j);
            }
            farthest = curIndex + maxJump; // All of these possible indices are within the queue, so don't want to consider them
        }
        return false;
    }
}