class Solution {
    public int maxAncestorDiff(TreeNode root) {
        
        return DFS(root, root.val, root.val);
        
    }
    
    int DFS ( TreeNode node , int min, int max )
    {
        int diff = 0;
        int lmin = Math.min(node.val , min);
        int lmax = Math.max(node.val , max);
        
        if ( node.left != null )
            diff = DFS( node.left, lmin, lmax);
        
        if ( node.right != null )
            diff = Math.max( DFS( node.right, lmin, lmax), diff );
        
        return (lmax - lmin > diff) ? lmax - lmin : diff;
    }
    
}