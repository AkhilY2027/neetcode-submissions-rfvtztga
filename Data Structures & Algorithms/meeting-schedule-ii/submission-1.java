/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        // Two Possible Solutions:
            // 1. Use PQ as Heap to find last intervals for each day
            // 2. Use Greedy algo to sort all of the start and end times separately - then find the num of consequtive starts (those are conflicts)
        
        // 1
        // intervals.sort((a,b) -> a.start - b.start);

        // PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // for (Interval i : intervals) {
        //     if (!minHeap.isEmpty() && minHeap.peek() <= i.start)
        //         minHeap.poll(); // Do this only if we can fit in an end time before a start time
        //         // Thus, this will not be the last interval within the day - don't have to count
        //     minHeap.offer(i.end);
        // }
        // return minHeap.size();

        // 2
        List<int[]> times = new ArrayList<>();
        for (Interval interval : intervals) {
            times.add(new int[] {interval.start, 1});
            times.add(new int[] {interval.end, -1});
        }

        times.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]); // Don't want start times mixing with the end times

        int result = 0, counter = 0;
        for (int[] i : times) {
            counter += i[1];
            result = Math.max(counter, result);
        }
        return result;
    }
}
