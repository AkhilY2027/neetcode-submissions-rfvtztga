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
    public TreeNode dfs(TreeNode cur, TreeNode p, TreeNode q) {
        // System.out.println("Current TreeNode: " + cur.val);
        if (cur.val < p.val && cur.val < q.val) return dfs(cur.right, p, q); // Both in right side of bst
        if (cur.val > p.val && cur.val > q.val) return dfs(cur.left, p, q); // Same for left

        // Now, if we are here, we split on this node in two separate directions
        return cur;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Lowest Common Ancestor is when both of them split into different routes
            // Or one is node itself and the other goes down a path
        return dfs(root, p, q);
    }
}
