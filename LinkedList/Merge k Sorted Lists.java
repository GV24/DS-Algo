/* Merge k sorted linked lists and return it as one sorted list. */

class Solution {
    
    public ListNode mergeKLists( ListNode[] lists ){
        
        if ( lists.length == 0 || lists == null )
            return null;
        
        ListNode root = new ListNode(-1);
        ListNode curr = root;
        
        PriorityQueue<ListNode> q = 
            new PriorityQueue<>( lists.length, (a,b) -> Integer.compare(a.val,b.val) );
        
        for ( ListNode n : lists )
            if ( n != null )
                q.add(n);

        while ( q.size() > 0 )
        {
            curr.next = q.poll();
            curr = curr.next;
            if ( curr.next != null )
                q.add(curr.next);
            
        }
        return root.next;
    }
}