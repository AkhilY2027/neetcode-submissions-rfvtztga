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
    private void dfs(TreeNode curNode, List<Integer> sol) {
        if (curNode == null) return;

        dfs(curNode.left, sol);
        sol.add(curNode.val);
        dfs(curNode.right, sol);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        // Inorder – left subtree, then node, then right subtree
        List<Integer> sol = new ArrayList<>();
        dfs(root, sol);
        return sol;
    }
}