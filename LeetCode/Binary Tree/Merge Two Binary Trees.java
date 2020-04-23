/*
The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node.
*/
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        int sum = 0;
        if ( t1 == null && t2 != null )
        {
            t1 = new TreeNode(0);
        }
        if ( t1 == null && t2 == null)
            return null;
        
        if ( t1 != null )
            sum += t1.val;
        
        if ( t2 != null )
            sum += t2.val;
        
        
        
        if ( t2 != null && t1 != null)
        {
            if ( t1.left == null && t2.left != null )
            {
                t1.left = new TreeNode(0);
                mergeTrees(t1.left, t2.left);
            }
            else
                mergeTrees(t1.left, t2.left);
            
            if ( t1.right == null && t2.right != null )
            {
                t1.right = new TreeNode(0);
                mergeTrees(t1.right, t2.right);
            }
            else
                mergeTrees(t1.right, t2.right);
            
        }
        t1.val = sum;
        return t1;
    }
}