/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        // Easy Solution: Binary Search
        // int l = 1, r = n;
        // if (guess(r) == 0)
        //     return r;
        // if (guess(l) == 0)
        //     return l;
        // while (l <= r) {
        //     int mid = (l + r) / 2;
        //     int where = guess(mid);
        //     if (where == 0)
        //         return mid;
        //     else if (where == -1)
        //         r = mid - 1;
        //     else
        //         l = mid + 1;
        // }
        // return -1;

        // Possible Optimization: Tertiary Search – Do three at a time
        int l = 1, r = n;
        while (true) {
            int lm = l + (r - l) / 3;
            int rm = r - (r - l) / 3;
            int glm = guess(lm), grm = guess(rm);
            if (glm == 0) return lm;
            else if (grm == 0) return rm;
            else if (glm + grm == 0) {
                l = lm + 1;
                r = rm - 1;
            }
            else if (glm == -1)
                r = lm - 1;
            else
                l = rm + 1;
        }
    }
}