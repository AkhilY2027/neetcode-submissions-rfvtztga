class Solution {
    public ArrayList<int[]> mergeSort(int[][] intervals, int a, int b) {
        // Base Case:
        if (a == b) {
            ArrayList<int[]> temp = new ArrayList<>();
            temp.add(intervals[a]);
            return temp;
        }

        // Basically, split and merge
        int mid = (a + b) / 2;
        ArrayList<int[]> temp1 = mergeSort(intervals, a, mid);
        ArrayList<int[]> temp2 = mergeSort(intervals, mid + 1, b);

        // Combine into one ArrayList
        ArrayList<int[]> sol = new ArrayList<>();
        int i = 0, j = 0, n = temp1.size(), m = temp2.size();
        while (i < n && j < m) {
            // First, check if overlapping - if not, find next element
                // Potential Problem - What if multiple elements overlapping?
                    // Does mergeSort take care of this by itself?
            int x1 = temp1.get(i)[0], y1 = temp1.get(i)[1];
            int x2 = temp2.get(j)[0], y2 = temp2.get(j)[1];

            if (x2 <= y1 && y1 >= x1) {
                // Overlapping - Merge
                sol.add(new int[] {Math.min(x1, x2), y2});
                i++;
                j++;
            }
            else if (y1 < x2) {
                // First is less
                sol.add(temp1.get(i));
                i++;
            }
            else {
                sol.add(temp2.get(j));
                j++;
            }
        }

        // Add any remaining elements
        while (i < n) {
            sol.add(temp1.get(i));
            i++;
        }

        while (j < m) {
            sol.add(temp2.get(j));
            j++;
        }
        return sol;
    }
    public int[][] merge(int[][] intervals) {
        // Merge sort?
        // ArrayList<int[]> temp = mergeSort(intervals, 0, intervals.length - 1);
        // return temp.toArray(new int[temp.size()][]);

        // Can also sort by the start value and then determine what values are overlapping
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> sol = new ArrayList<>();
        sol.add(intervals[0]);

        for (int[] interval : intervals) {
            int x1 = interval[0];
            int x2 = interval[1];
            int lastX = sol.get(sol.size() - 1)[1]; // Since we return in sorted order, we get the last x possible

            // Only need one check because we've sorted by start x values
                // So if our x value is less than a previous end x, then we're overlapping
            if (x1 <= lastX) {
                sol.get(sol.size() - 1)[1] = Math.max(lastX, x2);
            }
            else {
                sol.add(new int[] {x1, x2}); // Surpassed the current
            }
        }
        return sol.toArray(new int[sol.size()][]);
    }
}
