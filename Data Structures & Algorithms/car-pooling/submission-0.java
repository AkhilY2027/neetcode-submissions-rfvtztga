class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // Basically a linear timeline where we pick up and drop off passengers at certain locations
            // If the number of passangers we "carry" ever exceeds the capacity, then its false

        // Algo:
            // Go linearly through the trips in sorted start order
            // Then, keep a track of who is in the car through a pq sorted by the endtime
                // Upon the end time, we pop out the end time passangers
            // If the passengers ever exceeds the capacity, then we know the car cannot do this
        
        // 1. Sort based on the starting point
        Arrays.sort(trips, Comparator.comparingInt(a -> a[1]));

        // 2. Create a heap that sorts based on the end
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[1])
        );

        // 3. Go linearly through the trips
        int carPass = 0;
        for (int[] trip : trips) {
            int numPass = trip[0], startTime = trip[1], endTime = trip[2];

            // 1. Pop out any passangers in the pq that have reached their destination
            while (!pq.isEmpty() && pq.peek()[1] <= startTime)
                carPass -= pq.poll()[0];
            
            // 2. Add current passangers to the car
            carPass += numPass;
            pq.add(new int[] {numPass, endTime});

            // 3. Check if capacity is exceeded
            if (carPass > capacity)
                return false;
        }
        return true;
    }
}