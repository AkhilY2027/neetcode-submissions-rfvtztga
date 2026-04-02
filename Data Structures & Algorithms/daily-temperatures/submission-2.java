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
        // Stack<Integer> stack = new Stack<>();
        // for (int i = 0; i < temperatures.length; i++) {
        //     // If current element is greater than elements in stack, pop and set corresponding elements
        //     while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
        //         int p = stack.pop();
        //         sol[p] = (i - p);
        //     }

        //     // Add current index at end
        //     stack.add(i);
        // }

        // // Don't care about any at end – means there is no greater element after, so already set to 0
        // return sol;


        // Can also do a dp solution
        for (int i = temperatures.length - 2; i >= 0; i--) {
            int j = i + 1; // Traverse
            // Essentially, looking for the next index at which our temperature will be lower based on the next values found in array
                // Basically, if the next value is colder, we continuously add its value to our own
                    // Add the value so we don't check even colder values – go straight to warmer values
                // And if its warmer, the loop breaks, so we add that difference to our current index of i
            while (j < temperatures.length && temperatures[j] <= temperatures[i]) {
                if (sol[j] == 0) { // No more warmer values after this so cannot go further
                    j = temperatures.length;
                    break;
                }
                j += sol[j];
            }

            if (j < temperatures.length) {
                sol[i] = j - i;
            }
        }
        return sol;
    }
}
