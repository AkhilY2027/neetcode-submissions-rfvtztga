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
    int longestPath;

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;

        int leftPath = dfs(root.left);
        int rightPath = dfs(root.right);
        longestPath = Math.max(leftPath + rightPath, longestPath);
        return Math.max(leftPath, rightPath) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        // Two possible longest paths on any node:
            // Left distance + right distance
            // Max(left, right) + tree before subtree root

        // Algo: Do a dfs to calculate these two values
            // Can set the longest path in a global variable that constantly updates
        longestPath = 0;
        dfs(root);
        return longestPath;
    }
}
