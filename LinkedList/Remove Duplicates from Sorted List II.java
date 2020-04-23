/* Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. */

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode node = new ListNode(-1);
        ListNode root = node;
        node.next = head;
        ListNode itr = head;
        
        while ( itr != null )
        {
            while ( itr.next != null && itr.val == itr.next.val )
                itr = itr.next;
            
            if ( node.next != itr )
                node.next = itr.next;
            else
            {
                node = node.next;
            }
            
            itr = itr.next;
        }
        
        return root.next;
    }
}