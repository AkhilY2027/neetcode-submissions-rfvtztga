class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort by start and linearly go through
        Arrays.sort(intervals, 
            (a, b) -> Integer.compare(a[0], b[0])
        );
        List<int[]> sol = new ArrayList<>();
        
        sol.add(intervals[0]);
        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1], prevEnd = sol.get(sol.size() - 1)[1];
            if (start <= prevEnd)
                sol.get(sol.size() - 1)[1] = Math.max(end, prevEnd);
            else
                sol.add(new int[] {start, end});
        }
        return sol.toArray(new int[sol.size()][]);
    }
}
