class Solution {
    
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target)
    {
        TreeNode res = null;
        if ( original == null)
            return null;
        
        if ( original == target )
            return cloned;
        
        if ( original.left != null)
            if ( (res = getTargetCopy(original.left, cloned.left, target)) != null )
                return res;
        if ( original.right != null)
            if ( (res = getTargetCopy(original.right, cloned.right, target)) != null )
                return res;
        
        return res;
    }
}