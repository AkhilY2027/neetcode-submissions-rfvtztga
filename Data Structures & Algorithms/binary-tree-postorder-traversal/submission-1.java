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
        if (curNode == null)
            return;

        dfs(curNode.left, sol);
        dfs(curNode.right, sol);

        sol.add(curNode.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        // Post order: Left -> Right -> Node
        List<Integer> sol = new ArrayList<>();
        dfs(root, sol);
        return sol;
    }
}