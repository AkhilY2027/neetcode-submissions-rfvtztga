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
    public int dfs(TreeNode curNode, int[] best) {
        if (curNode == null) return 0;

        // Calculate best of first path:
        int leftSubtree = Math.max(0, dfs(curNode.left, best));
        int rightSubtree = Math.max(0, dfs(curNode.right, best));
        if (leftSubtree + rightSubtree + curNode.val > best[0])
            best[0] = leftSubtree + rightSubtree + curNode.val;
        
        // Then, return best single path
        return curNode.val + Math.max(leftSubtree, rightSubtree);
    }
    public int maxPathSum(TreeNode root) {
        // At each stage, either:
            // Path is left subtree -> treeNode -> right subtree
            // Or one of the subtrees + treeNode -> Continues in upper level
            // With all of these cases, don't have to add the subtrees if there is no path that is positive (since this includes negative numbers)
        int[] best = new int[1];
        best[0] = Integer.MIN_VALUE;
        int rootBest = dfs(root, best);
        return Math.max(best[0], rootBest);
    }
}
