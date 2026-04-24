class Solution {
    public int[] getOrder(int[][] tasks) {
        // Can we not just use a queue to sort?
        
        // Can use two queues:
            // One for the tasks the cpu can do at the moment, Another for the tasks still in the queue, waiting for their enqueue time
            // Must be different since we sort each differently
                // CPU is sorted by length of task itself (doesn't care about when it's added to the cpu's queue, only index of task itself), while we must input tasks by when the enqueue time is, regardless of task time
        PriorityQueue<int[]> cpuQueue = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
        );
        PriorityQueue<int[]> pendingQueue = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );

        // 1. Add all tasks to the pending queue
        int n = tasks.length;
        for (int i = 0; i < n; i++)
            pendingQueue.add(new int[] {tasks[i][0], tasks[i][1], i});

        // 2. Go through tasks and add them
        int[] sol = new int[n];
        int i = 0;
        int curTime = 0;
        while (!pendingQueue.isEmpty() || !cpuQueue.isEmpty()) {
            // If there are pending tasks available, add them to the cpuQueue
            while (!pendingQueue.isEmpty() && pendingQueue.peek()[0] <= curTime) {
                int[] curTask = pendingQueue.poll();
                cpuQueue.add(new int[] {curTask[1], curTask[2]}); // Don't need enqueue time because cpu does not sort by it
            }

            // Otherwise, if cpu doesn't have any tasks to start with, jump to the next pending 
            if (cpuQueue.isEmpty()) {
                curTime = pendingQueue.peek()[0];
                continue;
            }

            // Finally, process the current task available
            int[] curTask = cpuQueue.poll();
            curTime += curTask[0];
            sol[i++] = curTask[1];
        }
        return sol;
    }
}