class Solution {
    
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        if ( head == null )
            return null;
        
        int length = 0;
        ListNode node = head;
        
        while ( node != null )
        {
            node = node.next;
            length++;
        }
        
        if ( length == 1 || length == 0 )
            return null;
        
        node = head;
        int jmps = length - n - 1;
        
        while ( jmps > 0 )
        {
            node = node.next;
            jmps--;
        }
        
        if ( jmps < 0 )
            head = node.next;
        else
            node.next = node.next.next;
        
        return head;
    }
}