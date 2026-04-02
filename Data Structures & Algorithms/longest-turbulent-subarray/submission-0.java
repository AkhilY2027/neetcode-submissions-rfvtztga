class Solution {
    public int maxTurbulenceSize(int[] arr) {
        // Basically, goes up then down then up again – that sort of pattern

        // Can probably do a two pointer approach through the array?
            // Where we increment right so long as it goes up and down
            // Always >= 2 since two always works
            // Upon finding our limits, left will become right + 1 and right will become left + 1

        // if (arr.length == 1) return 1;

        // // 1. Have to set l and r such that they're on elements that aren't equal
        // int l = 0, r = 1;
        // int sol = 2;
        // while (r < arr.length && arr[r] == arr[l]) {
        //     r++;
        // }
        // l = r - 1;
        // boolean checkForDown = false;
        // if (r < arr.length) checkForDown = (arr[r] - arr[l]) > 0;
        // else return sol;

        // // 2. Two Pointer through array
        // while (r < arr.length) {
        //     // See if we can increment r
        //     if ((checkForDown && arr[r] < arr[l]) || (!checkForDown && arr[r] > arr[l])) {
        //         r++;
        //         checkForDown = !checkForDown;
        //         sol = Math.max(sol, r - l + 1);
        //     }
        //     else {
        //         // Otherwise, have found a barrier – See if we can do more beyond this
        //         l = r + 1;
        //         r = l + 1;
        //         while (r < arr.length && arr[r] == arr[l]) {
        //             r++;
        //         }
        //         l = r - 1;
        //         if (r < arr.length) checkForDown = (arr[r] - arr[l]) > 0;
        //         else return sol;
        //     }
        // }
        // return sol;

        // Better attempt for sliding window
            // Split into three cases:
            // 1. Last was up
            // 2. Last was down
            // 3. Last was equal
        
        int l = 0, r = 1, sol = 1;
        int prev = 0; // 0 is equal, 1 is greater, 2 is lesser

        while (r < arr.length) {
            if (arr[r - 1] > arr[r] && prev != 1) {
                sol = Math.max(sol, r - l + 1);
                r++;
                prev = 1;
            }
            else if (arr[r - 1] < arr[r] && prev != 2) {
                sol = Math.max(sol, r - l + 1);
                r++;
                prev = 2;
            }
            else {
                // We have an equals/constant down/up case – Need to go to next possible section
                r = (arr[r] == arr[r - 1]) ? r + 1 : r;
                l = r - 1;
                prev = 0;
            }
        }
        return sol;
    }
}