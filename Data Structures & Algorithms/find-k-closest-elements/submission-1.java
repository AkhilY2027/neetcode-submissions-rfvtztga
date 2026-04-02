class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // // Brute Force O(nlogn): Can do a linear search via priority queue and order by absolute value
        // PriorityQueue<Integer> pq = new PriorityQueue<>(
        //     (a, b) -> Math.abs(x - arr[a]) - Math.abs(x - arr[b]) == 0 ? arr[a] - arr[b] : Math.abs(x - arr[a]) - Math.abs(x - arr[b])
        // );

        // // Add into pq
        // for (int i = 0; i < arr.length; i++)
        //     pq.add(i);

        // // Then, get k closest elements
        // List<Integer> sol = new ArrayList<>();
        // for (int i = 0; i < k; i++) {
        //     sol.add(arr[pq.poll()]);
        // }
        // Collections.sort(sol);
        // return sol;

        // Optimization – O(logn + k): Because arr is sorted, can do a sliding window starting from a binary search
            // When you can't find x in arr, start from the closest value
        
        // Optimization 2 – O(log(n - k) + k): Do a binary search on the sliding window itself
            // Basically, treat the sliding window as the object to be searched for via a binary search
            // In implementation, we start from a middle sliding window and compare to the number just outside that sliding window
                // If that number is better, then we update our bounds accordingly
                // The bounds of the array are the bounds of where the left part of our sliding window can be
        
        int l = 0, r = arr.length - k;
        while (l < r) {
            int m = (l + r) / 2;
            if (x - arr[m] > arr[m + k] - x) l = m + 1; // Value to the right is closer, so shift closer to there
            else r = m; // Value to right is not closer, so don't need to shift
                // Can also be equally close but want smaller numbers anyway
        }
        List<Integer> sol = new ArrayList<>();
        for (int i = l; i < l + k; i++)
            sol.add(arr[i]);
        return sol;
    }
}