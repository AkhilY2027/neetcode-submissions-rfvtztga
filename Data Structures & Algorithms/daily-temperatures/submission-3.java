class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Just use a stack to store temps that have yet to see a higher temp day
        int[] sol = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>(); // Store temp and index

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > stack.peek()[0]) {
                int[] lowTemp = stack.pop();
                sol[lowTemp[1]] = i - lowTemp[1];
            }
            stack.push(new int[] {temperatures[i], i});
        }
        return sol;
    }
}
