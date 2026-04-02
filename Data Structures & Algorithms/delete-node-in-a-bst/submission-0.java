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
    public TreeNode deleteNode(TreeNode root, int key) {
        // 1. Search for the node
        if (root == null) return null;

        TreeNode parent = null;
        TreeNode curNode = root;
        while (curNode != null && curNode.val != key) {
            parent = curNode;
            if (key < curNode.val)
                curNode = curNode.left;
            else
                curNode = curNode.right;
        }
        if (curNode == null) return root;

        // 2. Replace node
            // In case of only one/no child, replace with that subtree
        if (curNode.left == null || curNode.right == null) {
            TreeNode childToReplace = curNode.left == null ? curNode.right : curNode.left;
            if (parent == null) return childToReplace;
            if (parent.left == curNode)
                parent.left = childToReplace;
            else
                parent.right = childToReplace;
        }
        else {
            // In case of two children, replace node with "inorder successor"
                // The inorder successor is the leftmost node in the right subtree
            TreeNode successorParent = null;
            TreeNode successor = curNode.right;
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }
            
            // Then, need to replace trees
                // If inorder successor is not directly right of node to delete, can set the successor's parent's left pointer to successor's right child
                    // Then, set successor's right to node to delete's right – This sets the right subtree
                // Then, set inorder successor's left to deleted node's left – This sets the left subtree

            if (successorParent != null) {
                successorParent.left = successor.right;
                successor.right = curNode.right;
            }
            successor.left = curNode.left;
            
            // Finally, update node to delete's parent's pointer to successor
            if (parent == null) return successor;
            if (parent.left == curNode)
                parent.left = successor;
            else
                parent.right = successor;
        }
        return root;
    }
}