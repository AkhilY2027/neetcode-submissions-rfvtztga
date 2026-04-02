class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

        // First, mark the flights
        for (int i = 0; i < n; i++) {
            map.put(i, new HashMap<>());
        }
        // Then, connections
        for (int[] flight : flights) {
            map.get(flight[0]).put(flight[1], flight[2]); // Associating destination to price
        }
        
        // Now, BFS
        int cheapestFlight = Integer.MAX_VALUE;
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(src, 0));
        for (int i = 0; i <= k; i++) {
            int curSize = q.size();
            for (int j = 0; j < curSize; j++) {
                Pair<Integer, Integer> p = q.poll();
                int curNode = p.getKey();
                int dis = p.getValue();
                // System.out.println("Node: " + curNode + ", dis: " + dis);
                // Add all possible places to go
                for (Map.Entry<Integer, Integer> e : map.get(curNode).entrySet()) {
                    int newNode = e.getKey();
                    int newDis = dis + e.getValue();
                    // System.out.println("New Node: " + newNode + ", New Dis: " + newDis);
                    q.add(new Pair<>(newNode, newDis));
                    if (newNode == dst) cheapestFlight = Math.min(newDis, cheapestFlight);
                }
            }
            // System.out.println("---");
        }
        return cheapestFlight == Integer.MAX_VALUE ? -1 : cheapestFlight;
    }
}
