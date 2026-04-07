class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
            // (a, b) -> b - a
            Collections.reverseOrder()
        ); // Want heaviest first

        for (int i = 0; i < stones.length; i++)
            pq.add(stones[i]);
        
        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            if (x != y) pq.add(x - y); // Always will be positive by nature of pq
        }

        return pq.size() == 1 ? pq.poll() : 0;
    }
}
