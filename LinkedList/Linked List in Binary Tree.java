/*Return True if all the elements in the linked list starting from the head correspond to some downward path connected in the binary tree otherwise return False.*/

class Solution {
    
    public boolean isSubPath(ListNode head, TreeNode root)
    {
        if ( head == null )
            return true;
        
        if ( root == null )
            return false;
        
        boolean matched = false;
        
        if ( root.val == head.val )
            matched = true;
        
        if ( matched )
            matched = matched && (dfs( head.next, root.left ) ||
            dfs( head.next, root.right ));
        
        return matched || isSubPath(head, root.left) || isSubPath(head, root.right);
        
    }
    
    private boolean dfs(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        return head.val == root.val && (dfs(head.next, root.left) || dfs(head.next, root.right));
    }
    
}