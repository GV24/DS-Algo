class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> retList = new ArrayList<>();
        if ( root == null )
            return retList;
        
        Queue<TreeNode> q = new ArrayDeque<>();
        TreeNode node = null;
        q.add(root);
        int nodes_in_this_level = 1;
        int nodes_in_next_level = 0;
        
        List<Integer> list = new ArrayList<>();
        
        while ( !q.isEmpty() )
        {
            node = q.poll();
            if ( node != null )
                list.add(node.val);
            --nodes_in_this_level;
            
            if ( node.left != null )
            {
                q.add(node.left);
                ++nodes_in_next_level;
            }
            
            if ( node.right != null )
            {
                q.add(node.right);
                ++nodes_in_next_level;
            }
            
            if ( nodes_in_this_level == 0 )
            {
                nodes_in_this_level = nodes_in_next_level;
                nodes_in_next_level = 0;
                retList.add(list);
                list = new ArrayList<>();
            }
        }
        return retList;
    }
}