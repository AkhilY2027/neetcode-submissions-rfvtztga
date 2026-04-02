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
    public boolean dfs(TreeNode cur, int target) {
        if (cur == null)
            return false;
        
        // Algo:
            // We return, for the parent's use, if the child node must be deleted
        boolean leftDelete = dfs(cur.left, target);
        if (leftDelete)
            cur.left = null;
        
        boolean rightDelete = dfs(cur.right, target);
        if (rightDelete)
            cur.right = null;
        
        if (cur.left == null && cur.right == null && cur.val == target)
            return true;
        else
            return false;
    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (dfs(root, target))
            return null;
        return root;
    }
}