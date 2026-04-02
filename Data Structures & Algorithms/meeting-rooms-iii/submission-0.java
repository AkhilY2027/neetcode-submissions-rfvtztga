class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // Need to go through meetings in sorted order (from start time)
            // Can put into a heap so that we always put in order – then, once we place into a meeting room, we can pop
            // Even easier, just sort so we don't have to deal with it

        // Real question is how to easily assign meetings to meeting rooms
            // We can also use a heap here to keep track of both what meeting rooms are available (need lowest first so minheap is perfect) and what meeting rooms are busy/can possibly be put back into free

        // Algo: Sort meetings by start time, then put in all meeting rooms into a heap
            // Upon each meeting, update our new start time
            // Then, check if any meetings from busy meetings heap can be popped into available rooms heap
                // Sort this heap by end time so we can easily check the first element
            // After, see if we can assign a meeting to a meeting room
                // Otherwise, if there are no available meeting rooms, pop the smallest room from the busy meetings room and update start times to that
            // Other things to note:
                // Since we are simulating time in a linear manner, we can have an edge case of integer overflow – thus, convert everything to longs instead of ints
                // Also ultimately trying to find the room with the most count – so keep track of this as our main solution
            // Time Complexity: O(mlogm + mlogn), Space Complexity: O(n)

        // 1. Sort meetings
        Arrays.sort(meetings, (a, b) -> Long.compare(a[0], b[0]));

        // 2. Create heaps for available and busy meeting rooms
        PriorityQueue<Integer> available = new PriorityQueue<>(); // Meeting room is always guarenteed to be an int
        for (int i = 0; i < n; i++)
            available.add(i);
        PriorityQueue<long[]> busy = new PriorityQueue<>( // (End time, Meeting room id)
            (a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0])
        );
        int[] roomCount = new int[n];

        // 3. Loop through the meetings
        for (int[] meeting : meetings) {
            long startTime = meeting[0];
            long endTime = meeting[1];

            // Pop from used if start time exceeds
            while (!busy.isEmpty() && busy.peek()[0] <= startTime)
                available.add((int) busy.poll()[1]);
            
            // Then, add meeting to available room
                // If nothing's available, need to pop the next busy meeting room and have that be the available room to use – update our current meeting's end time accordingly (because we've shifted the schedule)
            if (available.isEmpty()) {
                long[] nextBest = busy.poll();
                available.add((int) nextBest[1]);
                endTime = nextBest[0] + (endTime - startTime);
            }
            int room = available.poll();
            busy.add(new long[] {endTime, room});
            roomCount[room]++;
        }

        // 4. Once done, find the smallest room with the most amount of uses
        int sol = 0;
        for (int i = 0; i < n; i++)
            if (roomCount[i] > roomCount[sol])
                sol = i;
        return sol;
    }
}