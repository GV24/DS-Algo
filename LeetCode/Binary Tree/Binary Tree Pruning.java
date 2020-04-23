/*
Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
*/

class Solution {
    public TreeNode pruneTree(TreeNode root) {
        
        if ( root == null )
            return null;
        
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        
        if ( root.val == 0 && root.left == null && root.right == null )
            return null;
        
        return root;
    }
}