/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int countDfs(TreeNode cur, int largestSoFar) {
        if (cur == null) return 0;
        int sol = 0;
        if (cur.val >= largestSoFar)
            sol++;
        return sol + countDfs(cur.left, Math.max(largestSoFar, cur.val)) + countDfs(cur.right, Math.max(largestSoFar, cur.val));
    }
    public int goodNodes(TreeNode root) {
        return countDfs(root, Integer.MIN_VALUE);
    }
}
