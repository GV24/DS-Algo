class Solution {
    public ListNode reverseList(ListNode head) {
        
        ListNode itr = head;
        ListNode next = null;
        ListNode prev = null;
        
        while ( itr != null )
        {
            next = itr.next;
            itr.next = prev;
            prev = itr;
            if ( next == null )
                break;
            itr = next;
        }
        return itr;
    }
}