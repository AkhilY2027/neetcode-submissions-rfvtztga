class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }

        // // Greedy
        // Arrays.sort(count); // Sorting by how many tasks each letter has from least to greatest

        // // Only calculating the idle time as otherwise, each task takes 1 time each
        // int idle = (count[25] - 1) * n; // Maximum idle time that can be had
        // for (int i = 24; i >= 0; i--) {
        //     idle -= Math.min(count[i], (count[25] - 1)); 
        // }
        // return Math.max(0, idle) + tasks.length;

        // // Math
        // int maxNum = 0;
        // int maxCount = 0;
        // for (int i : count) {
        //     if (i > maxNum) {
        //         maxNum = i;
        //         maxCount = 1;
        //     }
        //     else if (i == maxNum)
        //         maxCount++;
        // }

        // // Initution – Space out the most repeated task to get the maximum count possible
        //     // We add the maxcount because those will be added at the end
        // return Math.max(tasks.length, (maxNum - 1) * (n + 1) + maxCount);

        // Use Priority Queue
            // Inituion: Do most frequent task first as must as possible
            // Priority Queue keeps track of tasks to be added and separate queue keeps track of when to add repeated task back into priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i : count)
            if (i > 0) pq.add(i);

        int time = 0;
        Queue<int[]> q = new LinkedList();
        while (!pq.isEmpty() || !q.isEmpty()) {
            time++; // At each step, time moves

            if (pq.isEmpty()) {
                time = q.peek()[1]; // Just skip ahead to that point
            }
            else {
                int remaining = pq.poll() - 1;
                if (remaining > 0)
                    q.add(new int[] {remaining, time + n}); // Basically, at what time it's supposed to be
            }

            // Adding from queue back into pq
            if (!q.isEmpty() && q.peek()[1] == time) {
                // By the way the algo is designed, this should only be == and not >=
                pq.add(q.poll()[0]);
            }
        }
        return time;
    }
}
