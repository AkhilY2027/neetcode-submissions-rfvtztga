class Solution {
    public int maxArea(int[] heights) {
        // Distance between points * min height between points
        // Maybe start at endpoints and continuously work our way down?
            // The one with less height moves
        int l = 0;
        int r = heights.length - 1;
        int maxArea = 0;
        while (l < r) {
            maxArea = Math.max(maxArea, (r - l) * Math.min(heights[l], heights[r]));

            // And then move the one that's shorter
            if (heights[l] < heights[r]) l++;
            else r--;
        }
        return maxArea;
    }
}
