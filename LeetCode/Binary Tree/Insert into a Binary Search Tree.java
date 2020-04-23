class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        TreeNode node = root;
        
        while ( node != null )
        {
            if ( val > node.val ){
                if ( node.right == null )
                    {node.right = new TreeNode(val); break;}
                else
                    {node = node.right; continue;}}
            
            if ( val < node.val ){
                if ( node.left == null )
                    {node.left = new TreeNode(val); break;}
                else
                    {node = node.left; continue;}}
        }
        
        return root;
    }
}