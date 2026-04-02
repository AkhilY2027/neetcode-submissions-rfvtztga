class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];
        boolean added = false;
        for (int[] interval : intervals) {
            // Basically, find what intervals trigger - If not, just add
            if (start > interval[1]) {
                list.add(interval); // No overlap, but less than new interval
            }
            else if (end < interval[0]) {
                if (!added) {
                    added = true;
                    list.add(new int[] {start, end});
                }
                list.add(interval); // No overlap, but greater than new interval
            }
            else {
                // Collides
                start = Math.min(interval[0], start);
                end = Math.max(interval[1], end);
            }
        }
        if (!added) {
            added = true;
            list.add(new int[] {start, end});
        }
        return list.toArray(new int[list.size()][2]);
    }
}
