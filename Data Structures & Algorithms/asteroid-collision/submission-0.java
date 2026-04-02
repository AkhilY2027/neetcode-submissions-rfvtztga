class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // For each asteroid:
            // Index is position
            // Number is size
            // Sign is direction
        
        // At end, there are asteroids per direction
            // Only biggest asteroids per direction
        
        // Maybe have a data structure to store left and right asteroids separately?
            // Or rather, want a data structure to easily simulate "collisions" between neighbors
            // Want a data structure that can get order of asteroids, even after collision
                // Stack would be perfect
        
        Stack<Integer> remainingAsteroids = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            int curAsteroid = asteroids[i];
            // Compare current asteroid to other asteroids in the stack
            while (!remainingAsteroids.isEmpty() &&
                (curAsteroid < 0 && remainingAsteroids.peek() > 0)) {
                // Only way asteroids can collide if left is moving right and right is moving left
                
                // Check difference in collision
                int diff = curAsteroid + remainingAsteroids.peek();
                if (diff < 0) remainingAsteroids.pop(); // Current asteroid wins
                else if (diff > 0) curAsteroid = 0; // Stack asteroid wins
                else { // Both are destroyed
                    curAsteroid = 0;
                    remainingAsteroids.pop();
                }
            }

            // Only add if we know from our while loop that curAsteroid isn't empty
            if (curAsteroid != 0) remainingAsteroids.add(curAsteroid);
        }

        // Create final solution array
        int[] sol = new int[remainingAsteroids.size()];
        for (int i = sol.length - 1; i >= 0; i--)
            sol[i] = remainingAsteroids.pop();
        return sol;
    }
}