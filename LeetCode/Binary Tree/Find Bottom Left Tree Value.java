/*
Given a binary tree, find the leftmost value in the last row of the tree.
*/
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        
        int[] depth = new int[1];
        int[] level = new int[1];
        level[0] = -1;
        TreeNode node = null;
        
        DFS(root, depth, 0, level);
        
        return depth[0];
    }
    
    void DFS ( TreeNode root, int[] d, int level, int[] lvl )
    {
        if ( root == null )
            return;
        
        if ( level > lvl[0] )
        {
            d[0] = root.val;
            lvl[0] = level;
        }
        
        DFS ( root.left, d, level + 1, lvl );
        DFS ( root.right, d, level + 1, lvl );
    }
    
}