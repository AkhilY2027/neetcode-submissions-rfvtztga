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
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, 
            (a,b) -> a.end - b.end
        );
        // Now, run through the sorted intervals and see if it can work
        int line = 0;
        for (Interval interval : intervals) {
            if (interval.start < line)
                return false;
            line = interval.end;
        }
        return true;
    }
}
