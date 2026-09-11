class Solution {
    public boolean canJump(int[] nums) {
        // Easy way is to do a dp solution

        // Optimization is to keep in mind a "range" of possibilities of where we can jump
        int l = 0, r = 0;
        while (l <= r) {
            // Go through l + r, and then find best jump forward
            int prevr = r;
            for (int i = l; i <= prevr; i++) {
                r = Math.max(r, i + nums[i]);
            }
            if (r >= nums.length - 1) return true;
            l = prevr + 1;
        }
        return false;

        // Optimization 2: Have a "barrier" of when we reach the end that continuously goes down
        // int goal = nums.length - 1;
        // for (int i = nums.length - 2; i >= 0; i--)
        //     if (i + nums[i] >= goal) goal = i;
        // return goal == 0;
    }
}
