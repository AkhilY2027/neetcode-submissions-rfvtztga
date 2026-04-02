class Solution {
    public int distanceFrom0(int x, int y) {
        return x * x + y * y; // Technically should be sqrt but same regardless + sqrt returns a double
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> distances = new PriorityQueue<>((a, b) -> Integer.compare(distanceFrom0(a[0], a[1]), distanceFrom0(b[0], b[1]))
        );

        // Add all elements, then convert into array
        for (int i = 0; i < points.length; i++) {
            distances.add(points[i]);

            // if (distances.size() > k) distances.poll();
        }

        // Now, get all elements from heap and add to array
        int[][] sol = new int[k][2];
        for (int i = 0; i < k; i++) {
            sol[i] = distances.poll();
        }
        return sol;
    }
}
