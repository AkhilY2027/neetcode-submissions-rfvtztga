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
    private int dfs(TreeNode root, Map<TreeNode, Integer> dp) {
        if (root == null) return 0;
        if (dp.containsKey(root)) return dp.get(root);

        // Option 1
        int op1 = root.val;
        if (root.left != null) {
            op1 += dfs(root.left.left, dp);
            op1 += dfs(root.left.right, dp);
        }
        if (root.right != null) {
            op1 += dfs(root.right.left, dp);
            op1 += dfs(root.right.right, dp);
        }

        // Option 2
        int op2 = 0;
        op2 += dfs(root.left, dp);
        op2 += dfs(root.right, dp);

        // Return is best option between the two of them
        dp.put(root, Math.max(op1, op2));

        return dp.get(root);
    }
    public int rob(TreeNode root) {
        // DFS?
            // For every node, you either:
            // Rob this node, then move to a grand child node
            // Can rob any and all children node
                // In this case, we just recurse down to all the children node at once

            // Time Complexity for this is O(2^n) due to constantly revisiting nodes
                // Can cache each node to keep at O(n)
        
        Map<TreeNode, Integer> dp = new HashMap<>();
        return dfs(root, dp);
    }
}