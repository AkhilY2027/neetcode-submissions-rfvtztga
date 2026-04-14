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
    public boolean validifyNode(TreeNode curNode, int leftBound, int rightBound) {
        if (curNode == null) return true;
        if (curNode.val >= leftBound && curNode.val <= rightBound)
            return validifyNode(curNode.left, leftBound, curNode.val - 1) && validifyNode(curNode.right, curNode.val + 1, rightBound);
        return false;
    }
    public boolean isValidBST(TreeNode root) {
        return validifyNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
