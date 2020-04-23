class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        
        int[] res = new int[1];
        if ( root != null )
            DFS( root, res );
        return res[0];
    }
    
    int DFS ( TreeNode root, int[] min )
    {
        if ( root.left == null && root.right == null )
                return 0;
        
        int sum = 0;
        int leftH = 0;
        int rightH = 0;
        
        if ( root.left != null )
            leftH = DFS( root.left, min) + 1;
        if ( root.right != null )
            rightH = DFS( root.right, min) + 1;
        
        if ( min[0] < leftH + rightH )
            min[0] = leftH + rightH;
        
        return Math.max( leftH, rightH );
    }
}