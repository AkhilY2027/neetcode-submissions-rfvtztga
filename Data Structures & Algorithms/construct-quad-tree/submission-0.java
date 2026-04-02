/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    private Node dfs(int[][] grid, int n, int r, int c) {
        // Base Case 1:
        if (n == 1)
            return new Node(grid[r][c] == 1, true);

        // Split grid
        int m = n / 2;
        Node topLeft = dfs(grid, m, r, c);
        Node topRight = dfs(grid, m, r, c + m);
        Node bottomLeft = dfs(grid, m, r + m, c);
        Node bottomRight = dfs(grid, m, r + m, c + m);

        // Base Case 2:
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
            && topLeft.val == topRight.val && topLeft.val == bottomLeft.val && topLeft.val == bottomRight.val)
            return new Node(topLeft.val, true);
        
        // Not a leaf node, so make it a parent node
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
    public Node construct(int[][] grid) {
        // Basically, split the grid via dfs into four and continually see what values they are
            // We reach a leaf node if:
                // 1. Our current grid size is 1
                // 2. Our split grids all are leaves and have the same values
            // Thus, under these conditions, can construct the graph
        return dfs(grid, grid.length, 0, 0);
    }
}