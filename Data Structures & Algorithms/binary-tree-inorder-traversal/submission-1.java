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
    private void inorderSearch(TreeNode curNode, List<Integer> sol) {
        if (curNode == null)
            return;

        inorderSearch(curNode.left, sol);
        sol.add(curNode.val);
        inorderSearch(curNode.right, sol);
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        // Inorder: Left -> Center -> Right
        List<Integer> sol = new ArrayList<>();
        inorderSearch(root, sol);
        return sol;
    }
}