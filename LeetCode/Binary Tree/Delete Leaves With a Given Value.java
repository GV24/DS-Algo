/*
Given a binary tree root and an integer target, delete all the leaf nodes with value target.
*/

class Solution {
    
    static int tar;

    static boolean processTree( TreeNode root)
    {
        TreeNode node = root;
        
        boolean delThisNode = false;
        
        if ( node == null)
            return false;
        
        if ( processTree(node.left) )
            node.left = null;
        
        if ( processTree(node.right) )
            node.right = null;
        
        if ( node.val == tar && node.left == null && node.right == null)
            delThisNode = true;
        
        return delThisNode;
    }
    
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        tar = target;
        if(processTree(root))
            return null;
        return root;
    }
}