/* Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive). */

class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        
        Queue<TreeNode> q = new ArrayDeque();
        q.add(root);
        TreeNode node = null;
        int sum = 0;
        
        while ( q.size() != 0 )
        {
            node = q.poll();
            
            if ( node.val <= L )
            {
                if ( node.val == L)
                    sum += node.val;
                if ( node.right != null )
                    q.add(node.right);
            }
            else if ( node.val >= R )
            {
                if ( node.val == R )
                    sum += node.val;
                if ( node.left != null )
                    q.add(node.left);
            }
            else if ( (node.val > L) && (node.val < R) )
            {
                sum += node.val;
                if ( node.left != null )
                    q.add(node.left);
                if ( node.right != null )
                    q.add(node.right);
            }
        }
        return sum;
    }
}