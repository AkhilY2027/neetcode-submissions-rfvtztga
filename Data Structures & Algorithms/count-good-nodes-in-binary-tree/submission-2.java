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
    private int dfs(TreeNode cur, int maxValue) {
        if (cur == null) return 0;

        int numGood = 0;
        if (cur.val >= maxValue) return 1 + dfs(cur.left, cur.val) + dfs(cur.right, cur.val);
        else return dfs(cur.left, maxValue) + dfs(cur.right, maxValue);
    }
    public int goodNodes(TreeNode root) {
        // Basically want it increasing on the way down
        return dfs(root, Integer.MIN_VALUE);
    }
}
