class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // DP or Greedy works
            // For Greedy, sort by ends and then delete those that overlap
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));
        int sol = 0;
        int endPointer = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (endPointer > intervals[i][0]) sol++; // Since this overlaps – delete this interval
            else endPointer = intervals[i][1];
        }
        return sol;
    }
}
