class Solution {
    
    int sum = 0;
    int maxLevel = 0;
    
    public int deepestLeavesSum(TreeNode root) {
        getSum(root, 0);
        return sum;
    }
    
    public void getSum(TreeNode root, int level)
    {
        boolean hasChildren = false;
        
        if ( root == null )
            return ;
        
        if ( (root.left != null) || (root.right != null) )
            hasChildren = true;
        
        if ( !hasChildren )
        {
            if ( level > maxLevel ){
                sum = root.val;
                maxLevel = level;
            }else if  (level == maxLevel )
                sum += root.val;
        }else{
            getSum(root.left, level + 1); getSum(root.right, level + 1);
        }
    }
}