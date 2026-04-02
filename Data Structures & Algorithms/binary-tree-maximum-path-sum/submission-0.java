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
    // Problem with this:
        // The best value is not the value to return at every point
        // Say a subtree has three elements, and all three make best sum
        // But for the level above, can only return root of subtree + either left or right node
            // But this function does not return this behavior
    
    // public Pair<Integer, Boolean> dfs(TreeNode cur) {
    //     if (cur == null) return new Pair<>(0, false);
    //     // Get left and right best sums as well
    //         // For each level, return best sum found in subtree + If subtree can be connected to curNode
    //     Pair<Integer, Boolean> left = dfs(cur.left);
    //     Pair<Integer, Boolean> right = dfs(cur.right);

    //     int maxVal = 0;
    //     boolean connected = true;
    //     if (left.getValue() && right.getValue()) {
    //         if (left.getKey() + right.getKey() + cur.val >= maxVal) {
    //             connected = true;
    //             maxVal = left.getKey() + right.getKey() + cur.val;
    //         }
    //     }
    //     else if (left.getValue()) {
    //         if (left.getKey() >= maxVal) {
    //             maxVal = left.getKey();
    //             connected = false;
    //         }
    //         if (left.getKey() + cur.val >= maxVal) {
    //             maxVal = left.getKey() + cur.val;
    //             connected = true;
    //         }
    //     }
    //     else if (right.getValue()) {
    //         if (right.getKey() >= maxVal) {
    //             maxVal = right.getKey();
    //             connected = false;
    //         }
    //         if (right.getKey() + cur.val >= maxVal) {
    //             maxVal = right.getKey() + cur.val;
    //             connected = true;
    //         }
    //     }
    //     else {
    //         // Both aren't connected
    //         if (left.getKey() > cur.val || right.getKey() > cur.val) {
    //             maxVal = Math.max(left.getKey(), right.getKey());
    //             connected = false;
    //         }
    //         else {
    //             maxVal = cur.val;
    //             connected = true;
    //         }
    //     }
    //     return new Pair<>(maxVal, connected);
    // }

    public int sol = Integer.MIN_VALUE;

    public int betterDFS(TreeNode cur) {
        if (cur == null) return 0;

        // At every level, check if subtree is better than our original solution
            // If so, we're going to replace sol with it
        
        int left = Math.max(betterDFS(cur.left), 0); // Either the path is good or we don't add it
        int right = Math.max(betterDFS(cur.right), 0);

        sol = Math.max(sol, cur.val + left + right);
        return cur.val + Math.max(left, right); // Return the best path possible to the level above
    }
    public int maxPathSum(TreeNode root) {
        // Basically, just want to get all positive nodes that are connected and add them
        // return dfs(root).getKey();
        betterDFS(root);
        return sol;
    }
}
