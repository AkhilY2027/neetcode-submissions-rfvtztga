class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        // Basically, can find the greatest element in heights and for loop until then
            // Find the number of continguous elements that >= that height
        // O(n * m)
        int greatestHeight = 0;
        for (int i = 0; i < heights.length; i++) {
            greatestHeight = Math.max(greatestHeight, heights[i]);
        }

        int bestArea = 0;
        for (int curHeight = 1; curHeight <= greatestHeight; curHeight++) {
            int numContinguousElements = 0;
            int best = 0;
            for (int i = 0; i < heights.length; i++) {
                if (heights[i] >= curHeight) best++;
                else best = 0;
                numContinguousElements = Math.max(numContinguousElements, best);
            }
            bestArea = Math.max(bestArea, numContinguousElements * curHeight);
        }
        return bestArea;

        // Probably an O(n) algo that does this faster
    }
}
