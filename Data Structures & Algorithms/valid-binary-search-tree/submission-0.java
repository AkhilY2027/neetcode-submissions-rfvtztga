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
    public boolean dfs(TreeNode curNode, int minNum, int maxNum) {
        // Basically, check if our nums are within the bounds
        if (curNode == null) return true;
        if (curNode.val <= minNum || curNode.val >= maxNum) return false;

        // Then, recur on left and right subtrees
        return dfs(curNode.left, minNum, curNode.val) && dfs(curNode.right, curNode.val, maxNum);
    }
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
