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
    public int size(TreeNode node) {
        if (node == null) return 0;
        return 1 + size(node.left) + size(node.right);
    }

    public int search(TreeNode node, int num) {
        // dfs
            // Maybe at each level, check if the k is in the left or right subtree
                // Basically, find the size of the left subtree and compare with k
        int check = num - size(node.left);
        if (check < 1) return search(node.left, num);
        else if (check == 1) return node.val;
        else return search(node.right, check - 1);
    }

    public int kthSmallest(TreeNode root, int k) {
        // Defintely a spin on the dfs?
        return search(root, k);
    }
}
