class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> stoneQueue = new PriorityQueue<>( Collections.reverseOrder() );
        for (int i = 0; i < stones.length; i++) {
            stoneQueue.add(stones[i]);
        }
        while (stoneQueue.size() > 1) {
            // Get last two elements
            int stone1 = stoneQueue.poll();
            int stone2 = stoneQueue.poll();
            if (stone1 != stone2)
                stoneQueue.add(Math.abs(stone1 - stone2));
        }
        return stoneQueue.size() == 1 ? stoneQueue.poll() : 0;
    }
}
