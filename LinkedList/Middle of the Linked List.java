class Solution {
    public ListNode middleNode(ListNode head) {
        
        ListNode midl = head;
        ListNode last = head;
        int lastCnt = 0;
        
        while ( last != null )
        {
            lastCnt++;
            last = last.next;
            
            if ( (lastCnt & 1) != 1 )
            {
                midl = midl.next;
            }
        }
        return midl;
    }
}