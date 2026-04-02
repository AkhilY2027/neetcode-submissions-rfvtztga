class Solution {
    public int calHours(int target, int pos, int sped) {
        return (int) Math.ceil(((double) (target - pos)) / sped);
    }
    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 1) return 1;
        // Calculate all possible collissions and then calculate based on that map
            // Algo:
            // Sort – Find the cars that collide
                // No - Must recalculate collisions of car that was faster - No
                // Must eliminate the next collisions of those cars

        // List<int[]> cars = new ArrayList<>();
        // for (int i = 0; i < position.length; i++) {
        //     cars.add(new int[] {position[i], speed[i]});
        // }
        // cars.sort(Comparator.comparingInt((int[] a) -> a[0]).reversed());

        // // Cars are in descending order by position
        //     // Just go down the list and check if any collide before they reach the target
        //     // Count groups that way
        // int groups = 1;
        // int[] curGroupCar = cars.get(0);
        // for (int i = 1; i < cars.size(); i++) {
        //     int[] curCar = cars.get(i);
        //     // If this car cannot reach before the last car, then because the new curGroupCar
        //         // Otherwise, added as a new part of the group
        //     if (calHours(target, curGroupCar[0], curGroupCar[1]) > calHours(target, curCar[0], curCar[1])) {
        //         // This car will not reach the previous
        //         curGroupCar = curCar;
        //         groups++;
        //     }
        // }
        // return groups;

        int[][] cars = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, 
            (a, b) -> Integer.compare(b[0], a[0]) // Want reverse order
        );
        Stack<Double> stack = new Stack<>();
        for (int[] car : cars) {
            stack.push((double) (target - car[0]) / car[1]);
            if (stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2))
                stack.pop();
        }
        return stack.size();
    }
}
