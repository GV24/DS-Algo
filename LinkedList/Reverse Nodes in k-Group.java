/*
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
*/

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        int cnt = 0;
        ListNode root = new ListNode(-1);
        ListNode curr = head;
        ListNode itr = root;
        ListNode starter = null;
        
        while ( true )
        {
            int i = 0;
            starter = curr;
            for ( i = 0; (i < k) && (curr != null); ++i )
            {
                curr = curr.next;
            }

            if ( i == k ){
                itr.next = reverse( starter , curr );
                itr = starter;
            }
            else{
                itr.next = starter;
            }
            
            if ( curr == null ) break;
        }
        
        return root.next;
    }
    
    public ListNode reverse( ListNode starter, ListNode ender )
    {
        ListNode curr = null;
        ListNode next = starter;
        ListNode itr = null;
        
        while ( next != ender )
        {
            itr = next.next;
            next.next = curr;
            curr = next;
            if ( itr == ender )
                break;
            next = itr;
        }
        
        return next;
    }
    
}