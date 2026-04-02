class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Min is spaces from identical + any left from tasks
            // Can simulate via a pq that keeps track of tasks to be completed
            // Use a regular queue to hold tasks that still need to be done but are on cooldown
        
        int[] count = new int[26];
        for (char c : tasks)
            count[c - 'A']++;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // Want most repeated tasks first
        for (int i : count)
            if (i > 0) pq.add(i);
        
        int time = 0;
        Queue<int[]> hold = new LinkedList<>();
        while (!pq.isEmpty() || !hold.isEmpty()) {
            time++;

            // On this space of time, have two options – Either work or don't
            if (pq.isEmpty()) {
                // No tasks remaining but we know some are still in holding
                time = hold.peek()[1]; // Skip ahead
            }
            else {
                int remainingCycles = pq.poll() - 1;
                if (remainingCycles > 0)
                    hold.add(new int[] {remainingCycles, time + n});
            }

            // Need to add from queue back into pq when the tasks are ready
                // Since we don't want to constantly reduce the time of elements in hold, just check if our current simulated time is equal to when the element should get out
            while (!hold.isEmpty() && hold.peek()[1] == time) {
                pq.add(hold.poll()[0]);
            }
        }
        return time;
    }
}
