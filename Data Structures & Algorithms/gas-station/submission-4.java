class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            // Basically, check at each possible index
            int cur_gas = 0;
            for (int j = 0; j < gas.length; j++) {
                cur_gas += gas[(i + j) % gas.length];
                cur_gas -= cost[(i + j) % gas.length];
                if (cur_gas < 0) break;
            }
            if (cur_gas >= 0) return i;
        }
        return -1;
    }
}
