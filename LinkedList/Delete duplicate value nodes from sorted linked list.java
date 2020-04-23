static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {

    SinglyLinkedListNode node = head;
    SinglyLinkedListNode sameNode = head.next;
    boolean isSame = false;
    
    while( (node.next != null) && (node != null ) )
    {
        sameNode = node.next;

        if(sameNode.data == node.data)
        {
           node.next = sameNode.next;
           continue;
        }
        node = node.next;
    }
    return head;
}