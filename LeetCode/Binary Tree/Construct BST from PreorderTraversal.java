class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode itr = root;
        
        for ( int i = 1; i < preorder.length; ++i )
        {
            itr = root;
            while ( true )
            {
                if ( preorder[i] < itr.val ) {
                    if ( itr.left == null )
                    {
                        itr.left = new TreeNode(preorder[i]);
                        break;
                    }
                    else
                        itr = itr.left;
                }
                else
                {
                    if ( itr.right == null )
                    {
                        itr.right = new TreeNode(preorder[i]);
                        break;
                    }
                    else
                        itr = itr.right;
                }
            }
        }
        return root;
    }
}