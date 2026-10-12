class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // Take cars from greatest position to least position
            // For every car, see if the car next in line would catch up – this would be considered one "fleet"
            // Easiest way to do this is with a stack, as we can easy find the last car fleet we added
        int[][] cars = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0])); // Reverse order, greatest to least
        
        Stack<Double> stack = new Stack<>(); // This stores the hours it takes for a car to reach the target
        for (int[] car : cars) {
            stack.push((double) (target - car[0]) / car[1]);
            if (stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2))
                stack.pop(); // If the car here is faster than the car before, then the fleet combines
        }
        return stack.size();
    }
}
