class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Can I instead calculate lower and then reverse it?
        int[] sol = new int[temperatures.length];

        // // Always know the last element will be 0
        //     // Then what about element before?
        // int localMax = temperatures[temperatures.length - 1];
        // for (int i = temperatures.length - 2; i >= 0; i--) {
        //     // Basically, if we have to change localMax, then there is no warmer temp beyond this
        //         // Else, have to calculate the days
        // }

        // Can use a stack to pop off lower temps for higher ones
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            // If current element is greater than elements in stack, pop and set corresponding elements
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int p = stack.pop();
                sol[p] = (i - p);
            }

            // Add current index at end
            stack.add(i);
        }

        // Don't care about any at end – means there is no greater element after, so already set to 0
        return sol;
    }
}
