class Solution {
    public int getDecimalValue(ListNode head) {
        
        int ans = 0;
        ListNode node = head;
        while( node != null )
        {
            ans =  ans * 2 + node.val;
            node = node.next;
        }
        return ans;
    }
}