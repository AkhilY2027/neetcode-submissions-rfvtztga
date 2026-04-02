class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Brute Force:
        // for (int i = 0; i < gas.length; i++) {
        //     // Basically, check at each possible index
        //     int cur_gas = 0;
        //     for (int j = 0; j < gas.length; j++) {
        //         cur_gas += gas[(i + j) % gas.length];
        //         cur_gas -= cost[(i + j) % gas.length];
        //         if (cur_gas < 0) break;
        //     }
        //     if (cur_gas >= 0) return i;
        // }

        int n = gas.length;

        // Sliding Window
        // int start = n-1, end = 0;
        // int tank = gas[start] - cost[start];
        // while (start > end) {
        //     if (tank < 0) {
        //         // We know that wherever we are at, the gas does not cover the distance
        //             // Thus, we want to go back one station and see if the tank will hold up then
        //         start--;
        //         tank += gas[start] - cost[start];
        //     }
        //     else {
        //         // Otherwise, we know that the gas will cover the cost - thus, we go for one more trip
        //         tank += gas[end] - cost[end];
        //         end++;
        //     }
        // }
        // return tank >= 0 ? start : -1;

        // Finally, greedy:
            // On condition that gas within gas stations is more than the sum of the costs,
            //  then just need to find which gas station has enough gas to cover the trip
        
        int gas_size = 0, cost_size = 0;
        for (int i = 0; i < n; i++) {
            gas_size += gas[i];
            cost_size += cost[i];
        }
        if (gas_size < cost_size) return -1; // Otherwise, we know that there should be a way for it to work out

        int index = 0, cur = 0;
        for (int i = 0; i < n; i++) {
            cur += gas[i] - cost[i];
            if (cur < 0) {
                index = i + 1;
                cur = 0;
            }
        }
        return index;


        // int max_tank = Integer.MIN_VALUE, max_index = 0;
        // int[] changes = new int[n];
        // for (int i = 0; i < n; i++) {
        //     changes[i] = gas[i] - cost[i];
        //     if (changes[i] > max_tank) {
        //         max_tank = changes[i];
        //         max_index = i;
        //     }
        // }
        // if (max_tank < 0) return -1;

        // // Now, check
        // int index_to_check = (max_index + 1) % n;
        // while (index_to_check != max_index) {
        //     max_tank += changes[index_to_check];
        //     if (max_tank < 0) return -1;
        // }
        // return max_index;
    }
}
