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
    private int longestPath = 0;

    public int returnPathLength(TreeNode curNode) {
        if (curNode.left == null && curNode.right == null) return 0;

        int leftLongest = 0, rightLongest = 0;
        if (curNode.left != null) leftLongest = 1 + returnPathLength(curNode.left);
        if (curNode.right != null) rightLongest = 1 + returnPathLength(curNode.right);

        longestPath = Math.max(longestPath, leftLongest + rightLongest);

        return Math.max(leftLongest, rightLongest);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        // Possible paths to compare: Longest paths between children connected
            // Then, root + longest path
        returnPathLength(root);
        return longestPath;
    }
}
