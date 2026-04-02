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
    }
}
