class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        // Basically, can find the greatest element in heights and for loop until then
            // Find the number of continguous elements that >= that height
        // O(n * m) = O(n ^ 2)
        // int greatestHeight = 0;
        // for (int i = 0; i < heights.length; i++) {
        //     greatestHeight = Math.max(greatestHeight, heights[i]);
        // }

        // int bestArea = 0;
        // for (int curHeight = 1; curHeight <= greatestHeight; curHeight++) {
        //     int numContinguousElements = 0;
        //     int best = 0;
        //     for (int i = 0; i < heights.length; i++) {
        //         if (heights[i] >= curHeight) best++;
        //         else best = 0;
        //         numContinguousElements = Math.max(numContinguousElements, best);
        //     }
        //     bestArea = Math.max(bestArea, numContinguousElements * curHeight);
        // }
        // return bestArea;

        // Another inefficient way to do this using a stack
        Stack<Pair<Integer, Integer>> stack = new Stack<>(); // Left Index of Rectangle, Height
        stack.push(new Pair<>(0, heights[0]));
        int bestArea = 0;
        for(int i = 1; i < heights.length; i++) {
            // 1. Pop any numbers from the stack with heights greater than/equal to current height, and see how far they get
            int extendLeft = i; // To be index of how far current index rectangle can stretch back left
            while (!stack.isEmpty() && stack.peek().getValue() > heights[i]) {
                Pair<Integer, Integer> curPair = stack.pop();
                extendLeft = curPair.getKey();
                bestArea = Math.max(bestArea, curPair.getValue() * (i - curPair.getKey()));
            }

            // 2. Add current index's rectangle that can be formed
            stack.push(new Pair<>(extendLeft, heights[i]));
        }

        // If we're here and still have elements in the stack, that means these elements can be extended all the way to the end of this histogram
        while (!stack.isEmpty()) {
            Pair<Integer, Integer> curPair = stack.pop();
            bestArea = Math.max(bestArea, curPair.getValue() * (heights.length - curPair.getKey()));
        }

        return bestArea;


        // Loop through heights and find how much we can extend any given index's rectangle

        // Probably an O(n) algo that does this faster
            // Instead of doing every height, get the height based on every bar and then find how much each height can go
            // Essentially, want to find the left and right boundaries for each rectangle
        // Go from greatest height to least and remove any bars that cannot be extended further from consideration
        // Stack<Integer> stack = new Stack<>();
        // int bestArea = 0;
        // // Go through and add indices as long as they can "fit" in the current rectangle
        //     // If not, pop and check if the area is good
        // for (int i = 0; i <= heights.length; i++) {
        //     // Want this to happen when we find a height lesser + at end of line
        //         // This rectangle represents the greatest rectangle we can make with stack.peek() index
        //             // Since we can't extend this rectangle right any further because the height doesn't allow it
        //     while(!stack.isEmpty() && (i == heights.length || heights[stack.peek()] >= heights[i])) {
        //         int height = heights[stack.pop()];
        //         int width = stack.isEmpty() ? i : i - stack.peek() - 1; // Calculate width based on stack indices
        //         bestArea = Math.max(bestArea, height * width);
        //     }
        //     stack.push(i);
        // }
        // return bestArea;
    }
}
