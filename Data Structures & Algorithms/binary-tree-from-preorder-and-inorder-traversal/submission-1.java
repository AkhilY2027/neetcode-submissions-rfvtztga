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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;

        // First value of preorder list is root
        TreeNode root = new TreeNode(preorder[0]);

        // Find the root within inorder - splits into left and right
        int found = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                found = i;
                break;
            }
        }

        // Will split at same point within both inorder and preorder
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, found + 1), Arrays.copyOfRange(inorder, 0, found));
        root.right = buildTree(Arrays.copyOfRange(preorder, found + 1, preorder.length), Arrays.copyOfRange(inorder, found + 1, inorder.length));
        return root;
    }
}
