class Solution {
    
    public int sumEvenGrandparent(TreeNode root) {
        int sum = 0;    
        if ( root == null)
            return 0;
        
        if ( root.val % 2 == 0)
        sum += getGrandChildSum(root);
        
        if ( root.left != null )
            sum += sumEvenGrandparent(root.left);
        
        if ( root.right != null )
            sum += sumEvenGrandparent(root.right);
        
        return sum ;
    }
    
    //Check for nodes grandchild and get their sum
    public static int getGrandChildSum(TreeNode node)
    {
        int sum = 0;
        
        if ( node.left != null ){
            if ( node.left.left != null )
                sum += node.left.left.val;
            
            if ( node.left.right != null )
                sum += node.left.right.val;
        }
        
        if ( node.right != null ){
            if ( node.right.left != null )
                sum += node.right.left.val;
            
            if ( node.right.right != null )
                sum += node.right.right.val;
        }
        return sum;
    }
        
}