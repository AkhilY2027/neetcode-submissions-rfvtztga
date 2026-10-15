class CountSquares {

    // Edge case: Point being added twice
    // Anyway, want to maybe sort our points by x coordinate?
        // Basically, just check if point has same point with dif x coord, diff y coord, and both
        // Thus, if we check for one and use the length, we can check if the whole square exists
            // Also technically would be squares up and down
    
    // Use HashMap for both:
        // Associate every x -> y, so all ys are grouped by their x coord (reverse of above but mirroring the solution)
        // Also associate every y -> count so we know how many of each point is there
    
    private Map<Integer, Map<Integer, Integer>> map;

    public CountSquares() {
        map = new HashMap<>();
    }
    
    public void add(int[] point) {
        // For each point, associate x -> y, count
        int x = point[0], y = point[1];
        map.putIfAbsent(x, new HashMap<>());
        map.get(x).put(y, map.get(x).getOrDefault(y, 0) + 1);
    }
    
    public int count(int[] point) {
        int sol = 0;
        int x1 = point[0], y1 = point[1];

        if (!map.containsKey(x1)) // No points of this nature anyway
            return sol;

        // Check all points on the same x coord and use it to make squares
        for (int y2 : map.get(x1).keySet()) {
            int sideLength = y2 - y1;
            if (sideLength == 0)
                continue; // Don't want to count ourselves
            
            int x2_pos = x1 + sideLength, x2_neg = x1 - sideLength;
            sol += map.get(x1).get(y2) * map.getOrDefault(x2_pos, new HashMap<>()).getOrDefault(y1, 0) * map.getOrDefault(x2_pos, new HashMap<>()).getOrDefault(y2, 0); // Need to multiply each by how many of each point we have
            sol += map.get(x1).get(y2) * map.getOrDefault(x2_neg, new HashMap<>()).getOrDefault(y1, 0) * map.getOrDefault(x2_neg, new HashMap<>()).getOrDefault(y2, 0);

            // Not multiplying sol by map.get(x1).get(y1) because we're treating all duplicate points separately – So in this count(), we're only counting from one of these points (if there are multiple)
        }
        return sol;
    }
}
