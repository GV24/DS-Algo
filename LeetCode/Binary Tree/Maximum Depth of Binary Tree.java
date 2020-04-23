/*
Given a binary tree, find its maximum depth.
*/

class Solution {
    public int maxDepth(TreeNode root) {
        
        return DFS( root, 1 );
    }
    
    int DFS( TreeNode root, int sum )
    {
        if ( root == null )
            return 0;
        
        int leftRet = 0, rightRet = 0;
        
        if ( root.left == null && root.right == null )
            return sum;
        
        if ( root.left != null )
        {
            leftRet = DFS(root.left, sum + 1);
            leftRet = leftRet > sum ? leftRet : sum;
        }
        if ( root.right != null )
        {
            rightRet = DFS(root.right, sum + 1);
            rightRet = rightRet > sum ? rightRet : sum;
        }
        return leftRet > rightRet ? leftRet : rightRet;
    }
}