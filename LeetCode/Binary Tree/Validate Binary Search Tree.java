class Solution {
    public boolean isValidBST(TreeNode root)
    {
        if ( root == null )
            return true;
        
        return validateTree( root, Long.MIN_VALUE, Long.MAX_VALUE );
    }
    
    boolean validateTree(TreeNode root, long min, long max )
    {
        if ( root == null )
            return true;
        
        if ( root.val >= max || root.val <= min )
            return false;
        
        return validateTree ( root.left, min, root.val )  && validateTree ( root.right, root.val, max );
        
    }
}