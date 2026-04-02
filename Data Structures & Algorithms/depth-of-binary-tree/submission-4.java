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
    private int dfsDepth(TreeNode cur) {
        if (cur == null)
            return 0;
        
        return 1 + Math.max(dfsDepth(cur.left), dfsDepth(cur.right));
    }

    public int maxDepth(TreeNode root) {
        // Just do dfs and return max depth
        return dfsDepth(root);
    }
}
